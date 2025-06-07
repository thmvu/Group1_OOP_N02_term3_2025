import java.util.ArrayList;
import java.util.List;

public class TimKiemMatHang {
    public static void main(String[] args) {
        // Tạo danh sách mặt hàng
        List<MatHang> danhSachMatHang = new ArrayList<>();
        danhSachMatHang.add(new MatHang("MH001", "Laptop"));
        danhSachMatHang.add(new MatHang("MH002", "Chuột không dây"));
        danhSachMatHang.add(new MatHang("MH003", "Bàn phím cơ"));

        // Gọi các hàm test
        hienThiTenMatHangTheoMa(danhSachMatHang, "MH002");
        hienThiTenMatHangTheoMa(danhSachMatHang, "MH003");
        hienThiTenMatHangTheoMa(danhSachMatHang, "MH999"); // Mã không tồn tại
    }

    // ✅ Hàm hiển thị tên mặt hàng theo mã
    public static void hienThiTenMatHangTheoMa(List<MatHang> danhSach, String maMH) {
        System.out.println("\n🔍 Đang tìm mã mặt hàng: " + maMH);
        boolean timThay = false;

        for (MatHang mh : danhSach) {
            if (mh.getMaMatHang().equalsIgnoreCase(maMH)) {
                System.out.println("✅ Tên mặt hàng: " + mh.getTenMatHang());
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("❌ Không tìm thấy mặt hàng với mã: " + maMH);
        }
    }
}
