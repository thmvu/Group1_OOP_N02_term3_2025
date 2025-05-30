public class TestPhongBan {
    public static void main(String[] args) {
        // Tạo đối tượng PhongBan
        PhongBan pb1 = new PhongBan("PB001", "Phòng Kỹ Thuật");

        // Hiển thị thông tin
        pb1.hienThiThongTin();

        // Thử thay đổi thông tin
        pb1.setTenPhong("Phòng Hành Chính");
        System.out.println("\nSau khi cập nhật tên phòng:");
        pb1.hienThiThongTin();
    }
}
