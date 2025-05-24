
public class User 
{
    private String userId; 
    private String name;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private String userType;

    public User(String userId, String name, String gender, String birthDate, String phoneNumber, 
            String email, String address, String password, String userType)
    {
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

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getBirthDate() { return birthDate; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }
    public String getUserType() { return userType; }
    public void setName(String name)
    {
        this.name = name;

    } 
    public void setUser(String userId, String name, String gender, String birthDate, String phoneNumber, 
                            String email, String address, String password, String userType) 
    { 
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

    public boolean login(String loginId, String password)        //đăng nhập
    {
        return (loginId.equals(this.phoneNumber) || loginId.equals(this.email)) && password.equals(this.password);
    }

    public void showUser()          //hiển thị thông tin user
    {
        System.out.println("Mã người dùng: " + userId);
        System.out.println("Tên: " + name);
        System.out.println("Giới tính: " + gender);
        System.out.println("Ngày sinh: " + birthDate);
        System.out.println("SĐT: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Loại người dùng: " + userType);
    }
}
