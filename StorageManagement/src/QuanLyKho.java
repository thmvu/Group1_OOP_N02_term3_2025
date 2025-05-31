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

    public String getLoaiHang() {
        return loaiHang;
    }

    public String getMaHang() {
        return maHang;
    }

    @Override
    public String toString() {
        return String.format("Mã hàng: %s | Tên hàng: %s | Loại hàng: %s | Số lượng tồn: %d | Ngày nhập: %s | Vị trí: %s",
                maHang, tenHang, loaiHang, soLuongTon, ngayNhap, viTriKho);
    }
}

// Lớp chính quản lý kho
public class QuanLyKho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<HangHoa> danhSach = new ArrayList<>();

        // Dữ liệu mẫu
        danhSach.add(new HangHoa("HH001", "Ghế văn phòng", "Nội thất", 40, "2025-05-09", "Kệ C1"));
        danhSach.add(new HangHoa("HH002", "Bàn làm việc", "Nội thất", 25, "2025-05-10", "Kệ C2"));
        danhSach.add(new HangHoa("HH003", "Đèn bàn", "Nội thất", 35, "2025-05-11", "Kệ C3"));

        int chon;
        do {
            System.out.println("\n==== MENU QUẢN LÝ KHO ====");
            System.out.println("1. Thêm hàng hóa");
            System.out.println("2. Hiển thị tất cả hàng hóa");
            System.out.println("3. Tìm hàng theo loại");
            System.out.println("4. Tìm hàng theo mã");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            chon = Integer.parseInt(scanner.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã hàng: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhập tên hàng: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập loại hàng: ");
                    String loai = scanner.nextLine();
                    System.out.print("Nhập số lượng tồn: ");
                    int sl = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập ngày nhập (yyyy-mm-dd): ");
                    String ngay = scanner.nextLine();
                    System.out.print("Nhập vị trí kho: ");
                    String viTri = scanner.nextLine();

                    danhSach.add(new HangHoa(ma, ten, loai, sl, ngay, viTri));
                    System.out.println("✔ Đã thêm hàng thành công.");
                    break;

                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách hàng hóa rỗng.");
                    } else {
                        System.out.println("=== Danh sách hàng hóa ===");
                        danhSach.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Nhập loại hàng cần tìm: ");
                    String loaiCanTim = scanner.nextLine();
                    List<HangHoa> ketQuaLoai = danhSach.stream()
                            .filter(h -> h.getLoaiHang().equalsIgnoreCase(loaiCanTim))
                            .collect(Collectors.toList());
                    if (ketQuaLoai.isEmpty()) {
                        System.out.println("Không tìm thấy hàng theo loại.");
                    } else {
                        ketQuaLoai.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã hàng cần tìm: ");
                    String maCanTim = scanner.nextLine();
                    Optional<HangHoa> ketQuaMa = danhSach.stream()
                            .filter(h -> h.getMaHang().equalsIgnoreCase(maCanTim))
                            .findFirst();
                    if (ketQuaMa.isPresent()) {
                        System.out.println(ketQuaMa.get());
                    } else {
                        System.out.println("Không tìm thấy hàng theo mã.");
                    }
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ.");
            }

        } while (chon != 0);

        scanner.close();
    }
}

