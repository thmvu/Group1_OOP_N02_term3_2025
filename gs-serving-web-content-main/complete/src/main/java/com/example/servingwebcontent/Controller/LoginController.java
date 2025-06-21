package com.example.servingwebcontent.Controller;


import com.example.servingwebcontent.database.UserDAO;
import com.example.servingwebcontent.database.UserDAOImpl;
import com.example.servingwebcontent.model.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;


import java.util.List;

@Controller
public class LoginController {

    private final UserDAO userDAO = new UserDAOImpl();

    // Hiển thị form đăng nhập
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login"; // Tên file HTML: login.html
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {

        User user = userDAO.getUserByEmailAndPassword(email, password);

        if (user != null) {
            // Lưu thông tin người dùng vào session
            session.setAttribute("user", user);

            // Điều hướng theo vai trò
            switch (user.getRole().toLowerCase()) {
                case "customer":
                    return "redirect:/customer/home";
                case "seller":
                    return "redirect:/seller/home";
                case "manager":
                    return "redirect:/manager/home";
                default:
                    model.addAttribute("error", "Vai trò không hợp lệ.");
                    return "login";
            }
        } else {
            model.addAttribute("error", "Sai email hoặc mật khẩu.");
            return "login";
        }
    }

    // Xử lý đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xoá session
        return "redirect:/login";
    }
}