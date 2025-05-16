import java.util.*;

public class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User u) {
        users.add(u);
    }

    public User authenticate(String username, String password) {
        for (User u : users) {
            if (u.login(username, password)) {
                return u;
            }
        }
        return null;
    }
}
