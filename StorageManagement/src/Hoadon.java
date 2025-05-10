import java.util.*;

public class Hoadon {
    private String maHD;
    private Date ngayLap;
    private Khachhang khachHang;
    private NhanVien nhanVien;
    private List<ChiTietHoaDon> dsChiTiet;

    public Hoadon(String maHD, Date ngayLap, Khachhang khachHang, NhanVien nhanVien) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.dsChiTiet = new ArrayList<>();
    }

    public void themChiTiet(Sanpham sp, int soLuong) {
        dsChiTiet.add(new ChiTietHoaDon(sp, soLuong));
    }

    public double tinhTongTien() {
        double tong = 0;
        for (ChiTietHoaDon ct : dsChiTiet) {
            tong += ct.getThanhTien();
        }
        return tong;
    }

    // getter & setter
}

class ChiTietHoaDon {
    private Sanpham sanPham;
    private int soLuong;

    public ChiTietHoaDon(Sanpham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return sanPham.getGiaBan() * soLuong;
    }

    // getter & setter
}
