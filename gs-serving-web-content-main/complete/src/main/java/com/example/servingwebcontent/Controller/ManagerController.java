    package com.example.servingwebcontent.Controller;
    
    import com.example.servingwebcontent.database.ProductDAO;
    import com.example.servingwebcontent.database.ProductDAOImpl;
    import com.example.servingwebcontent.database.StatisticsDAO;
    import com.example.servingwebcontent.database.StatisticsDAOImpl;
    import com.example.servingwebcontent.database.UserDAO;
    import com.example.servingwebcontent.database.UserDAOImpl;
    import com.example.servingwebcontent.model.Product;
    import com.example.servingwebcontent.model.User;
    import org.springframework.beans.propertyeditors.CustomNumberEditor;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.WebDataBinder;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;

    @Controller
    @RequestMapping("/manager")
    public class ManagerController {

    private final UserDAO userDAO = new UserDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final StatisticsDAO statsDAO = new StatisticsDAOImpl();

    // Cho phép "" ánh xạ thành null khi binding int
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(int.class, new CustomNumberEditor(Integer.class, true));
    }

    @GetMapping("/home")
    public String managerHome(Model model) {
        List<User> users = userDAO.getAllUsers();
        List<Product> products = productDAO.getAllProducts();

        model.addAttribute("users", users);
        model.addAttribute("products", products);

        List<Object[]> statistics = List.of(
            new Object[]{"Người dùng", statsDAO.getTotalUsers()},
            new Object[]{"Khách hàng", statsDAO.getTotalCustomers()},
            new Object[]{"Nhà cung cấp", statsDAO.getTotalSellers()},
            new Object[]{"Sản phẩm", statsDAO.getTotalProducts()},
            new Object[]{"Giao dịch", statsDAO.getTotalTransactions()},
            new Object[]{"Doanh thu", statsDAO.getTotalRevenue()}
        );
        model.addAttribute("statistics", statistics);

        model.addAttribute("formAction", "/manager/products/save");
        model.addAttribute("backUrl", "/manager/home");
        model.addAttribute("isManager", true);

        return "manager_home";
    }

    // ========== USER ==========
    @GetMapping("/users")
    public String listUsers() {
        return "redirect:/manager/home";
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "manager_user_form";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") String id, Model model) {
        User user = userDAO.getUserById(id);
        model.addAttribute("user", user);
        return "manager_user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getUserID() == null || user.getUserID().trim().isEmpty()) {
            // Sinh ID tự động nếu không có
            String generatedId = "cust" + System.currentTimeMillis();
            user.setUserID(generatedId);
            System.out.println(">> [ADD] ID sinh tự động: " + generatedId);
            userDAO.addUser(user);
        } else {
            System.out.println(">> [UPDATE] Cập nhật user ID: " + user.getUserID());
            userDAO.updateUser(user);
        }
        return "redirect:/manager/home";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userDAO.deleteUser(id);
        return "redirect:/manager/home";
    }

    // ========== PRODUCT ==========
    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product) {
    if (product.getProductId() == null || product.getProductId() == 0) {
        productDAO.addProduct(product);
    } else {
        productDAO.updateProduct(product);
    }
    return "redirect:/manager/home";
    }
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productDAO.deleteProduct(id);
        return "redirect:/manager/home";
    }
}