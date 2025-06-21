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

    private UserDAO userDAO = new UserDAOImpl();

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // tạo login.html sau
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {

        User user = userDAO.getUserByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            String role = user.getRole();

            if ("customer".equalsIgnoreCase(role)) {
                return "redirect:/customer/home";
            } else if ("seller".equalsIgnoreCase(role)) {
                return "redirect:/seller/home";
            } else {
                model.addAttribute("error", "Vai trò không hợp lệ.");
                return "login";
            }
        } else {
            model.addAttribute("error", "Sai email hoặc mật khẩu.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}