public class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String gender;
    protected String birthDate;
    protected String address;
    protected String password;
    protected String userType;

    // Constructor đầy đủ
    public User(String userId, String name, String email, String phoneNumber,
                String gender, String birthDate, String address,
                String password, String userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
