package com.example.servingwebcontent;

// Customer.java
public class Customer extends User {
    public Customer(String userID, String fullName, String gender, String dob, String phone, String email, String address, String password) {
        super();
    }
    public Customer() {
        super();
    }
    
    public void buy(String productName) {
        System.out.println(getFullName() + " da mua san pham: " + productName);
    }
}
