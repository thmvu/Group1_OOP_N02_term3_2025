public class User2 {
    public static void main(String[] args) {
        User user2 = new User("johndoe", "john@example.com", 25);

        System.out.println("Username: " + user2.username);
        System.out.println("Email: " + user2.email);
        System.out.println("Age: " + user2.age);
    }
}
