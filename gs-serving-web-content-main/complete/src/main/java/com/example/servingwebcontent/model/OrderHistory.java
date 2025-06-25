package com.example.servingwebcontent.model;

import java.util.Date;
import java.util.List;

public class OrderHistory {
    private String fullName;
    private String phone;
    private String address;
    private List<CartItem> items;
    private double total;
    private Date orderDate;

    // Constructor mặc định
    public OrderHistory() {
    }

    // Constructor đầy đủ
    public OrderHistory(String fullName, String phone, String address, List<CartItem> items, double total, Date orderDate) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.items = items;
        this.total = total;
        this.orderDate = orderDate;
    }

    // Getters & Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
