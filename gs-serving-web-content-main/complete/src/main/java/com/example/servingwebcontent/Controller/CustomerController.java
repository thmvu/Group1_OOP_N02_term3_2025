package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.CartItem;
import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class CustomerController {

    private final ProductDAO productDAO = new ProductDAOImpl();

    // Trang chính của khách hàng hiển thị sản phẩm và giỏ hàng
    @GetMapping("/customer/home")
    public String customerHome(HttpSession session, Model model) {
        // Kiểm tra đăng nhập
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        // Danh sách sản phẩm
        List<Product> products = productDAO.getAllProducts();
        model.addAttribute("products", products);

        // Giỏ hàng từ session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        model.addAttribute("cart", cart);

        return "customer_home";
    }

    // Thêm sản phẩm vào giỏ hàng
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        Product product = productDAO.getProductById(productId);
        if (product == null) return "redirect:/customer/home";

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(product, 1));
        }

        session.setAttribute("cart", cart);
        return "redirect:/customer/home";
    }

    // Xoá sản phẩm khỏi giỏ
    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") int productId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getProduct().getId() == productId);
            session.setAttribute("cart", cart);
        }

        return "redirect:/customer/home";
    }

    // Mua ngay 1 sản phẩm
    @PostMapping("/buy")
    public String buyProduct(@RequestParam("productId") int productId, Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        Product product = productDAO.getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "checkout"; // Tạo file checkout.html
        }

        return "redirect:/customer/home";
    }

    // Thanh toán toàn bộ giỏ hàng
    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            return "redirect:/customer/home";
        }

        // TODO: Lưu đơn hàng vào DB nếu cần thiết

        session.removeAttribute("cart"); // Xoá giỏ sau khi thanh toán
        return "redirect:/customer/home?checkoutSuccess";
    }
}
