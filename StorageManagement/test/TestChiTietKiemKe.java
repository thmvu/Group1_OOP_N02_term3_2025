public class TestChiTietKiemKe {
    public static void main(String[] args) {
        // Tao doi tuong ThietBi
        ThietBi tb1 = new ThietBi("TB001", "May tinh xach tay");
        ThietBi tb2 = new ThietBi("TB002", "May in");

        // Tao doi tuong ChiTietKiemKe
        ChiTietKiemKe ctk1 = new ChiTietKiemKe(tb1, "Hoat dong binh thuong");
        ChiTietKiemKe ctk2 = new ChiTietKiemKe(tb2, "Can bao tri");

        // In thong tin
        System.out.println(ctk1);
        System.out.println(ctk2);
    }
}
