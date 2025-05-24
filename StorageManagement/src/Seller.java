public class Seller extends User 
{
    public Seller(String userId, String name, String gender, String birthDate, String phoneNumber, 
            String email, String address, String password) 
    {
        super(userId, name, gender, birthDate, phoneNumber, email, address, password, "Nhà cung cấp");
    }

    public void sell(String productName)        //bán sản phẩm
    {
        System.out.println(getName() + " đã đăng bán sản phẩm: " + productName);
    }
}