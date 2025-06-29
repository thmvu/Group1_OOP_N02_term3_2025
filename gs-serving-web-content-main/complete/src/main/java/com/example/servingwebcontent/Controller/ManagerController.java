package com.example.servingwebcontent.Controller;
    
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.servingwebcontent.database.InvoiceDAO;
import com.example.servingwebcontent.database.ProductDAO;
import com.example.servingwebcontent.database.ProductDAOImpl;
import com.example.servingwebcontent.database.StatisticsDAO;
import com.example.servingwebcontent.database.StatisticsDAOImpl;
import com.example.servingwebcontent.database.UserDAO;
import com.example.servingwebcontent.database.UserDAOImpl;
import com.example.servingwebcontent.model.Product;
import com.example.servingwebcontent.model.User;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final UserDAO userDAO = new UserDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();
    private final StatisticsDAO statsDAO = new StatisticsDAOImpl();
    private final InvoiceDAO invoiceDAO = new InvoiceDAO();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(int.class, new CustomNumberEditor(Integer.class, true));
    }

   @GetMapping("/home")
    public String managerHome(Model model,
                          @RequestParam(value = "keyword", required = false) String keyword) {
    model.addAttribute("statistics", List.of(
        new Object[]{"Người dùng", statsDAO.getTotalUsers()},
        new Object[]{"Khách hàng", statsDAO.getTotalCustomers()},
        new Object[]{"Nhà cung cấp", statsDAO.getTotalSellers()},
        new Object[]{"Sản phẩm", statsDAO.getTotalProducts()},
        new Object[]{"Giao dịch", statsDAO.getTotalTransactions()},
        new Object[]{"Doanh thu", statsDAO.getTotalRevenue()}
    ));

    List<Product> products = productDAO.getAllProducts();
    if (keyword != null && !keyword.trim().isEmpty()) {
        products = products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        model.addAttribute("keyword", keyword);
    }

    model.addAttribute("products", products);
    return "manager_home";
    }

    // ========== QUẢN LÝ SẢN PHẨM ==========
    @GetMapping("/products")
    public String productPage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Product> products = productDAO.getAllProducts();
        if (keyword != null && !keyword.trim().isEmpty()) {
            products = products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("products", products);
        return "manager_product_list";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product) {
        if (product.getProductId() == null || product.getProductId() == 0) {
            productDAO.addProduct(product);
        } else {
            productDAO.updateProduct(product);
        }
        return "redirect:/manager/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.deleteProduct(id);
        return "redirect:/manager/products";
    }

    // ========== QUẢN LÝ NGƯỜI DÙNG ==========
    @GetMapping("/users")
    public String userPage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
    try {
        List<User> users = userDAO.getAllUsers();
        if (keyword != null && !keyword.trim().isEmpty()) {
            users = users.stream().filter(u ->
                    u.getFullName().toLowerCase().contains(keyword.toLowerCase()) ||
                    u.getEmail().toLowerCase().contains(keyword.toLowerCase()) ||
                    u.getRole().toLowerCase().contains(keyword.toLowerCase())
            ).collect(Collectors.toList());
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("users", users);
    } catch (Exception e) {
        model.addAttribute("error", "Lỗi khi tải danh sách người dùng: " + e.getMessage());
    }
    return "manager_user_list";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute User user, Model model) {
    try {
        if (user.getUserID() == null || user.getUserID().trim().isEmpty()) {
            String newId = "cust" + System.currentTimeMillis();
            user.setUserID(newId);
            userDAO.addUser(user);
        } else {
            userDAO.updateUser(user);
        }
    } catch (Exception e) {
        model.addAttribute("error", "Lỗi khi lưu người dùng: " + e.getMessage());
    }
    return "redirect:/manager/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable String id, Model model) {
    try {
        userDAO.deleteUser(id);
    } catch (Exception e) {
        model.addAttribute("error", "Lỗi khi xóa người dùng: " + e.getMessage());
    }
    return "redirect:/manager/users";
    }

    // ========== QUẢN LÝ HÓA ĐƠN ==========
    @GetMapping("/invoices")
    public String invoicePage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
    try {
        List<com.example.servingwebcontent.model.Invoice> invoices = invoiceDAO.getAllInvoices();
        if (keyword != null && !keyword.trim().isEmpty()) {
            invoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().getFullName().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("invoices", invoices);
    } catch (Exception e) {
        model.addAttribute("error", "Lỗi khi tải hóa đơn: " + e.getMessage());
    }
    return "manager_invoice_list";
    }

    @GetMapping("/invoices/delete/{id}")
    public String deleteInvoice(@PathVariable String id, Model model) {
    try {
        invoiceDAO.deleteInvoice(id);
    } catch (Exception e) {
        model.addAttribute("error", "Lỗi khi xóa hóa đơn: " + e.getMessage());
    }
    return "redirect:/manager/invoices";
    }
}
