public class Sanpham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double giaBan; // <- Thêm thuộc tính này

    public Sanpham(String maSP, String tenSP, int soLuong, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public String toString() {
        return maSP + " - " + tenSP + " - SL: " + soLuong + " - Giá: " + giaBan;
    }
}
