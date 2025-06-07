import java.util.ArrayList;

public class MAIN {
    public static void main(String[] args) {
        // Tạo danh sách bệnh nhân
        ArrayList<BenhNhan> danhSach = new ArrayList<>();
        danhSach.add(new BenhNhan("Nguyễn Văn A", true));
        danhSach.add(new BenhNhan("Trần Thị B", false));
        danhSach.add(new BenhNhan("Lê Văn C", true));

        // Gọi phương thức danh sách xuất viện
        XuatVien xuatVien = new XuatVien();
        xuatVien.DanhSachXuatVien(danhSach);
    }

    @Override
    public String toString() {
        return "Main []";
    }
}