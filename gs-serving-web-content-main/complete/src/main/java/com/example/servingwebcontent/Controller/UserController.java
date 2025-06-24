package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.database.UserDAO;
import com.example.servingwebcontent.database.UserDAOImpl;
import com.example.servingwebcontent.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserDAO userDAO = new UserDAOImpl();

    // ✅ Cập nhật thông tin tài khoản
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User updatedUser, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        // Chỉ cập nhật các trường cho phép thay đổi
        currentUser.setFullName(updatedUser.getFullName());
        currentUser.setEmail(updatedUser.getEmail());
        currentUser.setPhone(updatedUser.getPhone());
        currentUser.setAddress(updatedUser.getAddress());

        userDAO.updateUser(currentUser);
        session.setAttribute("user", currentUser); // Cập nhật lại session

        return "redirect:/customer/home";
    }

    // ✅ Đổi mật khẩu (nếu cần thêm)
    @PostMapping("/user/change-password")
    public String changePassword(@RequestParam String newPassword, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        boolean success = userDAO.changePassword(user.getUserID(), newPassword);
        if (success) {
            user.setPassword(newPassword);
            session.setAttribute("user", user);
        }

        return "redirect:/customer/home";
    }
}
