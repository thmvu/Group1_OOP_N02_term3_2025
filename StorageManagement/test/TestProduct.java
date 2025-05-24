public class TestProduct {
  public static void main() {
        // Tạo một sản phẩm mới
        Product product1 = new Product(101, 5001, "Ao Hoodie", 250000, 100, "Ao hoodie mau den, chat lieu cotton.");

        // Hiển thị thông tin sản phẩm
        product1.displayProductInfo();

        // Cập nhật số lượng sản phẩm sau khi bán
        product1.updateStock(20); // Giả sử bán được 20 chiếc

        // Hiển thị lại thông tin sản phẩm sau khi cập nhật
        product1.displayProductInfo();
    }
}