public class BenhNhan {
    private String ten;
    private boolean daXuatVien;

    public BenhNhan(String ten, boolean daXuatVien) {
        this.ten = ten;
        this.daXuatVien = daXuatVien;
    }

    public String getTen() {
        return ten;
    }

    public boolean isDaXuatVien() {
        return daXuatVien;
    }

    public void setDaXuatVien(boolean daXuatVien) {
        this.daXuatVien = daXuatVien;
    }

    @Override
    public String toString() {
        return "BenhNhan{ten='" + ten + "', daXuatVien=" + daXuatVien + "}";
    }
}
