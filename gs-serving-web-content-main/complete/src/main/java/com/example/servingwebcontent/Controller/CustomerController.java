package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.model.CartItem;
import com.example.servingwebcontent.model.OrderHistory;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CustomerController {

    private final ProductDAO productDAO = new ProductDAOImpl();

    @GetMapping("/customer/home")
    public String showCustomerHome(HttpSession session, Model model,
                                   @RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "minPrice", required = false) Double minPrice,
                                   @RequestParam(value = "maxPrice", required = false) Double maxPrice) {

        User user = (User) session.getAttribute("user");
        if (user == null || !"customer".equalsIgnoreCase(user.getRole())) return "redirect:/login";

        List<Product> products = productDAO.getAllProducts();

        if (keyword != null && !keyword.isEmpty()) {
            products = products.stream()
                    .filter(p -> p.getProductName().toLowerCase().contains(keyword.toLowerCase())
                            || p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (minPrice != null) {
            products = products.stream().filter(p -> p.getPrice() >= minPrice).collect(Collectors.toList());
        }

        if (maxPrice != null) {
            products = products.stream().filter(p -> p.getPrice() <= maxPrice).collect(Collectors.toList());
        }

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();

        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        model.addAttribute("userForm", user);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "customer_home";
    }

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam(value = "qty", defaultValue = "1") int qty,
                            HttpSession session) {
        Product product = productDAO.getProductById(productId);
        if (product == null || qty < 1) return "redirect:/customer/home";

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getProductId() == productId) {
                item.setQuantity(item.getQuantity() + qty);
                found = true;
                break;
            }
        }
        if (!found) cart.add(new CartItem(product, qty));

        session.setAttribute("cart", cart);
        return "redirect:/customer/home";
    }

    @GetMapping("/cart/decrease")
    public String decreaseQuantity(@RequestParam("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getProductId() == productId) {
                    if (item.getQuantity() > 1) item.setQuantity(item.getQuantity() - 1);
                    else iterator.remove();
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/customer/home";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getProductId() == productId);
            session.setAttribute("cart", cart);
        }
        return "redirect:/customer/home";
    }

    @PostMapping("/cart/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/customer/home";
    }

    @PostMapping("/cart/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null || cart == null || cart.isEmpty()) return "redirect:/customer/home";

        model.addAttribute("items", cart);
        model.addAttribute("user", user);
        model.addAttribute("total", cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum());
        session.setAttribute("checkoutItems", cart);
        return "confirm_order";
    }

    @PostMapping("/cart/confirm/submit")
    public String submitOrder(@RequestParam String fullName,
                              @RequestParam String phone,
                              @RequestParam String address,
                              @RequestParam(required = false) String note,
                              HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<CartItem> checkoutItems = (List<CartItem>) session.getAttribute("checkoutItems");
        if (user == null || checkoutItems == null || checkoutItems.isEmpty()) return "redirect:/customer/home";

        user.setFullName(fullName);
        user.setPhone(phone);
        user.setAddress(address);
        session.setAttribute("user", user);

        for (CartItem item : checkoutItems) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            if (product.getStock() < item.getQuantity()) {
                model.addAttribute("error", "Không đủ hàng cho sản phẩm: " + product.getProductName());
                model.addAttribute("items", checkoutItems);
                model.addAttribute("user", user);
                model.addAttribute("total", checkoutItems.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum());
                return "confirm_order";
            }
        }

        for (CartItem item : checkoutItems) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            product.setStock(product.getStock() - item.getQuantity());
            productDAO.updateProduct(product);
        }

        List<OrderHistory> orderHistory = (List<OrderHistory>) session.getAttribute("orderHistory");
        if (orderHistory == null) orderHistory = new ArrayList<>();

        List<CartItem> orderCopy = checkoutItems.stream()
                .map(i -> new CartItem(i.getProduct(), i.getQuantity()))
                .collect(Collectors.toList());

        double total = orderCopy.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();

        OrderHistory newOrder = new OrderHistory(fullName, phone, address, orderCopy, total, new Date());
        orderHistory.add(newOrder);
        session.setAttribute("orderHistory", orderHistory);

        model.addAttribute("items", orderCopy);
        model.addAttribute("user", user);
        model.addAttribute("total", total);
        model.addAttribute("note", note);

        session.removeAttribute("checkoutItems");
        return "order_summary";
    }

    @PostMapping("/cart/buynow")
    public String buyNow(@RequestParam("productId") int productId,
                         @RequestParam(value = "qty", defaultValue = "1") int qty,
                         HttpSession session, Model model) {
        Product product = productDAO.getProductById(productId);
        User user = (User) session.getAttribute("user");

        if (product == null || qty < 1 || user == null || product.getStock() < qty) {
            return "redirect:/customer/home";
        }

        List<CartItem> buyNowItems = List.of(new CartItem(product, qty));
        session.setAttribute("checkoutItems", buyNowItems);

        model.addAttribute("items", buyNowItems);
        model.addAttribute("user", user);
        model.addAttribute("total", qty * product.getPrice());
        return "confirm_order";
    }

    @GetMapping("/order/history")
    public String viewOrderHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<OrderHistory> orderHistory = (List<OrderHistory>) session.getAttribute("orderHistory");
        if (orderHistory == null) orderHistory = new ArrayList<>();

        model.addAttribute("orderHistory", orderHistory);
        return "order_history";
    }
}
