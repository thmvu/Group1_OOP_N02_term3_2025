public class NhanVien {
    private String maNhanVien;
    private String hoTen;

    // Constructor
    public NhanVien(String maNhanVien, String hoTen) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
    }

    // Getter và Setter cho maNhanVien
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    // Getter và Setter cho hoTen
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Override toString để in thông tin nhân viên
    @Override
    public String toString() {
        return "Mã nhân viên: " + maNhanVien + ", Họ tên: " + hoTen;
    }
}
