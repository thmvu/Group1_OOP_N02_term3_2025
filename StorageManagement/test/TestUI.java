import java.util.Scanner;

public class TestUI {
    static Scanner scanner = new Scanner(System.in);
    static CustomerProductManager manager = new CustomerProductManager();

    public static void testAll() {
        int choice;
        do {
            System.out.println("\n=== MENU CHINH ===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly nguoi dung");
            System.out.println("3. Giao dich mua hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1 -> TestProduct.testProduct();  // dùng chung Scanner
                case 2 -> TestUser.testUser();        // dùng chung Scanner
                case 3 -> new CustomerProductConsoleUI(manager).run();  // dùng chung Scanner
                case 0 -> {
                    System.out.println("Tam biet!");
                    scanner.close(); // ✅ Đóng scanner tại đây nếu muốn
                }
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}
