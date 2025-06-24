package com.example.servingwebcontent.model;

public class Seller extends User {

    public Seller(String userID, String fullName, String gender, String dob,
                  String phone, String email, String address, String password) {
        super(userID, fullName, gender, dob, phone, email, address, password, "seller");
    }

    public Seller(User user) {
        super(user.getUserID(), user.getFullName(), user.getGender(), user.getDob(),
              user.getPhone(), user.getEmail(), user.getAddress(), user.getPassword(), "seller");
    }

    public void sell(String productName) {
        System.out.println(getFullName() + " đã bán sản phẩm: " + productName);
    }
}
