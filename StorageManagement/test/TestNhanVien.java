public class TestNhanVien {
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("NV001", "Vũ Viết Tuấn");

        nv1.hienThiThongTin();

        nv1.setHoTen("Vũ Viết Tuấn");
        System.out.println("\nSau khi cập nhật:");
        nv1.hienThiThongTin();
    }
}
