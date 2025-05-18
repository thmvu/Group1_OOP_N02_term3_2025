public class TimeTest {
    public static void main(String[] args) {
        // Test 1: Tạo đối tượng Time và kiểm tra định dạng
        Time t1 = new Time(1, 30, 75); // Sẽ được chuẩn hóa thành 1h 31m 15s
        System.out.println("Test 1 - Normalize: " + t1); // Expect: 01:31:15

        // Test 2: Tổng thời gian
        Time t2 = new Time(2, 40, 50);
        t1.addTime(t2);
        System.out.println("Test 2 - Add Time: " + t1); // Expect: 04:12:05

        // Test 3: Tổng số giây
        int totalSeconds = t1.toTotalSeconds();
        System.out.println("Test 3 - Total Seconds: " + totalSeconds); // Expect: 15125

        // Test 4: Gán giá trị âm (xử lý lỗi)
        Time t3 = new Time(-5, 10, 10);
        System.out.println("Test 4 - Negative time: " + t3); // Expect: 00:00:00
    }
}
