// File: App.java
public class App {
    public static void main(String[] args) {
        System.out.println("Chạy chương trình chính...");
        
        // Test Time class
        Time t1 = new Time(1, 30, 15);
        Time t2 = new Time(2, 42, 50);
        t1.addTime(t2);

        System.out.println("Tổng thời gian sau khi cộng: " + t1);
        System.out.println("Tổng số giây: " + t1.toTotalSeconds());

        // Test với giá trị âm
        Time t3 = new Time(-5, 10, 10); // Sẽ reset về 0
        System.out.println("Thời gian âm (được xử lý): " + t3);
    }
}
