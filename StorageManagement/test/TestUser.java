public class TestUser {
    public static void main(String[] args) {
        // Tạo một đối tượng User
        User user = new User("U001", "Nguyen Van A", "nva@example.com", 30);

        // Kiểm tra các phương thức getter
        System.out.println("Thông tin người dùng:");
        System.out.println("ID: " + user.getUserId());
        System.out.println("Tên: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Tuổi: " + user.getTuoi());

        // Sử dụng setter để cập nhật thông tin
        user.setUserId("U002");
        user.setUserName("Tran Thi B");
        user.setEmail("ttb@example.com");
        user.setTuoi(25);

        // Kiểm tra lại các phương thức getter sau khi cập nhật
        System.out.println("\nThông tin người dùng sau khi cập nhật:");
        System.out.println("ID: " + user.getUserId());
        System.out.println("Tên: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Tuổi: " + user.getTuoi());
    }
}
