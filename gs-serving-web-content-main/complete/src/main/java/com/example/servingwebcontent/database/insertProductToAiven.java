package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.lang.System;

import com.example.servingwebcontent.Product;

public class insertProductToAiven {
public void insertProduct(Product product) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://mysql-eee7f4a-minhvu6723.g.aivencloud.com:14771/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_U7GdPSqWnwNiHeo_OK3"
            );

            String sql = "INSERT INTO products (product_id, seller_id, product_name, price, stock, description) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, product.getProductId());
                pst.setString(2, String.valueOf(product.getSellerId()));  // seller_id trong SQL là VARCHAR
                pst.setString(3, product.getProductName());
                pst.setDouble(4, product.getPrice());
                pst.setInt(5, product.getStock());
                pst.setString(6, product.getDescription());

                pst.executeUpdate();
                System.out.println("Đã thêm sản phẩm thành công vào cơ sở dữ liệu!");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối hoặc ghi dữ liệu vào DB:");
            e.printStackTrace();
        }
    }
}
