package com.example.servingwebcontent;

// Seller.java
public class Seller extends User {
    public Seller(String userID, String fullName, String gender, String dob, String phone, String email, String address, String password) {
        super(userID, fullName, gender, dob, phone, email, address, password, "Nha cung cap");
    }

    public void sell(String productName) {
        System.out.println(getFullName() + " da ban san pham: " + productName);
    }
}
