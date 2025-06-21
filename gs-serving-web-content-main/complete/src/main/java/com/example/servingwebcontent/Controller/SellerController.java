package com.example.servingwebcontent.Controller;


import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SellerController {
     private final ProductDAO productDAO = new ProductDAOImpl();

    @GetMapping("/seller/home")
    public String sellerHome(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if (!(userObj instanceof User user) || !"seller".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        List<Product> products = productDAO.getProductsBySellerId(user.getUserID());
        model.addAttribute("products", products);

        return "seller_home"; // tạo file seller_home.html
    }
}
