import java.util.*;

public class QuanLyHoaDonXuat {

    // Lớp Hàng Hóa
    static class HangHoa {
        private String maHang;
        private String tenHang;
        private String loaiHang;
        private int soLuongTon;
        private String viTriKho;

        public HangHoa(String maHang, String tenHang, String loaiHang, int soLuongTon, String viTriKho) {
            this.maHang = maHang;
            this.tenHang = tenHang;
            this.loaiHang = loaiHang;
            this.soLuongTon = soLuongTon;
            this.viTriKho = viTriKho;
        }

        public String getMaHang() {
            return maHang;
        }

        public String getTenHang() {
            return tenHang;
        }

        public int getSoLuongTon() {
            return soLuongTon;
        }

        public void setSoLuongTon(int soLuongTon) {
            this.soLuongTon = soLuongTon;
        }

        @Override
        public String toString() {
            return String.format("Ma: %s | Ten: %s | Loai: %s | Ton: %d | Vi tri: %s",
                    maHang, tenHang, loaiHang, soLuongTon, viTriKho);
        }
    }

    // Lớp Hóa Đơn Xuất
    static class HoaDonXuat {
        private String maHoaDon;
        private String maHang;
        private int soLuongXuat;
        private String ngayXuat;
        private String tenKhachHang;

        public HoaDonXuat(String maHoaDon, String maHang, int soLuongXuat, String ngayXuat, String tenKhachHang) {
            this.maHoaDon = maHoaDon;
            this.maHang = maHang;
            this.soLuongXuat = soLuongXuat;
            this.ngayXuat = ngayXuat;
            this.tenKhachHang = tenKhachHang;
        }

        public String getMaHoaDon() {
            return maHoaDon;
        }

        public String getMaHang() {
            return maHang;
        }

        public int getSoLuongXuat() {
            return soLuongXuat;
        }

        public String getNgayXuat() {
            return ngayXuat;
        }

        public void setSoLuongXuat(int soLuongXuat) {
            this.soLuongXuat = soLuongXuat;
        }

        @Override
        public String toString() {
            String tenHang = danhSachHangHoa.containsKey(maHang) ? danhSachHangHoa.get(maHang).getTenHang() : "Khong ro";
            return String.format("Ma HD: %s | Ma hang: %s - %s | SL xuat: %d | Ngay: %s | Khach: %s",
                    maHoaDon, maHang, tenHang, soLuongXuat, ngayXuat, tenKhachHang);
        }
    }

    // Dữ liệu
    static Map<String, HangHoa> danhSachHangHoa = new HashMap<>();
    static List<HoaDonXuat> danhSachHoaDon = new ArrayList<>();

    // Hàm cập nhật hóa đơn xuất
    public static void capNhatHoaDonXuat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay can cap nhat hoa don (yyyy-mm-dd): ");
        String ngayCanTim = sc.nextLine();

        List<HoaDonXuat> hoaDonTrongNgay = new ArrayList<>();
        for (HoaDonXuat hd : danhSachHoaDon) {
            if (hd.getNgayXuat().equals(ngayCanTim)) {
                hoaDonTrongNgay.add(hd);
            }
        }

        if (hoaDonTrongNgay.isEmpty()) {
            System.out.println("Khong co hoa don nao trong ngay " + ngayCanTim + ".");
            return;
        }

        System.out.println("\nDanh sach hoa don xuat kho trong ngay " + ngayCanTim + ":");
        hoaDonTrongNgay.forEach(System.out::println);

        System.out.print("\nNhap ma hoa don can cap nhat: ");
        String maHD = sc.nextLine();

        boolean timThay = false;
        for (HoaDonXuat hd : hoaDonTrongNgay) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) {
                String maHang = hd.getMaHang();
                HangHoa hang = danhSachHangHoa.get(maHang);
                if (hang == null) {
                    System.out.println("Khong tim thay thong tin hang hoa.");
                    return;
                }

                System.out.println("Hoa don hien tai: " + hd);
                System.out.println("Ton kho hien tai: " + hang.getSoLuongTon());
                System.out.print("Nhap so luong xuat moi: ");
                try {
                    int slMoi = Integer.parseInt(sc.nextLine());
                    if (slMoi <= 0) {
                        System.out.println("So luong phai lon hon 0.");
                        return;
                    }
                    int chenhLech = slMoi - hd.getSoLuongXuat();
                    if (chenhLech > hang.getSoLuongTon()) {
                        System.out.println("Khong du ton kho.");
                        return;
                    }

                    hang.setSoLuongTon(hang.getSoLuongTon() - chenhLech);
                    hd.setSoLuongXuat(slMoi);

                    System.out.println("Cap nhat thanh cong.");
                    System.out.println("Hoa don moi: " + hd);
                    timThay = true;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Dinh dang so khong hop le.");
                    return;
                }
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ma hoa don trong ngay.");
        }
    }

    // Main
    public static void main(String[] args) {
        danhSachHangHoa.put("HH005", new HangHoa("HH005", "Giay A4", "Van phong pham", 500, "Ke A3"));
        danhSachHangHoa.put("HH006", new HangHoa("HH006", "Laptop Dell", "Dien tu", 7, "Ke A4"));
        danhSachHangHoa.put("HH007", new HangHoa("HH007", "May chieu", "Thiet bi trinh chieu", 3, "Ke A5"));
        danhSachHangHoa.put("HH008", new HangHoa("HH008", "Ban phim co", "Phu kien", 30, "Ke A6"));
        danhSachHangHoa.put("HH009", new HangHoa("HH009", "Chuot khong day", "Phu kien", 50, "Ke A6"));
        danhSachHangHoa.put("HH010", new HangHoa("HH010", "Tui chong soc", "Balo & Tui", 20, "Ke A7"));

        danhSachHoaDon.add(new HoaDonXuat("HD005", "HH005", 100, "2025-05-31", "Cong ty ABC"));
        danhSachHoaDon.add(new HoaDonXuat("HD006", "HH006", 2, "2025-05-31", "Nguyen Thi Hoa"));
        danhSachHoaDon.add(new HoaDonXuat("HD007", "HH007", 1, "2025-05-31", "Truong THPT A"));
        danhSachHoaDon.add(new HoaDonXuat("HD008", "HH008", 5, "2025-05-30", "Shop PC"));
        danhSachHoaDon.add(new HoaDonXuat("HD009", "HH009", 10, "2025-05-31", "Van phong X"));
        danhSachHoaDon.add(new HoaDonXuat("HD010", "HH010", 3, "2025-05-29", "Hoc sinh Y"));

        capNhatHoaDonXuat();
    }
}
