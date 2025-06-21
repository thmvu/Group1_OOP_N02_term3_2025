package com.example.servingwebcontent.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.database.aivenConnection;
import com.example.servingwebcontent.model.Product;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String showProducts(Model model) {
        try {
            ProductDAO dao = new ProductDAOImpl(); // ✅ sửa chỗ này
            List<Product> products = dao.getAllProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace(); // để log lỗi ra console
            model.addAttribute("error", "Lỗi khi tải sản phẩm!");
        }

        return "product-list";
    }
}