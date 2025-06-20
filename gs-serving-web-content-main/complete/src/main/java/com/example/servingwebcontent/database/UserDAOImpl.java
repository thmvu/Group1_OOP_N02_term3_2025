package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.servingwebcontent.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = aivenConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO users (user_id, full_name, gender, dob, phone, email, address, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getFullName());
            pstmt.setString(3, user.getGender());
            pstmt.setDate(4, user.getDob() != null ? Date.valueOf(user.getDob()) : null);
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getPassword());
            pstmt.setString(9, user.getRole());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET full_name=?, gender=?, dob=?, phone=?, email=?, address=?, password=?, role=? WHERE user_id=?";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getGender());
            pstmt.setDate(3, user.getDob() != null ? Date.valueOf(user.getDob()) : null);
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, user.getRole());
            pstmt.setString(9, user.getUserID());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        String sql = "DELETE FROM users WHERE user_id=?";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE user_id=?";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Hàm phục vụ đăng nhập
    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE phone = ? OR email = ?";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User(null, null, null, null, null, null, null, null, null);
        user.setUserID(rs.getString("user_id"));
        user.setFullName(rs.getString("full_name"));
        user.setGender(rs.getString("gender"));
        java.sql.Date dobDate = rs.getDate("dob");
        user.setDob(dobDate != null ? dobDate.toString() : null);
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
}