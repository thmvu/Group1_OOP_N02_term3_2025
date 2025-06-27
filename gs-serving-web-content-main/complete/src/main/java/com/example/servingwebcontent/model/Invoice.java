package com.example.servingwebcontent.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String invoiceId;
    private Customer customer;
    private LocalDateTime createdAt;
    private String status;
    private List<InvoiceItem> items = new ArrayList<>();

    public Invoice(String invoiceId, Customer customer, LocalDateTime createdAt, String status) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getInvoiceId() { return invoiceId; }
    public Customer getCustomer() { return customer; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }
    public List<InvoiceItem> getItems() { return items; }

    public void addItem(InvoiceItem item) {
        this.items.add(item);
    }

    // ✅ Sửa lỗi: thêm setItems()
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + invoiceId +
               ", Customer: " + customer.getUserID() +
               ", Date: " + createdAt +
               ", Status: " + status;
    }
}
