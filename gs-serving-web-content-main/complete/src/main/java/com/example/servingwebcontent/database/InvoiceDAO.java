package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class InvoiceDAO {
    public boolean addInvoice(Invoice invoice) {
        String sqlInvoice = "INSERT INTO invoices (invoice_id, customer_id, created_at, status) VALUES (?, ?, ?, ?)";
        String sqlItem = "INSERT INTO invoice_items (invoice_id, product_id, quantity, unit_price) VALUES (?, ?, ?, ?)";

        try (Connection conn = aivenConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtInvoice = conn.prepareStatement(sqlInvoice);
                 PreparedStatement pstmtItem = conn.prepareStatement(sqlItem)) {

                pstmtInvoice.setString(1, invoice.getInvoiceId());
                pstmtInvoice.setString(2, invoice.getCustomer().getUserID());
                pstmtInvoice.setTimestamp(3, Timestamp.valueOf(invoice.getCreatedAt()));
                pstmtInvoice.setString(4, invoice.getStatus());
                pstmtInvoice.executeUpdate();

                for (InvoiceItem item : invoice.getItems()) {
                    pstmtItem.setString(1, invoice.getInvoiceId());
                    pstmtItem.setInt(2, item.getProduct().getProductId());
                    pstmtItem.setInt(3, item.getQuantity());
                    pstmtItem.setDouble(4, item.getUnitPrice());
                    pstmtItem.addBatch();
                }
                pstmtItem.executeBatch();

                conn.commit();
                return true;
            } catch (Exception ex) {
                conn.rollback();
                ex.printStackTrace();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices";

        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Invoice invoice = extractInvoice(rs);
                invoice.setItems(getItemsByInvoiceId(invoice.getInvoiceId()));
                list.add(invoice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Invoice getInvoiceById(String invoiceId) {
        String sql = "SELECT * FROM invoices WHERE invoice_id = ?";

        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, invoiceId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Invoice invoice = extractInvoice(rs);
                invoice.setItems(getItemsByInvoiceId(invoiceId));
                return invoice;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Invoice> getInvoicesByCustomerId(String customerId) {
        List<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM invoices WHERE customer_id = ?";

        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Invoice invoice = extractInvoice(rs);
                invoice.setItems(getItemsByInvoiceId(invoice.getInvoiceId()));
                list.add(invoice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<InvoiceItem> getItemsByInvoiceId(String invoiceId) {
        List<InvoiceItem> items = new ArrayList<>();
        String sql = "SELECT * FROM invoice_items WHERE invoice_id = ?";

        try (Connection conn = aivenConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, invoiceId);
            ResultSet rs = pstmt.executeQuery();

            ProductDAO productDAO = new ProductDAOImpl();

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                double unitPrice = rs.getDouble("unit_price");

                Product product = productDAO.getProductById(productId);

                items.add(new InvoiceItem(null, product, quantity, unitPrice));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    private Invoice extractInvoice(ResultSet rs) throws SQLException {
        String invoiceId = rs.getString("invoice_id");
        String customerId = rs.getString("customer_id");
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        String status = rs.getString("status");

        UserDAO userDAO = new UserDAOImpl();
        Customer customer = (Customer) userDAO.getUserById(customerId);

        return new Invoice(invoiceId, customer, createdAt, status);
    }
}
