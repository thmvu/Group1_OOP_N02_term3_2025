package com.example.servingwebcontent.database;

import java.util.List;

import com.example.servingwebcontent.model.User;

public interface UserDAO {
    List<User> getAllUsers();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String userId);
    User getUserById(String userId);
    User findByUsername(String username); 
    // Thêm dòng này để phục vụ đăng nhập
    User getUserByEmailAndPassword(String email, String password);

    // ✅ Chức năng thêm mới:

    // Kiểm tra người dùng đã tồn tại theo email
    boolean existsByEmail(String email);

    // Đổi mật khẩu theo userId
    boolean changePassword(String userId, String newPassword);
}
