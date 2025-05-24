import java.util.ArrayList;
import java.util.Scanner;

public class TestProduct {

    public static void test() {
        // Tạo một sản phẩm mới
        Product product1 = new Product(101, 5001, "Ao Hoodie", 250000, 100, "Ao hoodie mau den, chat lieu cotton.");
        product1.displayProductInfo();
        product1.updateStock(20); // Giả sử bán 20 chiếc
        product1.displayProductInfo();
    }

    public ArrayList<Product> addList() {
        ArrayList<Product> pr = new ArrayList<Product>();

        Product pr_1 = new Product(1, 5001, "Ao Am", 150000, 20, "Ao am mua dong");
        Product pr_2 = new Product(2, 5002, "Quan Jean", 250000, 15, "Quan jean xanh");
        Product pr_3 = new Product(3, 5003, "Giay Da", 500000, 10, "Giay da den");

        pr.add(pr_1);
        pr.add(pr_2);
        pr.add(pr_3);

        return pr;
    }

    public void testEditDelete() {
        Product pr_1 = new Product(1, 5001, "Ao Am", 150000, 20, "Ao am mua dong");
        Product pr_2 = new Product(2, 5002, "Quan Jean", 250000, 15, "Quan jean xanh");
        Product pr_3 = new Product(3, 5003, "Giay Da", 500000, 10, "Giay da den");

        ProductList proList = new ProductList();
        proList.addProduct(pr_1);
        proList.addProduct(pr_2);
        proList.addProduct(pr_3);

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID san pham can sua: ");
        int idEdit = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.println("Nhap ten moi cho san pham: ");
        String newName = sc.nextLine();

        proList.getEditProduct(newName, idEdit);
        proList.printProductList();

        System.out.println("Nhap ID san pham can xoa: ");
        int idDelete = sc.nextInt();

        proList.getDeleteProduct(idDelete);
        System.out.println("Danh sach sau khi xoa:");
        proList.printProductList();

        sc.close();
    }

    public void testDelete(ProductList proList, int productId) {
        proList.getDeleteProduct(productId);
        proList.printProductList();
    }
}
