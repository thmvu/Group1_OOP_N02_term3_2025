import java.util.ArrayList;
import java.util.Scanner;

public class TestProduct {
    ArrayList<Product> pl = new ArrayList<>();

    // Tạo danh sách sản phẩm mẫu
    public ArrayList<Product> addList() {
        Product p1 = new Product("Laptop Dell", 101, 10);
        Product p2 = new Product("Chuột Logitech", 102, 50);
        Product p3 = new Product("Bàn phím cơ", 103, 20);
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        return pl;
    }

    // Test thêm sản phẩm
    public void testAddProduct() {
        System.out.println("Test thêm sản phẩm:");
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10));
        productList.addProduct(new Product("Chuột Logitech", 102, 50));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20));
        productList.printProductList();
        System.out.println();
    }

    // Test sửa sản phẩm (nhập input)
    public void testEditProduct() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10));
        productList.addProduct(new Product("Chuột Logitech", 102, 50));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20));

        System.out.println("Nhập ID sản phẩm cần sửa:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Nhập tên mới cho sản phẩm:");
        String newName = sc.nextLine();

        System.out.println("Nhập số lượng mới:");
        int newQty = sc.nextInt();

        productList.getEditProduct(id, newName, newQty);

        System.out.println("Danh sách sau khi sửa:");
        productList.printProductList();
        System.out.println();
    }

    // Test xóa sản phẩm (nhập input)
    public void testDeleteProduct() {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Laptop Dell", 101, 10));
        productList.addProduct(new Product("Chuột Logitech", 102, 50));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20));

        System.out.println("Nhập ID sản phẩm cần xóa:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        productList.getDeleteProduct(id);

        System.out.println("Danh sách sau khi xóa:");
        productList.printProductList();
        System.out.println();
    }

    // Test chạy tổng hợp: thêm - sửa - xóa
    public void testAll() {
        ProductList productList = new ProductList();

        // Thêm
        productList.addProduct(new Product("Laptop Dell", 101, 10));
        productList.addProduct(new Product("Chuột Logitech", 102, 50));
        productList.addProduct(new Product("Bàn phím cơ", 103, 20));
        System.out.println("Danh sách sản phẩm ban đầu:");
        productList.printProductList();

        // Sửa
        productList.getEditProduct(102, "Chuột Logitech MX", 45);
        System.out.println("\nSau khi sửa sản phẩm ID 102:");
        productList.printProductList();

        // Xóa
        productList.getDeleteProduct(101);
        System.out.println("\nSau khi xóa sản phẩm ID 101:");
        productList.printProductList();
    }

    public static void main(String[] args) {
        TestProduct tester = new TestProduct();

        // test từng phần
        tester.testAddProduct();

        tester.testEditProduct();

        tester.testDeleteProduct();

        // test tổng hợp
        tester.testAll();
    }
}
