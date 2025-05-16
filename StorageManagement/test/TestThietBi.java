public class TestThietBi {
    public static void main(String[] args) {
        LoaiThietBi loai1 = new LoaiThietBi("L01", "Máy in");
        PhongBan phong1 = new PhongBan("PB01", "Phòng Kế Toán");

        ThietBi tb1 = new ThietBi("TB01", "Canon LBP2900", loai1, phong1);

        System.out.println("Thông tin thiết bị:");
        System.out.println(tb1);
    }
}
