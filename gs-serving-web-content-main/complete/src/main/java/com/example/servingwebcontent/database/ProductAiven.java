package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.servingwebcontent.Product;

public class ProductAiven {

    public ProductAiven() {}

    public ArrayList<Product> getProductListFromAiven() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            // Kết nối DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://mysql-eee7f4a-minhvu6723.g.aivencloud.com:14771/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_U7GdPSqWnwNiHeo_OK3"
            );

            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM products LIMIT 10");

            while (rs.next()) {
                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setSellerId(rs.getString("seller_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setDescription(rs.getString("description"));

                products.add(product);

                // Debug in ra
                System.out.println("ID: " + product.getProductId() + 
                    ", Name: " + product.getProductName() + 
                    ", Price: " + product.getPrice());
            }

            rs.close();
            sta.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối hoặc đọc dữ liệu từ Aiven:");
            e.printStackTrace();
        }

        return products;
    }
}
