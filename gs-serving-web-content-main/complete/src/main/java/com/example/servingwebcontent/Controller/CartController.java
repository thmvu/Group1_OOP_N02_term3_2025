package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.model.CartItem;
import com.example.servingwebcontent.model.Product;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductDAO productDAO;

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        Product product = productDAO.getProductById(productId);
        if (product == null) {
            return "redirect:/customer/home"; // Nếu không tìm thấy sản phẩm
        }

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProduct().getProductId() == productId) {
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

    @GetMapping("/view")
public String viewCart(Model model, HttpSession session) {
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    if (cart == null) cart = new ArrayList<>();

    model.addAttribute("cart", cart);
    return "cart_view";
}

}