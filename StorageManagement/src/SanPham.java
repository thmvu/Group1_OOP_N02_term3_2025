public class SanPham {
    private String maSanPham;
    private String tenSanPham;

    public SanPham(String maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    @Override
    public String toString() {
        return maSanPham + " - " + tenSanPham;
    }
}
