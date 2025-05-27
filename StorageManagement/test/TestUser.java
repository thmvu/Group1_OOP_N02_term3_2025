import java.util.ArrayList;
import java.util.Scanner;

public class TestUser 
{
    public static void test() 
    {
        Customer customer_1 = new Customer("KH001", "Nguyễn Văn A", "Nam", "2005-12-16", 
                                        "0901239303", "a@gmail.com", "Hà Nội", "123456");
        Seller seller_1 = new Seller("NC001", "Nguyen Thi TinhTinh", "Nữ", "2005-01-01", 
                                        "0912345678", "b@gmail.com", "Hồ Chí Minh", "abcdef");
        
        System.out.println("== Thông tin Khách hàng ==");
        customer_1.showUser();
        System.out.println("\n== Thông tin Nhà cung cấp ==");
        seller_1.showUser();

        System.out.println("\n== Kiểm tra đăng nhập ==");
        System.out.println("Customer login (số điện thoại): " + customer_1.login("0901239303", "123456"));
        System.out.println("Seller login (email): " + seller_1.login("b@gmail.com", "abc123"));

        System.out.println("\n== Giao dịch ==");
        customer_1.buy("Laptop Dell");
        seller_1.sell("Tai nghe Sony");

    }


    ArrayList<User> sl = new ArrayList<User>();

    public ArrayList<User> addList(){
        User s1 = new User("KH001", "Nguyễn Văn An", "Nam", "2005-12-16", "0901239303",
                                      "a@gmail.com", "Hà Nội", "123456", "Khách hàng");
        User s2 = new User("KH002", "Nguyễn Duy Bảo", "Nam", "2005-04-04", "0945983647",
                                      "b@gmail.com", "TP.HCM", "123456", "Khách hàng");
        User s3 = new User("NC001", "Nguyễn Thị Lan Anh", "Nữ", "2005-04-09", "0945989814",
                                      "c@gmail.com", "Đăk Lăk", "123456", "Nhà cung cấp");
        sl.add(s1);
        sl.add(s2);
        sl.add(s3);
        return sl;
    }

    public void testEdit() 
    {
        System.out.println("\n\n\n== Lecture 4 ==");

        ArrayList<User> sl = new ArrayList<User>();
        User s1 = new User("KH001", "Nguyễn Văn An", "Nam", "2005-12-16", "0901239303",
                                      "a@gmail.com", "Hà Nội", "123456", "Khách hàng");
        User s2 = new User("KH002", "Nguyễn Duy Bảo", "Nam", "2005-04-04", "0945983647",
                                      "b@gmail.com", "TP.HCM", "123456", "Khách hàng");
        User s3 = new User("NC001", "Nguyễn Thị Lan Anh", "Nữ", "2005-04-09", "0945989814",
                                      "c@gmail.com", "Đăk Lăk", "123456", "Nhà cung cấp");
        sl.add(s1);
        sl.add(s2);
        sl.add(s3);

        UserList userList = new UserList();
        userList.addUser(s1);
        userList.addUser(s2);
        userList.addUser(s3);

        // cap nhat thong tin

        System.out.println("Nhap User ID");
        Scanner userId = new Scanner(System.in);

        String s = userId.nextLine();

        System.out.println("Nhap User fullname");

        Scanner name = new Scanner(System.in); // Create a Scanner object

        String newName = name.nextLine();

        userList.getEditUser(newName, s);

        userList.printUserList();
        
    }

    public void testDelete(UserList userList, String UserID)
    {
        userList.getDeleteUser(UserID);
        userList.printUserList();

    }
}