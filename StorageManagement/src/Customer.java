public class Customer extends User1 {
    private String customerLevel;

    public Customer(String userId, String name, String email, String phoneNumber, String gender,
                    String birthDate, String address, String password, String userType,
                    String customerLevel) {
        super(userId, name, email, phoneNumber, gender, birthDate, address, password, userType);
        this.customerLevel = customerLevel;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", level='" + customerLevel + '\'' +
                '}';
    }
}
