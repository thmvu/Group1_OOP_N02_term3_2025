package com.example.servingwebcontent.Controller;


import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.database.StatisticsDAO;
import com.example.servingwebcontent.database.StatisticsDAOImpl;
import com.example.servingwebcontent.database.UserDAO;
import com.example.servingwebcontent.database.UserDAOImpl;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final UserDAO userDAO = new UserDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final StatisticsDAO statsDAO = new StatisticsDAOImpl();

    // =================== DASHBOARD ===================
    @GetMapping("/home")
    public String managerHome(Model model) {
    List<User> users = userDAO.getAllUsers();
    model.addAttribute("users", users);

    model.addAttribute("totalUsers", statsDAO.getTotalUsers());
    model.addAttribute("totalSellers", statsDAO.getTotalSellers());
    model.addAttribute("totalCustomers", statsDAO.getTotalCustomers());
    model.addAttribute("totalProducts", statsDAO.getTotalProducts());
    model.addAttribute("totalTransactions", statsDAO.getTotalTransactions());
    model.addAttribute("totalRevenue", statsDAO.getTotalRevenue());

    // 👉 Sửa đoạn này
    List<Product> products = productDAO.getAllProducts();
    model.addAttribute("products", products);

    // 👉 Thêm nếu form dùng trong manager_home.html
    model.addAttribute("formAction", "/manager/products/save");
    model.addAttribute("backUrl", "/manager/home");
    model.addAttribute("isManager", true);

    return "manager_home";
    }
    // =================== USER MANAGEMENT ===================
    @GetMapping("/users")
    public String listUsers(Model model) {
    List<User> users = userDAO.getAllUsers();
    model.addAttribute("users", users);
    return "manager_user_list"; // HTML danh sách user
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
    model.addAttribute("user", new User());
    return "manager_user_form"; // HTML form thêm/sửa user
    }

    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") String id, Model model) {
    User user = userDAO.getUserById(id);
    model.addAttribute("user", user);
    return "manager_user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
    if (userDAO.getUserById(user.getUserID()) == null) {
        userDAO.addUser(user);
    } else {
        userDAO.updateUser(user);
    }
    return "redirect:/manager/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
    userDAO.deleteUser(id);
    return "redirect:/manager/users";
    }
    // =================== PRODUCT MANAGEMENT ===================
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productDAO.getAllProducts());
        return "manager_product_list";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
    model.addAttribute("product", new Product());
    model.addAttribute("formAction", "/manager/products/save");
    model.addAttribute("backUrl", "/manager/products");
    model.addAttribute("isManager", true);
    return "product-form";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
    Product product = productDAO.getProductById(id);
    model.addAttribute("product", product);
    model.addAttribute("formAction", "/manager/products/save");
    model.addAttribute("backUrl", "/manager/products");
    model.addAttribute("isManager", true);
    return "product-form";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product) {
    if (productDAO.getProductById(product.getProductId()) == null) {
        productDAO.addProduct(product);
    } else {
        productDAO.updateProduct(product);
    }
    return "redirect:/manager/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productDAO.deleteProduct(id);
        return "redirect:/manager/products";
    }
}
