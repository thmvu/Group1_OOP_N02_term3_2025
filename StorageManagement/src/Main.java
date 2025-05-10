public class Main {
    public static void main(String[] args) {
        QuanLySanPham ql = new QuanLySanPham();

        Sanpham sp1 = new Sanpham("SP01", "Bàn phím", 10, 250000);
        Sanpham sp2 = new Sanpham("SP02", "Me máy", 5, 320000);

        ql.themSanPham(sp1);
        ql.themSanPham(sp2);



        System.out.println("Tìm theo mã SP01:");
        Sanpham sp = ql.timTheoMa("SP01");
        if (sp != null) {
            System.out.println(sp);
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
}
