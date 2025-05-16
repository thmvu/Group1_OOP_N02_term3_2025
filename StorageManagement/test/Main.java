public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng phòng ban
        PhongBan pb1 = new PhongBan("PB01", "Phòng Kế Toán");
        PhongBan pb2 = new PhongBan("PB02", "Phòng Nhân Sự");

        // In thông tin phòng ban
        System.out.println("Thông tin phòng ban 1:");
        System.out.println(pb1);

        System.out.println("Thông tin phòng ban 2:");
        System.out.println(pb2);
    }
}
