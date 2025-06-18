public class LoaiThietBi {

    private String maLoai;
    private String tenLoai;

    public LoaiThietBi() {
        // Constructor mặc định
    }

    public LoaiThietBi(String maLoai, String tenLoai) {
        setMaLoai(maLoai);      // Gọi setter để dùng luôn kiểm tra lỗi
        setTenLoai(tenLoai);
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        if (maLoai == null || maLoai.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã loại thiết bị không được để trống.");
        }
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        if (tenLoai == null || tenLoai.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên loại thiết bị không được để trống.");
        }
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiThietBi{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }

    // Hàm main để kiểm thử
    public static void main(String[] args) {
        try {
            LoaiThietBi thietBi1 = new LoaiThietBi("LTB01", "Máy siêu âm");
            System.out.println(thietBi1);

            // Test lỗi - tên loại để trống
            LoaiThietBi thietBi2 = new LoaiThietBi("LTB02", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
