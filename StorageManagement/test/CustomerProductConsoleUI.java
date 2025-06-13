import java.sql.Date;
import java.util.List;
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
            System.out.println("1. Them giao dich");
            System.out.println("2. Xoa giao dich");
            System.out.println("3. Cap nhat giao dich");
            System.out.println("4. Hien thi tat ca giao dich");
            System.out.println("5. Thong ke san pham mua nhieu nhat");
            System.out.println("6. Tim kiem giao dich theo tu khoa");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lua chon phai la so nguyen.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1 -> themGiaoDich();
                case 2 -> xoaGiaoDich();
                case 3 -> capNhatGiaoDich();
                case 4 -> manager.showAll();
                case 5 -> manager.reportMostPopularProduct();
                case 6 -> timKiemGiaoDich();
                case 0 -> {
                    System.out.println("Ket thuc chuong trinh.");
                }
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }

    private void themGiaoDich() {
        try {
            System.out.print("Nhap customer ID: ");
            String cid = scanner.nextLine();
            System.out.print("Nhap product ID: ");
            int pid = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap ngay (yyyy-mm-dd): ");
            String dateStr = scanner.nextLine();

            Customer customer = UserList.getInstance().getCustomerInfo(cid);
            Product product = ProductList.getInstance().getProductInfo(pid);

            if (customer == null) {
                System.out.println("Khong tim thay customer voi ID nay.");
                return;
            }
            if (product == null) {
                System.out.println("Khong tim thay product voi ID nay.");
                return;
            }

            manager.add(new Customer_Product(customer, product, Date.valueOf(dateStr)));
        } catch (NumberFormatException e) {
            System.out.println("Product ID phai la so nguyen.");
        } catch (IllegalArgumentException e) {
            System.out.println("Dinh dang ngay khong hop le (yyyy-mm-dd).");
        }
    }

    private void xoaGiaoDich() {
        try {
            System.out.print("Nhap vi tri muon xoa: ");
            int index = Integer.parseInt(scanner.nextLine());
            manager.delete(index);
        } catch (NumberFormatException e) {
            System.out.println("Vi tri phai la so nguyen.");
        }
    }

    private void capNhatGiaoDich() {
        try {
            System.out.print("Nhap vi tri muon cap nhat: ");
            int index = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap customer ID moi: ");
            String cid = scanner.nextLine();
            System.out.print("Nhap product ID moi: ");
            int pid = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap ngay moi (yyyy-mm-dd): ");
            String dateStr = scanner.nextLine();

            Customer customer = UserList.getInstance().getCustomerInfo(cid);
            Product product = ProductList.getInstance().getProductInfo(pid);

            if (customer == null) {
                System.out.println("Khong tim thay customer voi ID nay.");
                return;
            }
            if (product == null) {
                System.out.println("Khong tim thay product voi ID nay.");
                return;
            }

            manager.update(index, new Customer_Product(customer, product, Date.valueOf(dateStr)));
        } catch (NumberFormatException e) {
            System.out.println("Product ID hoac vi tri phai la so nguyen.");
        } catch (IllegalArgumentException e) {
            System.out.println("Dinh dang ngay khong hop le (yyyy-mm-dd).");
        }
    }

    private void timKiemGiaoDich() {
        System.out.print("Nhap tu khoa tim kiem (customerID hoac productID): ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        List<Customer_Product> filtered = manager.filterByKeyword(keyword);
        if (filtered.isEmpty()) {
            System.out.println("Khong tim thay giao dich nao phu hop.");
        } else {
            System.out.println("Ket qua tim kiem:");
            for (Customer_Product cp : filtered) {
                System.out.println(cp);
            }
        }
    }
}
