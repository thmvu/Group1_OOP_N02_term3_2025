package com.example.servingwebcontent;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.aivenConnection;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String showProducts(Model model) {
        try {
            // Gọi static method để lấy connection
            ProductDAO dao = new ProductDAO(aivenConnection.getConnection());
            List<Product> products = dao.getAllProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace(); // để log lỗi ra console
            model.addAttribute("error", "Lỗi khi tải sản phẩm!");
        }

        return "product-list";
    }

}
