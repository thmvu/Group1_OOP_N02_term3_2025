public class BenhNhan {
    private String ten;
    private boolean daXuatVien;

    public BenhNhan(String ten, boolean daXuatVien) {
        try {
            if (ten == null || ten.trim().isEmpty()) {
                throw new IllegalArgumentException("Tên bệnh nhân không được để trống.");
            }
            this.ten = ten;
            this.daXuatVien = daXuatVien;
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo đối tượng BenhNhan: " + e.getMessage());
        }
    }

    public String getTen() {
        return ten;
    }

    public boolean isDaXuatVien() {
        return daXuatVien;
    }

    public void setDaXuatVien(boolean daXuatVien) {
        try {
            this.daXuatVien = daXuatVien;
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật trạng thái xuất viện: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "BenhNhan{ten='" + ten + "', daXuatVien=" + daXuatVien + "}";
    }
}
