public class App {
    public static void main(String[] args) {
        // Tạo đối tượng User
        User user1 = new User("johndoe", "john@example.com", 25);

        // In ra thông tin người dùng
        System.out.println("Username: " + user1.username);
        System.out.println("Email: " + user1.email);
        System.out.println("Age: " + user1.age);
    }
}
