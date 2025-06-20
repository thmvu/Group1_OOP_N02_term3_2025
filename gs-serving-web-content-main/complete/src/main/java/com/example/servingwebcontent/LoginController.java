package com.example.servingwebcontent;


import com.example.servingwebcontent.*;
import com.example.servingwebcontent.database.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;


import java.util.List;

@Controller
public class LoginController {

    private final UserDAO userDAO = new UserDAOImpl();

    // 1️⃣ Form đăng nhập
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // 2️⃣ Xử lý đăng nhập
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") User loginUser, HttpSession session, Model model) {
        String username = loginUser.getEmail(); // hoặc phone
        String password = loginUser.getPassword();

        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            boolean isMatch = (u.getEmail().equals(username) || u.getPhone().equals(username)) &&
                              u.getPassword().equals(password);
            if (isMatch) {
                // Phân loại role
                if ("seller".equalsIgnoreCase(u.getRole())) {
                    Seller s = new Seller(password, password, password, password, password, password, password, password);
                    copyUserFields(u, s);
                    session.setAttribute("loggedInUser", s);
                    return "redirect:/seller/products";
                } else if ("customer".equalsIgnoreCase(u.getRole())) {
                    Customer c = new Customer();
                    copyUserFields(u, c);
                    session.setAttribute("loggedInUser", c);
                    return "redirect:/catalog";
                } else {
                    session.setAttribute("loggedInUser", u);
                    return "redirect:/";
                }
            }
        }

        model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng.");
        return "login";
    }

    // 3️⃣ Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // 🔁 Hàm phụ dùng để sao chép dữ liệu user -> customer/seller
    private void copyUserFields(User from, User to) {
        to.setUserID(from.getUserID());
        to.setFullName(from.getFullName());
        to.setGender(from.getGender());
        to.setDob(from.getDob());
        to.setPhone(from.getPhone());
        to.setEmail(from.getEmail());
        to.setAddress(from.getAddress());
        to.setPassword(from.getPassword());
        to.setRole(from.getRole());
    }
}