import java.util.Date;

public class TestPhieuKiemKe {
    public static void main(String[] args) {
        // Tao nhan vien
        NhanVien nv1 = new NhanVien("NV001", "Nguyen Van A");

        // Tao thiet bi
        ThietBi tb1 = new ThietBi("TB001", "May tinh xach tay");
        ThietBi tb2 = new ThietBi("TB002", "May in");

        // Tao chi tiet kiem ke
        ChiTietKiemKe ctk1 = new ChiTietKiemKe(tb1, "Hoat dong binh thuong");
        ChiTietKiemKe ctk2 = new ChiTietKiemKe(tb2, "Can bao tri");

        // Tao phieu kiem ke
        PhieuKiemKe phieu = new PhieuKiemKe("PKK001", new Date(), nv1);

        // Them chi tiet vao phieu
        phieu.themChiTiet(ctk1);
        phieu.themChiTiet(ctk2);

        // In thong tin phieu kiem ke
        phieu.inThongTin();
    }
}
