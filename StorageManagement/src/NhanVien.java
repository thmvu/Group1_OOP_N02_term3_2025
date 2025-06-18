public class NhanVien {
    private String maNhanVien;
    private String hoTen;

    public NhanVien(String maNhanVien, String hoTen) {
        try {
            setMaNhanVien(maNhanVien);
            setHoTen(hoTen);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi tạo NhanVien: " + e.getMessage());
        }
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống.");
        }
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Họ tên nhân viên không được để trống.");
        }
        this.hoTen = hoTen;
    }

    public void hienThiThongTin() {
        try {
            System.out.println("Mã nhân viên: " + maNhanVien);
            System.out.println("Họ tên: " + hoTen);
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị thông tin nhân viên: " + e.getMessage());
        }
    }

    // Hàm main để kiểm thử
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("NV01", "Vũ Viết Tuấn");
        nv1.hienThiThongTin();

        // Test lỗi
        NhanVien nv2 = new NhanVien("", "");
        nv2.hienThiThongTin();
    }
}
