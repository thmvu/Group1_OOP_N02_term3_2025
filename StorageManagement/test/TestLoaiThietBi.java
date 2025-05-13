public class TestLoaiThietBi {
    public static void main(String[] args) {
        LoaiThietBi loai1 = new LoaiThietBi("L01", "Máy Tính");

        System.out.println("Thông tin loại thiết bị:");
        System.out.println(loai1);

        // Thử cập nhật tên loại thiết bị
        loai1.setTenLoai("Máy In");
        System.out.println("Sau khi đổi tên loại:");
        System.out.println(loai1);
    }
}
