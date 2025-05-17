public class User {
    private String userId;
    private String userName;
    private String email;
    private int tuoi;

    public User(String userId, String userName, String email, int tuoi) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.tuoi = tuoi;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
