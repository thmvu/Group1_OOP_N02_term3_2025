public class RandomNumber {
    public static void main(String[] args) {
        try {
            int number = TestRandomNumber.getRandomNumber(1, 100);
            System.out.printf("So ngau nhien la: %d\n", number);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi lấy số ngẫu nhiên: " + e.getMessage());
            e.printStackTrace(); // In thêm thông tin lỗi (tuỳ chọn)
        }
    }
}
