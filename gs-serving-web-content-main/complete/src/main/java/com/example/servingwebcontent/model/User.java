package com.example.servingwebcontent.model;

// User.java
public class User {
    private String userID;
    private String fullName;
    private String gender;
    private String dob;
    private String phone;
    private String email;
    private String address;
    private String password;
    private String role;

   public User(String userID, String fullName, String gender, String dob,
            String phone, String email, String address, String password, String role) {
    this.userID = userID;
    this.fullName = fullName;
    this.gender = gender;
    this.dob = dob;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.password = password;
    this.role = role;
}
    public User() {
        this.userID = "";
        this.fullName = "";
        this.gender = "";
        this.dob = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.password = "";
        this.role = "customer"; // Mặc định là customer
    }

    // Getters & Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Phương thức hiển thị thông tin người dùng
    public void showUser() {
        System.out.println("ID: " + userID);
        System.out.println("Ten: " + fullName);
        System.out.println("Gioi tinh: " + gender);
        System.out.println("Ngay sinh: " + dob);
        System.out.println("Dien thoai: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Dia chi: " + address);
        System.out.println("Vai tro: " + role);
    }

    // Kiểm tra đăng nhập đơn giản
    public boolean login(String username, String password) {
        // username co the la phone hoac email
        return (username.equals(phone) || username.equals(email)) && this.password.equals(password);
    }
    
    @Override
    public String toString() {
        return "User[ID=" + userID + ", Ten=" + fullName + ", VaiTro=" + role + "]";
    }

}
