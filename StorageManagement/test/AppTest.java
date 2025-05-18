public class AppTest {
    public static void main(String[] args) {
        System.out.println("---- BẮT ĐẦU TEST APP ----");

        // Test 1: Khởi tạo đối tượng Time bình thường
        Time t1 = new Time(1, 30, 15);
        System.out.println("Test 1 - Time ban đầu: " + t1); // Expect: 01:30:15

        // Test 2: Cộng thêm thời gian khác
        Time t2 = new Time(2, 42, 50);
        t1.addTime(t2);
        System.out.println("Test 2 - Sau khi cộng thêm: " + t1); // Expect: 04:13:05

        // Test 3: Chuyển sang tổng giây
        int totalSeconds = t1.toTotalSeconds();
        System.out.println("Test 3 - Tổng số giây: " + totalSeconds); // Expect: 15185

        // Test 4: Khởi tạo Time với giá trị âm
        Time t3 = new Time(-5, 10, 10);
        System.out.println("Test 4 - Gán giá trị âm: " + t3); // Expect: 00:00:00

        // Test 5: Cộng nhiều lần
        t3.addTime(new Time(0, 120, 90)); // 2 phút + 90 giây => 3 phút 30 giây
        System.out.println("Test 5 - Cộng nhiều lần: " + t3); // Expect: 00:03:30

        System.out.println("---- KẾT THÚC TEST ----");
    }
}
