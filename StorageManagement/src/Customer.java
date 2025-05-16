public class Customer extends Human {
    public Customer(String name, String gender, String birthDate, String phoneNumber,
                    String email, String address, String citizenId) {
        super(name, gender, birthDate, phoneNumber, email, address, citizenId);
    }

    public void placeOrder(Order order) {
        System.out.println(name + " da dat don hang:");
        order.displayOrder();
    }
}
