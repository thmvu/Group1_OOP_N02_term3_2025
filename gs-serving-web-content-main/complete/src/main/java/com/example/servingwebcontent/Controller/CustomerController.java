package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.model.CartItem;
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
    private static final int PRODUCTS_PER_PAGE = 6;

    // Trang chủ khách hàng
    @GetMapping("/customer/home")
    public String showCustomerHome(HttpSession session, Model model,
                                   @RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "minPrice", required = false) Double minPrice,
                                   @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                   @RequestParam(value = "page", defaultValue = "1") int page) {

        User user = (User) session.getAttribute("user");
        if (user == null || !"customer".equalsIgnoreCase(user.getRole())) return "redirect:/login";

        List<Product> products = productDAO.getAllProducts();

        // Lọc theo từ khóa và giá
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

        // Phân trang
        int totalProducts = products.size();
        int totalPages = (int) Math.ceil((double) totalProducts / PRODUCTS_PER_PAGE);
        int fromIndex = (page - 1) * PRODUCTS_PER_PAGE;
        int toIndex = Math.min(fromIndex + PRODUCTS_PER_PAGE, totalProducts);
        if (fromIndex > toIndex) {
            fromIndex = 0;
            page = 1;
        }

        List<Product> pageProducts = products.subList(fromIndex, toIndex);

        // Lấy giỏ hàng
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();

        model.addAttribute("products", pageProducts);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        model.addAttribute("userForm", user);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", totalPages);
        return "customer_home";
    }

    // Thêm vào giỏ
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

    // Giảm số lượng
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

    // Xoá sản phẩm
    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getProductId() == productId);
            session.setAttribute("cart", cart);
        }
        return "redirect:/customer/home";
    }

    // Trang xác nhận đơn hàng
    @PostMapping("/cart/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null || cart == null || cart.isEmpty()) return "redirect:/customer/home";

        model.addAttribute("items", cart);
        model.addAttribute("user", user);
        model.addAttribute("total", cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum());
        return "confirm_order";
    }

    // Xác nhận đặt hàng và lưu lịch sử
    @PostMapping("/cart/confirm/submit")
    public String submitOrder(@RequestParam String fullName,
                              @RequestParam String phone,
                              @RequestParam String address,
                              HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) return "redirect:/customer/home";

        // Cập nhật thông tin người dùng
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setAddress(address);
        session.setAttribute("user", user);

        // Kiểm tra tồn kho
        for (CartItem item : cart) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            if (product.getStock() < item.getQuantity()) {
                model.addAttribute("error", "Không đủ hàng cho sản phẩm: " + product.getProductName());
                return "redirect:/customer/home";
            }
        }

        // Cập nhật tồn kho
        for (CartItem item : cart) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            product.setStock(product.getStock() - item.getQuantity());
            productDAO.updateProduct(product);
        }

        // Lưu lịch sử đơn hàng
        List<List<CartItem>> orderHistory = (List<List<CartItem>>) session.getAttribute("orderHistory");
        if (orderHistory == null) orderHistory = new ArrayList<>();

        List<CartItem> orderCopy = cart.stream()
                .map(i -> new CartItem(i.getProduct(), i.getQuantity()))
                .collect(Collectors.toList());

        orderHistory.add(orderCopy);
        session.setAttribute("orderHistory", orderHistory);

        // Gửi dữ liệu cho trang order_summary
        model.addAttribute("items", cart);
        model.addAttribute("user", user);
        model.addAttribute("total", cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum());

        session.removeAttribute("cart");
        return "order_summary";
    }

    // Mua ngay
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
        model.addAttribute("items", buyNowItems);
        model.addAttribute("user", user);
        model.addAttribute("total", qty * product.getPrice());
        return "confirm_order";
    }

    // ✅ Lịch sử đơn hàng
    @GetMapping("/order/history")
    public String viewOrderHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<List<CartItem>> orderHistory = (List<List<CartItem>>) session.getAttribute("orderHistory");
        if (orderHistory == null) orderHistory = new ArrayList<>();

        model.addAttribute("orderHistory", orderHistory);
        return "order_history"; // cần file order_history.html
    }
}
