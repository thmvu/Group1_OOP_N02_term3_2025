public class NhanVien {
    private String maNhanVien;
    private String hoTen;

    public NhanVien(String maNhanVien, String hoTen) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void hienThiThongTin() {
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
    }
}
