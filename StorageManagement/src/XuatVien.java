import java.util.ArrayList;

public class XuatVien {

    public void DanhSachXuatVien(ArrayList<BenhNhan> listBenhNhan) {
        System.out.println("Danh sách bệnh nhân đã xuất viện:");
        for (BenhNhan bn : listBenhNhan) {
            if (bn.isDaXuatVien()) {
                System.out.println(bn);
            }
        }
    }
}

