import java.util.ArrayList;

public class XuatVien {

    public void DanhSachXuatVien(ArrayList<BenhNhan> listBenhNhan) {
        System.out.println("Danh sách bệnh nhân đã xuất viện:");
        try {
            for (BenhNhan bn : listBenhNhan) {
                if (bn != null && bn.isDaXuatVien()) {
                    System.out.println(bn);
                }
            }
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi xử lý danh sách bệnh nhân: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất xử lý danh sách xuất viện.");
        }
    }
}

