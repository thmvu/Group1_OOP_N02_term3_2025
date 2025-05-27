import java.util.ArrayList;
import java.util.Scanner;

public class TestProduct {
    public void testAddProduct() {
        System.out.println("Test thêm sản phẩm:");
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10, 18000000, "Việt Nam", "Bạc"));
        productList.addProduct(new Product("Chuột Logitech", 102, 50, 600000, "Mỹ", "Đen"));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20, 1200000, "Hàn Quốc", "RGB"));
        productList.printProductList();
        System.out.println();
    }

    public void testEditProduct() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10, 18000000, "Việt Nam", "Bạc"));
        productList.addProduct(new Product("Chuột Logitech", 102, 50, 600000, "Mỹ", "Đen"));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20, 1200000, "Hàn Quốc", "RGB"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập ID sản phẩm cần sửa:");
        int id = sc.nextInt(); sc.nextLine();

        System.out.println("Nhập tên mới:");
        String newName = sc.nextLine();

        System.out.println("Nhập số lượng mới:");
        int newQty = sc.nextInt(); sc.nextLine();

        System.out.println("Nhập giá mới:");
        double newPrice = sc.nextDouble(); sc.nextLine();

        System.out.println("Nhập xuất xứ mới:");
        String newOrigin = sc.nextLine();

        System.out.println("Nhập loại màu mới:");
        String newColor = sc.nextLine();

        productList.getEditProduct(id, newName, newQty, newPrice, newOrigin, newColor);

        System.out.println("Danh sách sau khi sửa:");
        productList.printProductList();
        System.out.println();
    }

    public void testDeleteProduct() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10, 18000000, "Việt Nam", "Bạc"));
        productList.addProduct(new Product("Chuột Logitech", 102, 50, 600000, "Mỹ", "Đen"));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20, 1200000, "Hàn Quốc", "RGB"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập ID sản phẩm cần xóa:");
        int id = sc.nextInt();

        productList.getDeleteProduct(id);

        System.out.println("Danh sách sau khi xóa:");
        productList.printProductList();
        System.out.println();
    }

    public void testAll() {
        ProductList productList = new ProductList();

        // Thêm
        productList.addProduct(new Product("Laptop Dell   ", 101, 10, 18000000, "Việt Nam", "Bạc"));
        productList.addProduct(new Product("Chuột Logitech", 102, 50, 600000  , "   Mỹ   ", "Đen"));
        productList.addProduct(new Product("Bàn phím cơ   ", 103, 20, 1200000 , "Hàn Quốc", "RGB"));

        System.out.println("Danh sách sản phẩm ban đầu:");
        productList.printProductList();

        // Sửa
        productList.getEditProduct(102, "Chuột Logitech MX", 45, 750000, "Mỹ", "Xám");
        System.out.println("\nSau khi sửa sản phẩm ID 102:");
        productList.printProductList();

        // Xóa
        productList.getDeleteProduct(101);
        System.out.println("\nSau khi xóa sản phẩm ID 101:");
        productList.printProductList();
    }

    public static void main(String[] args) {
        TestProduct tester = new TestProduct();
        tester.testAddProduct();
        tester.testEditProduct();
        tester.testDeleteProduct();
        tester.testAll();
    }
}
