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

    @GetMapping("/cart/add-ajax")
    @ResponseBody
    public Map<String, Object> addToCartAjax(@RequestParam("productId") int productId,
                                             @RequestParam(value = "qty", defaultValue = "1") int qty,
                                             HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Product product = productDAO.getProductById(productId);
        if (product == null || qty < 1) {
            response.put("success", false);
            response.put("message", "Sản phẩm không tồn tại hoặc số lượng không hợp lệ.");
            return response;
        }

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

        response.put("success", true);
        response.put("message", "Đã thêm vào giỏ hàng.");
        return response;
    }

    @GetMapping("/cart/decrease-ajax")
    @ResponseBody
    public Map<String, Object> decreaseAjax(@RequestParam("productId") int productId, HttpSession session) {
        Map<String, Object> res = new HashMap<>();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Iterator<CartItem> it = cart.iterator();
            while (it.hasNext()) {
                CartItem item = it.next();
                if (item.getProduct().getProductId() == productId) {
                    if (item.getQuantity() > 1) item.setQuantity(item.getQuantity() - 1);
                    else it.remove();
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }
        res.put("success", true);
        return res;
    }

    @GetMapping("/cart/remove-ajax")
    @ResponseBody
    public Map<String, Object> removeAjax(@RequestParam("productId") int productId, HttpSession session) {
        Map<String, Object> res = new HashMap<>();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getProductId() == productId);
            session.setAttribute("cart", cart);
        }
        res.put("success", true);
        return res;
    }

    @PostMapping("/cart/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/customer/home";
    }

    @PostMapping("/cart/checkout-selected")
    public String checkoutSelected(@RequestParam(value = "selectedItems", required = false) List<Integer> selectedItemIds,
                                   HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) return "redirect:/customer/home";

        if (selectedItemIds == null || selectedItemIds.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn ít nhất một sản phẩm để thanh toán.");
            model.addAttribute("cart", cart);
            model.addAttribute("total", cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum());
            model.addAttribute("userForm", user);
            return "customer_home";
        }

        List<CartItem> selectedItems = cart.stream()
                .filter(item -> selectedItemIds.contains(item.getProduct().getProductId()))
                .collect(Collectors.toList());

        double total = selectedItems.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();

        session.setAttribute("checkoutItems", selectedItems);
        model.addAttribute("items", selectedItems);
        model.addAttribute("user", user);
        model.addAttribute("total", total);

        return "confirm_order";
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

        if (product == null || qty < 1 || user == null) {
            return "redirect:/customer/home";
        }

        List<CartItem> buyNowItems = List.of(new CartItem(product, qty));
        double total = qty * product.getPrice();

        session.setAttribute("checkoutItems", buyNowItems);

        if (product.getStock() < qty) {
            model.addAttribute("error", "Không đủ hàng cho sản phẩm: " + product.getProductName());
        }

        model.addAttribute("items", buyNowItems);
        model.addAttribute("user", user);
        model.addAttribute("total", total);
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
