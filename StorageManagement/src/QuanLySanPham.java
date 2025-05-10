import java.util.ArrayList;
import java.util.List;
public class QuanLySanPham {
    private List<Sanpham> danhSachSP = new ArrayList<>();

    public void themSanPham(Sanpham sp) {
        danhSachSP.add(sp);
    }

    public Sanpham timTheoMa(String ma) {
        for (Sanpham sp : danhSachSP) {
            if (sp.getMaSP().equals(ma)) {
                return sp;
            }
        }
        return null;
    }

    // Xóa, cập nhật, in danh sách, lọc theo tên, tồn kho,...
}
