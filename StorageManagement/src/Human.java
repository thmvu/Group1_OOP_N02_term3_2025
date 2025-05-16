import java.time.LocalDate;

public class Human {
    protected String name;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected String address;
    protected String citizenId;
    protected String birthDate;
    protected LocalDate createdAt;

    public Human(String name, String gender, String birthDate, String phoneNumber,
                 String email, String address, String citizenId) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.citizenId = citizenId;
        this.createdAt = LocalDate.now();
    }

    public void showInfo() {
        System.out.println("=== Thông tin cá nhân ===");
        System.out.println("Họ tên      : " + name);
        System.out.println("Giới tính   : " + gender);
        System.out.println("Ngày sinh   : " + birthDate);
        System.out.println("SĐT         : " + phoneNumber);
        System.out.println("Email       : " + email);
        System.out.println("Địa chỉ     : " + address);
        System.out.println("CCCD/CMND   : " + citizenId);
        System.out.println("Ngày tạo    : " + createdAt);
    }

    // Bạn có thể thêm các phương thức như updateInfo(), validatePhone(), validateEmail()...
}
