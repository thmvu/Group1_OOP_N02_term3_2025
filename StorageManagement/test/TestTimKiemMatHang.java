import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTimKiemMatHang {
    public static void main(String[] args) {
        // Tạo danh sách mặt hàng với 10 sản phẩm
        List<MatHang> danhSach = new ArrayList<>();
        danhSach.add(new MatHang("MH001", "Laptop"));
        danhSach.add(new MatHang("MH002", "Chuột không dây"));
        danhSach.add(new MatHang("MH003", "Bàn phím cơ"));
        danhSach.add(new MatHang("MH004", "Màn hình LCD"));
        danhSach.add(new MatHang("MH005", "Tai nghe Bluetooth"));
        danhSach.add(new MatHang("MH006", "Ổ cứng SSD"));
        danhSach.add(new MatHang("MH007", "USB 64GB"));
        danhSach.add(new MatHang("MH008", "Webcam Full HD"));
        danhSach.add(new MatHang("MH009", "Microphone thu âm"));
        danhSach.add(new MatHang("MH010", "Loa vi tính"));

        // Hiển thị danh sách
        System.out.println("🛒 Danh sách mặt hàng:");
        for (MatHang mh : danhSach) {
            System.out.println("- " + mh);
        }

        // Nhập mã mặt hàng cần tìm
        Scanner sc = new Scanner(System.in);
        System.out.print("\n🔍 Nhập mã mặt hàng cần tìm: ");
        String maCanTim = sc.nextLine();

        // Gọi hàm tìm kiếm
        hienThiTenMatHangTheoMa(danhSach, maCanTim);
    }

    // Hàm tìm và hiển thị tên mặt hàng
    public static void hienThiTenMatHangTheoMa(List<MatHang> danhSach, String maMH) {
        for (MatHang mh : danhSach) {
            if (mh.getMaMatHang().equalsIgnoreCase(maMH)) {
                System.out.println("✅ Tên mặt hàng: " + mh.getTenMatHang());
                return;
            }
        }
        System.out.println("❌ Không tìm thấy mặt hàng với mã: " + maMH);
    }
}
