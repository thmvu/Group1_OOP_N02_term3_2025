import java.util.*;
import java.util.stream.Collectors;

// Lớp đại diện cho Hàng Hóa
class HangHoa {
    private String maHang;
    private String tenHang;
    private String loaiHang;
    private int soLuongTon;
    private String ngayNhap;
    private String viTriKho;

    public HangHoa(String maHang, String tenHang, String loaiHang, int soLuongTon, String ngayNhap, String viTriKho) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.viTriKho = viTriKho;
    }

    // ✅ Getter cho ngày nhập (bắt buộc phải có để tránh lỗi)
    public String getNgayNhap() {
        return ngayNhap;
    }

    @Override
    public String toString() {
        return String.format("Mã hàng: %s | Tên hàng: %s | Loại: %s | Số lượng: %d | Ngày nhập: %s | Vị trí: %s",
                maHang, tenHang, loaiHang, soLuongTon, ngayNhap, viTriKho);
    }
}

// Lớp chính hiển thị hàng theo ngày nhập
public class HienThiTheoNgayNhap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Danh sách hàng hóa mẫu
        List<HangHoa> danhSachHangHoa = Arrays.asList(
            new HangHoa("HH001", "Máy in", "Điện tử", 10, "2025-05-31", "Kệ A1"),
            new HangHoa("HH002", "Bút chì", "Văn phòng phẩm", 100, "2025-05-30", "Kệ A2"),
            new HangHoa("HH003", "Bàn học", "Nội thất", 20, "2025-05-31", "Kệ B1"),
            new HangHoa("HH004", "Ghế sofa", "Nội thất", 5, "2025-05-29", "Kệ B2")
        );

        // Nhập ngày cần kiểm tra
        System.out.print("Nhập ngày cần kiểm tra (yyyy-mm-dd): ");
        String ngayCanTim = scanner.nextLine();

        // Lọc hàng nhập đúng ngày
        List<HangHoa> ketQua = danhSachHangHoa.stream()
                .filter(h -> h.getNgayNhap().equals(ngayCanTim))
                .collect(Collectors.toList());

        // Hiển thị kết quả
        if (ketQua.isEmpty()) {
            System.out.println("Không có hàng nào được nhập vào ngày " + ngayCanTim + ".");
        } else {
            System.out.println("Danh sách hàng nhập kho vào ngày " + ngayCanTim + ":");
            ketQua.forEach(System.out::println);
        }

        scanner.close();
    }
}
