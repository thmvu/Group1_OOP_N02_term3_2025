public class Customer extends User         //tính kế thừa 
{
    public Customer(String userId, String name, String gender, String birthDate, String phoneNumber, 
            String email, String address, String password) 
    {
        super(userId, name, gender, birthDate, phoneNumber, email, address, password, "Khách hàng");
    }

    public void buy(String productName)     //mua sản phẩm
    {
        System.out.println(getName() + " đã mua sản phẩm: " + productName);
    }
}
