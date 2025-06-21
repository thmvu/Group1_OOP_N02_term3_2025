package com.example.servingwebcontent.model;

// Seller.java
public class Seller extends User {
    public Seller(String userID, String fullName, String gender, String dob,
                  String phone, String email, String address, String password) {
        super(userID, fullName, gender, dob, phone, email, address, password, "seller");
    }

    // ✅ Constructor mới: nhận từ User
    public Seller(User user) {
        super(user.getUserID(), user.getFullName(), user.getGender(), user.getDob(),
              user.getPhone(), user.getEmail(), user.getAddress(), user.getPassword(), "seller");
    }

    public void sell(String productName) {
        System.out.println(getFullName() + " da ban san pham: " + productName);
    }
}
