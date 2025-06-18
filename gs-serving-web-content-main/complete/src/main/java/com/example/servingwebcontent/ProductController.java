package com.example.servingwebcontent;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.util.List;
import java.sql.DriverManager;

@Controller

public class ProductController {
    @Autowired
    private Connection aivenConnection; // hoặc DataSource nếu dùng Spring config

    @GetMapping("/products")
    public String showProducts(Model model) {
        try {
            ProductDAO dao = new ProductDAO(aivenConnection);
            List<Product> products = dao.getAllProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải sản phẩm!");
        }

        return "product-list";
    }

}
