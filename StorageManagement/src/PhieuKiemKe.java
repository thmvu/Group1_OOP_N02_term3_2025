import java.util.ArrayList;
import java.util.Date;

public class PhieuKiemKe {
    private String maPhieu;
    private Date ngayKiemKe;
    private NhanVien nguoiKiemKe;
    private ArrayList<ChiTietKiemKe> danhSachChiTiet;

    public PhieuKiemKe(String maPhieu, Date ngayKiemKe, NhanVien nguoiKiemKe) {
        this.maPhieu = maPhieu;
        this.ngayKiemKe = ngayKiemKe;
        this.nguoiKiemKe = nguoiKiemKe;
        this.danhSachChiTiet = new ArrayList<>();
    }

    public void themChiTiet(ChiTietKiemKe chiTiet) {
        danhSachChiTiet.add(chiTiet);
    }

    public void inThongTin() {
        System.out.println("Ma phieu: " + maPhieu);
        System.out.println("Ngay kiem ke: " + ngayKiemKe);
        System.out.println("Nguoi kiem ke: " + nguoiKiemKe);
        System.out.println("Danh sach chi tiet kiem ke: ");
        for (ChiTietKiemKe ctk : danhSachChiTiet) {
            System.out.println(ctk);
        }
    }
}
