package com.example.servingwebcontent.model;

public class Manager extends User {

    public Manager() {
        super();
        this.setRole("manager");
    }

    public Manager(String userID, String fullName, String gender, String dob,
                   String phone, String email, String address, String password) {
        super(userID, fullName, gender, dob, phone, email, address, password, "manager");
    }

    // Bạn có thể thêm các phương thức riêng của Manager nếu muốn
    public void manageSystem() {
        System.out.println("Manager đang quản lý hệ thống...");
    }
}