
public class Customer extends User         //tính kế thừa 
{
    Customer(int userId, String name, String gender, String birthDate, String phoneNumber)        //tính đa hình
    {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        //this.email = email;
        //this.address = address;
        //this.password = password;
        //this.userType = "Khách hàng";
    }
    public void showInfo(){
        System.out.println("ID: "+userId + ",\n Ten : "+name + ",\n Gioi Tinh: " + gender + ",\n Ngay Sinh: " + birthDate + ",\n So Dien Thoai: " + phoneNumber);
    }
    public void buy(String productName)     //mua sản phẩm
    {
        System.out.println(name + " đã mua sản phẩm: " + productName);
    }
}
