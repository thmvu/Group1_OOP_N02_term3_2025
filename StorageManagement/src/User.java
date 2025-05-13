public class User {
    private int userId;
    private String name;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private String userType;

    // Constructor mặc định
    public User() {
    }

    // Phương thức đăng ký
    public void signUp(int userId, String name, String gender, String birthDate, String phoneNumber,
                       String email, String address, String password, String userType) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userType = userType;
    }

    // Phương thức đăng nhập
    public boolean login(String loginId, String password) {
        return (loginId.equals(this.phoneNumber) || loginId.equals(this.email)) && password.equals(this.password);
    }

    // Hiển thị thông tin người dùng
    public void showUser() {
        System.out.println("Mã người dùng: " + getUserId());
        System.out.println("Tên: " + getName());
        System.out.println("Giới tính: " + getGender());
        System.out.println("Ngày sinh: " + getBirthDate());
        System.out.println("SĐT: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Địa chỉ: " + getAddress());
        System.out.println("Loại người dùng: " + getUserType());
    }

    // Getter methods
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }
}
