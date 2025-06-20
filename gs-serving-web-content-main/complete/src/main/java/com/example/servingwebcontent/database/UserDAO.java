package com.example.servingwebcontent.database;

import java.util.List;

import com.example.servingwebcontent.User;

public interface UserDAO {
    List<User> getAllUsers();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String userId);
    User getUserById(String userId);
    User findByUsername(String username); // Thêm dòng này để phục vụ đăng nhập
}