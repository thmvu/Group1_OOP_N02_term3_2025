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

    @GetMapping("/customer/home")
    public String showCustomerHome(HttpSession session,
                                   Model model,
                                   @RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "minPrice", required = false) Double minPrice,
                                   @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                   @RequestParam(value = "page", defaultValue = "1") int page) {

        User user = (User) session.getAttribute("user");
        if (user == null || !"customer".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        List<Product> products = productDAO.getAllProducts();

        // Lọc theo mô tả, từ khoá, giá min/max nếu có
        if (keyword != null && !keyword.isEmpty()) {
            products = products.stream()
                    .filter(p -> p.getProductName().toLowerCase().contains(keyword.toLowerCase()) ||
                                 p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (minPrice != null) {
            products = products.stream()
                    .filter(p -> p.getPrice() >= minPrice)
                    .collect(Collectors.toList());
        }
        if (maxPrice != null) {
            products = products.stream()
                    .filter(p -> p.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        // Phân trang
        int totalProducts = products.size();
        int totalPages = (int) Math.ceil((double) totalProducts / PRODUCTS_PER_PAGE);
        int fromIndex = (page - 1) * PRODUCTS_PER_PAGE;
        int toIndex = Math.min(fromIndex + PRODUCTS_PER_PAGE, totalProducts);

        if (fromIndex > toIndex) {
            fromIndex = 0; // reset về đầu nếu lỗi
            page = 1;
        }

        List<Product> pageProducts = products.subList(fromIndex, toIndex);

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

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

        if (!found) {
            cart.add(new CartItem(product, qty));
        }

        session.setAttribute("cart", cart);
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

    @GetMapping("/cart/decrease")
    public String decreaseQuantity(@RequestParam("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getProduct().getProductId() == productId) {
                    if (item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - 1);
                    } else {
                        iterator.remove();
                    }
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/customer/home";
    }

    @PostMapping("/cart/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Giỏ hàng đang trống.");
            return "redirect:/customer/home";
        }

        for (CartItem item : cart) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            if (product.getStock() < item.getQuantity()) {
                model.addAttribute("error", "Không đủ hàng cho sản phẩm: " + product.getProductName());
                return "redirect:/customer/home";
            }
        }

        for (CartItem item : cart) {
            Product product = productDAO.getProductById(item.getProduct().getProductId());
            product.setStock(product.getStock() - item.getQuantity());
            productDAO.updateProduct(product);
        }

        session.removeAttribute("cart");
        model.addAttribute("message", "Thanh toán thành công!");
        return "redirect:/customer/home";
    }

    @PostMapping("/cart/buynow")
    public String buyNow(@RequestParam("productId") int productId,
                         @RequestParam(value = "qty", defaultValue = "1") int qty,
                         HttpSession session,
                         Model model) {
        Product product = productDAO.getProductById(productId);
        if (product == null || qty < 1) {
            model.addAttribute("error", "Sản phẩm không hợp lệ.");
            return "redirect:/customer/home";
        }

        if (product.getStock() < qty) {
            model.addAttribute("error", "Không đủ hàng trong kho.");
            return "redirect:/customer/home";
        }

        product.setStock(product.getStock() - qty);
        productDAO.updateProduct(product);

        model.addAttribute("message", "Mua ngay thành công: " + product.getProductName());
        return "redirect:/customer/home";
    }
}
