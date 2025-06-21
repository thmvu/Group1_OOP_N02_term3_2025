package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.Seller;
import com.example.servingwebcontent.model.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductDAO dao = new ProductDAOImpl();

    // ✅ Hiển thị tất cả sản phẩm
    @GetMapping
    public String showProducts(Model model) {
        try {
            List<Product> products = dao.getAllProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải sản phẩm!");
        }
        return "product-list";
    }

    // ✅ Hiển thị form thêm sản phẩm
    @GetMapping("/add")
    public String showAddForm(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if (!(userObj instanceof User user) || !"seller".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        Product product = new Product();
        product.setSeller(new Seller(user)); // ✅ Gán Seller từ User

        model.addAttribute("product", product);
        model.addAttribute("formAction", "/products/save");
        model.addAttribute("backUrl", "/seller/home");
        model.addAttribute("isManager", false);

        return "product-form";
    }

    // ✅ Hiển thị form sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if (!(userObj instanceof User user) || !"seller".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        Product product = dao.getProductById(id);
        if (product == null || !product.getSeller().getUserID().equals(user.getUserID())) {
            return "redirect:/seller/home";
        }

        model.addAttribute("product", product);
        model.addAttribute("formAction", "/products/save");
        model.addAttribute("backUrl", "/seller/home");
        model.addAttribute("isManager", false);

        return "product-form";
    }

    // ✅ Lưu sản phẩm (thêm hoặc sửa)
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (!(userObj instanceof User user) || !"seller".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        product.setSeller(new Seller(user));  // ✅ Gán lại seller từ session

        if (dao.getProductById(product.getProductId()) == null) {
            dao.addProduct(product);
        } else {
            dao.updateProduct(product);
        }

        return "redirect:/seller/home";
    }

    // ✅ Xoá sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (!(userObj instanceof User user) || !"seller".equalsIgnoreCase(user.getRole())) {
            return "redirect:/login";
        }

        Product product = dao.getProductById(id);
        if (product != null && product.getSeller().getUserID().equals(user.getUserID())) {
            dao.deleteProduct(id);
        }

        return "redirect:/seller/home";
    }

   
    // ✅ Tìm kiếm sản phẩm theo từ khoá
    // @GetMapping("/search")
    // public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
    //     try {
    //         List<Product> products = dao.searchProducts(keyword);
    //         model.addAttribute("products", products);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         model.addAttribute("error", "Lỗi khi tìm kiếm sản phẩm!");
    //     }
    //     return "product-list"; // HTML đã làm
    // }
}