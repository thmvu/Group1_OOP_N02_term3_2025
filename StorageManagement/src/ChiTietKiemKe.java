public class ChiTietKiemKe {
    private ThietBi thietBi;
    private String tinhTrangSauKiemKe;

    // Constructor
    public ChiTietKiemKe(ThietBi thietBi, String tinhTrangSauKiemKe) {
        this.thietBi = thietBi;
        this.tinhTrangSauKiemKe = tinhTrangSauKiemKe;
    }

    // Getters va Setters
    public ThietBi getThietBi() {
        return thietBi;
    }

    public void setThietBi(ThietBi thietBi) {
        this.thietBi = thietBi;
    }

    public String getTinhTrangSauKiemKe() {
        return tinhTrangSauKiemKe;
    }

    public void setTinhTrangSauKiemKe(String tinhTrangSauKiemKe) {
        this.tinhTrangSauKiemKe = tinhTrangSauKiemKe;
    }

    @Override
    public String toString() {
        return "ChiTietKiemKe [ThietBi=" + thietBi + ", TinhTrangSauKiemKe=" + tinhTrangSauKiemKe + "]";
    }
}
