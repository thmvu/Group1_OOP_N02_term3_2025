public class TestCustomer {
    public static void main(String[] args) {
        Customer c = new Customer("Nguyen Van A", "a@gmail.com", 25);
        System.out.println("Tên: " + c.name);
        System.out.println("Email: " + c.email);
        System.out.println("Tuổi: " + c.age);
    }
}
