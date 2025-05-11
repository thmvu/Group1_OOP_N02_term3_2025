
public class User {
    protected int userId;
    protected String name;
    protected String gender;
    protected String birthDate;
    protected String phoneNumber;
    protected String email;
    protected String address;
    protected String password;
    protected String userType;

    public void signUp(int userId, String name, String gender, String birthDate, String phoneNumber,String email, String address, String password, String userType){
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

