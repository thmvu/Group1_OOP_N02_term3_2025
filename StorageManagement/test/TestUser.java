
public class TestUser 
{
    public static void main(String[] args) 
    {
        Customer customer_1 = new Customer();
        customer_1.signUp(001, "Nguyễn Văn A", "Nam", "2005-1-16", 
                  "0987654321", "a@gmail.com", "Hà Nội", "123456", "");
        Seller seller_1 = new Seller();
        seller_1.signUp(001, "Nguyễn Thị BB", "Nữ", "2005-01-01", 
                "0912345678", "b@gmail.com", "Hồ Chí Minh", "abcdef", "");
        
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
}