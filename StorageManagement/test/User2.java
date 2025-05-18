public class User2 {
    public static void main(String[] args) {
        User1 user2 = new User1("johndoe", "john@example.com", 25);

        System.out.println("Username: " + user2.username);
        System.out.println("Email: " + user2.email);
        System.out.println("Age: " + user2.age);
    }
}
