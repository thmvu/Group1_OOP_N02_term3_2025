package com.example.servingwebcontent.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatisticsDAOImpl implements StatisticsDAO {

    private int getCount(String query) {
        try (Connection conn = aivenConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getTotalUsers() {
        return getCount("SELECT COUNT(*) FROM users");
    }

    @Override
    public int getTotalSellers() {
        return getCount("SELECT COUNT(*) FROM users WHERE role = 'SELLER'");
    }

    @Override
    public int getTotalCustomers() {
        return getCount("SELECT COUNT(*) FROM users WHERE role = 'CUSTOMER'");
    }

    @Override
    public int getTotalProducts() {
        return getCount("SELECT COUNT(*) FROM products");
    }

    @Override
    public int getTotalTransactions() {
        // Đếm số lượng hóa đơn đã tạo (giao dịch)
        return getCount("SELECT COUNT(*) FROM invoices");
    }

    @Override
    public double getTotalRevenue() {
        // Tính tổng doanh thu từ invoice_items: quantity * unit_price
        try (Connection conn = aivenConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SUM(quantity * unit_price) FROM invoice_items")) {
            if (rs.next()) return rs.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}