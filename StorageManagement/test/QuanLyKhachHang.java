import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang {
    public static void main(String[] args) {
        // Tạo danh sách sản phẩm
        SanPham sp1 = new SanPham("SP001", "Laptop");
        SanPham sp2 = new SanPham("SP002", "Chuột");
        SanPham sp3 = new SanPham("SP003", "Bàn phím");

        // Tạo danh sách khách hàng
        List<KhachHang> danhSachKH = new ArrayList<>();

        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A");
        kh1.muaSanPham(sp1);
        kh1.muaSanPham(sp2);

        KhachHang kh2 = new KhachHang("KH002", "Trần Thị B");
        kh2.muaSanPham(sp2);

        KhachHang kh3 = new KhachHang("KH003", "Lê Văn C");
        kh3.muaSanPham(sp3);

        danhSachKH.add(kh1);
        danhSachKH.add(kh2);
        danhSachKH.add(kh3);

        // Gọi hàm test chung
        testHienThiKhachHangDaMuaSanPham(danhSachKH, "SP002");
        testHienThiKhachHangDaMuaSanPham(danhSachKH, "SP003");
        testHienThiKhachHangDaMuaSanPham(danhSachKH, "SP999"); // Không có ai mua
    }

    // ✅ Hàm test chung để hiển thị khách hàng đã mua sản phẩm
    public static void testHienThiKhachHangDaMuaSanPham(List<KhachHang> danhSachKH, String maSP) {
        System.out.println("\n📦 Kiểm tra khách hàng đã mua sản phẩm mã: " + maSP);
        boolean coKhach = false;
        for (KhachHang kh : danhSachKH) {
            if (kh.daMuaSanPham(maSP)) {
                System.out.println(kh);
                coKhach = true;
            }
        }

        if (!coKhach) {
            System.out.println("❌ Không có khách hàng nào đã mua sản phẩm này.");
        }
    }
}
