public class MatHang {
    private String maMatHang;
    private String tenMatHang;

    public MatHang(String maMatHang, String tenMatHang) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    @Override
    public String toString() {
        return maMatHang + " - " + tenMatHang;
    }
}
