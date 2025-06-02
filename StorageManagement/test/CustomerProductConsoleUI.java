import java.sql.Date;
import java.util.Scanner;

public class CustomerProductConsoleUI {
    private CustomerProductManager manager;
    private Scanner scanner;

    public CustomerProductConsoleUI(CustomerProductManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm giao dịch");
            System.out.println("2. Xóa giao dịch");
            System.out.println("3. Cập nhật giao dịch");
            System.out.println("4. Hiển thị tất cả giao dịch");
            System.out.println("5. Thống kê sản phẩm mua nhiều nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn phải là số nguyên.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Nhập customer ID: ");
                        String cid = scanner.nextLine();
                        System.out.print("Nhập product ID: ");
                        int pid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập ngày (yyyy-mm-dd): ");
                        String dateStr = scanner.nextLine();
                        manager.add(new Customer_Product(new Customer(cid), new Product(pid), Date.valueOf(dateStr)));
                    } catch (NumberFormatException e) {
                        System.out.println("Product ID phải là số nguyên.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Định dạng ngày không hợp lệ (yyyy-mm-dd).");
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("Nhập vị trí muốn xóa: ");
                        int index = Integer.parseInt(scanner.nextLine());
                        manager.delete(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Vị trí phải là số nguyên.");
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Nhập vị trí muốn cập nhật: ");
                        int index = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập customer ID mới: ");
                        String cid = scanner.nextLine();
                        System.out.print("Nhập product ID mới: ");
                        int pid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập ngày mới (yyyy-mm-dd): ");
                        String dateStr = scanner.nextLine();
                        manager.update(index, new Customer_Product(new Customer(cid), new Product(pid), Date.valueOf(dateStr)));
                    } catch (NumberFormatException e) {
                        System.out.println("Product ID hoặc vị trí phải là số nguyên.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Định dạng ngày không hợp lệ (yyyy-mm-dd).");
                    }
                }
                case 4 -> manager.showAll();
                case 5 -> manager.reportMostPopularProduct();
                case 0 -> System.out.println("Kết thúc chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}