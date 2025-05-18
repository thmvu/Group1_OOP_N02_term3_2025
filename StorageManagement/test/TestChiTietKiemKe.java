public class TestChiTietKiemKe {
    public static void main(String[] args) {
        // Tạo đối tượng ThietBi
        ThietBi tb1 = new ThietBi("TB001", "Máy tính xách tay");
        ThietBi tb2 = new ThietBi("TB002", "Máy in");

        // Tạo đối tượng ChiTietKiemKe
        ChiTietKiemKe ctk1 = new ChiTietKiemKe(tb1, "Tốt");
        ChiTietKiemKe ctk2 = new ChiTietKiemKe(tb2, "Hư hỏng");

        // In thông tin
        System.out.println("Chi tiết kiểm kê 1: " + ctk1.getThietBi().getMaThietBi() + " - " + ctk1.getThietBi().getTenThietBi() + " - " + ctk1.getTinhTrangSauKiemKe());
        System.out.println("Chi tiết kiểm kê 2: " + ctk2.getThietBi().getMaThietBi() + " - " + ctk2.getThietBi().getTenThietBi() + " - " + ctk2.getTinhTrangSauKiemKe());
    }
}