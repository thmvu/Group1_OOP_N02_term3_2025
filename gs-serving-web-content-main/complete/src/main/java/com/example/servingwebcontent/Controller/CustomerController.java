package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.database.InvoiceDAO;
import com.example.servingwebcontent.model.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

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
    // @PostMapping("/cart/add")
    // public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
    // List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    // if (cart == null) cart = new ArrayList<>();

    // Product product = productDAO.getProductById(productId);

    // boolean found = false;
    // for (CartItem item : cart) {
    //     if (item.getProduct().getProductId() == productId) {
    //         item.setQuantity(item.getQuantity() + 1);
    //         found = true;
    //         break;
    //     }
    // }

    // if (!found) {
    //     cart.add(new CartItem(product, 1));
    // }

    // session.setAttribute("cart", cart);
    // return "redirect:/customer/home";
    // }

    @PostMapping("/cart/confirm/submit")
    public String submitOrder(@RequestParam String fullName,
                          @RequestParam String phone,
                          @RequestParam String address,
                          @RequestParam(required = false) String note,
                          HttpSession session, Model model) {

    User user = (User) session.getAttribute("user");
    List<CartItem> checkoutItems = (List<CartItem>) session.getAttribute("checkoutItems");

    if (user == null || checkoutItems == null || checkoutItems.isEmpty()) {
        return "redirect:/customer/home";
    }

    // Cập nhật lại thông tin người dùng nếu có thay đổi
    user.setFullName(fullName);
    user.setPhone(phone);
    user.setAddress(address);
    session.setAttribute("user", user);

    // Kiểm tra tồn kho
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

    // Cập nhật lại kho
    for (CartItem item : checkoutItems) {
        Product product = productDAO.getProductById(item.getProduct().getProductId());
        product.setStock(product.getStock() - item.getQuantity());
        productDAO.updateProduct(product);
    }

    // Tạo hóa đơn
    String invoiceId = UUID.randomUUID().toString().substring(0, 8);
    Invoice invoice = new Invoice(invoiceId, (Customer) user, LocalDateTime.now(), "CONFIRMED");

    for (CartItem item : checkoutItems) {
        InvoiceItem invoiceItem = new InvoiceItem(invoice, item.getProduct(), item.getQuantity(), item.getProduct().getPrice());
        invoice.addItem(invoiceItem);
    }

    // Lưu hóa đơn
    InvoiceDAO invoiceDAO = new InvoiceDAO();
    boolean saved = invoiceDAO.addInvoice(invoice);
    if (!saved) {
        model.addAttribute("error", "Lỗi khi lưu hóa đơn.");
        return "confirm_order";
    }

    // Gửi dữ liệu ra giao diện
    model.addAttribute("items", invoice.getItems());
    model.addAttribute("user", user);
    model.addAttribute("total", invoice.getItems().stream().mapToDouble(InvoiceItem::getTotalPrice).sum());
    model.addAttribute("note", note);
    model.addAttribute("invoiceId", invoiceId);

    // Xóa giỏ hàng sau khi đặt hàng thành công
    session.removeAttribute("checkoutItems");
    session.removeAttribute("cart");

    return "order_summary";
    }
}
