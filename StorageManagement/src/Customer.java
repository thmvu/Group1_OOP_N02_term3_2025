// Customer.java
public class Customer extends User {
    public Customer(String userID, String fullName, String gender, String dob, String phone, String email, String address, String password) {
        super(userID, fullName, gender, dob, phone, email, address, password, "Khach hang");
    }

    public void buy(String productName) {
        System.out.println(getFullName() + " da mua san pham: " + productName);
    }
}
