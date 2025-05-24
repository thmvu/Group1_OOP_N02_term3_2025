
import java.util.ArrayList;

public class UserList {

    ArrayList<User> st = new ArrayList<User>();

    public ArrayList<User> addUser(User stu) {

        st.add(stu);
        return st;

    }

    public ArrayList<User> getEditUser(String name, String userId) {

        for (int i = 0; i < st.size(); i++) {

            if (st.get(i).getUserId() == userId) {

                System.out.print("true");

                st.get(i).setName(name);
            }

        }

        return st;
    }

    public ArrayList<User> getDeleteUser(String userId) {

        for (int i = 0; i < st.size(); i++) {

            if (st.get(i).getUserId() == userId) {

                st.remove(i);

            }

        }

        return st;
    }

    public void printUserList() {
        int len = st.size();

        for (int i = 0; i < len; i++) {
            System.out.println("User ID: " + st.get(i).getUserId() + " Fullname: " + st.get(i).getName());

        }

    }
}
