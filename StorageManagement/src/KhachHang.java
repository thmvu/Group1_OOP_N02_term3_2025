import java.util.ArrayList;
import java.util.List;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private List<SanPham> sanPhamDaMua;

    public KhachHang(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sanPhamDaMua = new ArrayList<>();
    }

    public void muaSanPham(SanPham sp) {
        sanPhamDaMua.add(sp);
    }

    public boolean daMuaSanPham(String maSP) {
        for (SanPham sp : sanPhamDaMua) {
            if (sp.getMaSanPham().equalsIgnoreCase(maSP)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mã KH: " + maKH + " - Tên KH: " + tenKH;
    }
}
