package com.example.servingwebcontent.database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.servingwebcontent.model.Customer;
import com.example.servingwebcontent.model.Customer_Product;
import com.example.servingwebcontent.model.Product;

public class CustomerProductDAO {
    public boolean addTransaction(Customer_Product cp) {
        String sql = "INSERT INTO customer_product (customer_id, product_id, transaction_date) VALUES (?, ?, ?)";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cp.getCustomer().getUserID());
            pstmt.setInt(2, cp.getProduct().getProductId());
            pstmt.setDate(3, cp.getDate());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTransaction(String customerId, int productId, Date date) {
        String sql = "DELETE FROM customer_product WHERE customer_id=? AND product_id=? AND transaction_date=?";
        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            pstmt.setInt(2, productId);
            pstmt.setDate(3, date);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer_Product> getAllTransactions() {
        List<Customer_Product> list = new ArrayList<>();
        String sql = "SELECT * FROM customer_product";
        try (Connection conn = aivenConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String cid = rs.getString("customer_id");
                int pid = rs.getInt("product_id");
                Date date = rs.getDate("transaction_date");

                Customer customer = new Customer();
                customer.setUserID(cid);

                Product product = new Product();
                product.setProductId(pid);

                list.add(new Customer_Product(customer, product, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Customer_Product> filterByKeyword(String keyword) {
        List<Customer_Product> result = new ArrayList<>();
        for (Customer_Product cp : getAllTransactions()) {
            if (cp.getCustomer().getUserID().toLowerCase().contains(keyword.toLowerCase())
                    || String.valueOf(cp.getProduct().getProductId()).contains(keyword)) {
                result.add(cp);
            }
        }
        return result;
    }

    public void reportMostPopularProduct() {
        List<Customer_Product> transactions = getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("Chua co giao dich nao.");
            return;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Customer_Product cp : transactions) {
            int pid = cp.getProduct().getProductId();
            countMap.put(pid, countMap.getOrDefault(pid, 0) + 1);
        }

        int max = Collections.max(countMap.values());
        System.out.println("=== San pham duoc mua nhieu nhat ===");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("Product ID: " + entry.getKey() + " | So luot mua: " + entry.getValue());
            }
        }
    }

    public void printAllTransactions() {
        List<Customer_Product> list = getAllTransactions();
        System.out.println("=== Danh sach giao dich ===");
        for (Customer_Product cp : list) {
            System.out.println(cp);
        }
    }
}
