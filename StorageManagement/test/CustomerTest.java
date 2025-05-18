public class CustomerTest {
    public static void main(String[] args) {
        // Test 1: Tạo đối tượng Customer
        Customer c = new Customer(
            "C001",
            "Nguyen Van A",
            "a@gmail.com",
            "0901234567",
            "Nam",
            "2000-01-01",
            "Hanoi",
            "123456",
            "customer",
            "Gold"
        );

        System.out.println("Test 1 - Customer info: " + c);

        // Test 2: Thay đổi cấp độ khách hàng
        c.setCustomerLevel("Platinum");
        System.out.println("Test 2 - Sau khi nâng cấp: " + c.getCustomerLevel());
    }
}
