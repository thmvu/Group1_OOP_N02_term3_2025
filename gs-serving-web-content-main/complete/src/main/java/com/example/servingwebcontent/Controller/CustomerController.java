package com.example.servingwebcontent.Controller;


import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
      private final ProductDAO productDAO = new ProductDAOImpl();

    @GetMapping("/customer/home")
    public String customerHome(HttpSession session, Model model) {
        // Kiểm tra role
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        List<Product> products = productDAO.getAllProducts();
        model.addAttribute("products", products);

        return "customer_home"; // tạo file customer_home.html
    }
}
