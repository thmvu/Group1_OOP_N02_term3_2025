import model.Product;
import repository.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID khách hàng: ");
        int customerId = scanner.nextInt();

        List<Product> productList = OrderRepository.getProductsByCustomerId(customerId);

        if (productList.isEmpty()) {
            System.out.println("❌ Không tìm thấy sản phẩm nào cho khách hàng có ID = " + customerId);
        } else {
            System.out.println("✅ Các sản phẩm đã mua bởi khách hàng ID " + customerId + ":");
            for (Product p : productList) {
                System.out.println("- " + p.getName());
            }
        }
    }
}
