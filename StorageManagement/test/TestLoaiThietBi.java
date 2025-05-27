public class TestLoaiThietBi {
    public static void main(String[] args) {
        // Tạo đối tượng
        LoaiThietBi thietBi1 = new LoaiThietBi("L01", "Máy in");
        LoaiThietBi thietBi2 = new LoaiThietBi("L02", "Máy chiếu");

        // In thông tin
        System.out.println(thietBi1);
        System.out.println(thietBi2);

        // Thay đổi thông tin
        thietBi2.setTenLoai("Máy scan");
        System.out.println("Sau khi cập nhật: " + thietBi2);
    }
}
