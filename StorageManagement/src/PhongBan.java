public class PhongBan {
    private String maPhong;
    private String tenPhong;

    // Constructor
    public PhongBan(String maPhong, String tenPhong) {
        try {
            setMaPhong(maPhong);
            setTenPhong(tenPhong);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi tạo đối tượng PhongBan: " + e.getMessage());
        }
    }

    // Getter và Setter
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        if (maPhong == null || maPhong.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã phòng không được để trống.");
        }
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        if (tenPhong == null || tenPhong.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên phòng không được để trống.");
        }
        this.tenPhong = tenPhong;
    }

    // Phương thức hiển thị thông tin
    public void hienThiThongTin() {
        try {
            System.out.println("Mã phòng: " + maPhong);
            System.out.println("Tên phòng: " + tenPhong);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị thông tin phòng ban: " + e.getMessage());
        }
    }

    // Hàm main kiểm thử
    public static void main(String[] args) {
        PhongBan pb1 = new PhongBan("P001", "Kế toán");
        pb1.hienThiThongTin();

        PhongBan pb2 = new PhongBan("", ""); // Test lỗi
        pb2.hienThiThongTin();
    }
}
