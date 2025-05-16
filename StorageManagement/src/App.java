import java.util.Scanner;

public class App {

    public static void managerMenu(InventoryManager manager, Scanner sc) {
        while (true) {
            System.out.println("\n===== MENU QUAN LY KHO =====");
            System.out.println("1. Xem tat ca san pham");
            System.out.println("2. Them san pham");
            System.out.println("3. Ban san pham");
            System.out.println("4. Luu danh sach san pham ra file CSV");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    manager.showAllProducts();
                    break;
                case 2:
                    System.out.print("Nhap ID san pham: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten san pham: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap loai san pham: ");
                    String category = sc.nextLine();
                    System.out.print("Nhap so luong: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap gia: ");
                    double price = Double.parseDouble(sc.nextLine());

                    Product newProduct = new Product(id, name, category, quantity, price);
                    manager.addProduct(newProduct);
                    System.out.println("Da them san pham!");
                    break;
                case 3:
                    System.out.print("Nhap ten san pham muon ban: ");
                    String sellName = sc.nextLine();
                    System.out.print("Nhap so luong muon ban: ");
                    int sellQuantity = Integer.parseInt(sc.nextLine());
                    boolean success = manager.sellProduct(sellName, sellQuantity);
                    if (success) {
                        System.out.println("Ban hang thanh cong!");
                    } else {
                        System.out.println("Khong du so luong hoac san pham khong ton tai!");
                    }
                    break;
                case 4:
                    FileHelper.saveProductsToCSV(manager.getProducts(), "products.csv");
                    break;
                case 5:
                    System.out.println("Thoat menu quan ly.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static void customerMenu(InventoryManager manager, Customer customer, Scanner sc) {
        Order order = new Order();

        while (true) {
            System.out.println("\n===== MENU KHACH HANG =====");
            System.out.println("1. Dat hang");
            System.out.println("2. Xem don hang");
            System.out.println("3. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten san pham can dat: ");
                    String productName = sc.nextLine();
                    System.out.print("Nhap so luong: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    Product p = manager.findProductByName(productName);
                    if (p != null && p.getQuantity() >= quantity) {
                        order.addItem(new OrderItem(p, quantity));
                        manager.sellProduct(productName, quantity);
                        System.out.println("Da them vao don hang!");
                    } else {
                        System.out.println("San pham khong ton tai hoac khong du so luong!");
                    }
                    break;
                case 2:
                    order.displayOrder();
                    break;
                case 3:
                    System.out.println("Thoat menu khach hang.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        // Them nguoi dung vao he thong
        userManager.addUser(new User("admin", "admin123", "admin"));
        userManager.addUser(new User("manager", "manager123", "manager"));
        userManager.addUser(new User("customer", "customer123", "customer"));

        System.out.print("Nhap username: ");
        String username = sc.nextLine();
        System.out.print("Nhap password: ");
        String password = sc.nextLine();

        User loggedIn = userManager.authenticate(username, password);

        if (loggedIn == null) {
            System.out.println("Dang nhap that bai!");
            return;
        }

        System.out.println("Dang nhap thanh cong voi quyen: " + loggedIn.getRole());

        InventoryManager manager = new InventoryManager(
                "Nguyen Van A", "Nam", "01/01/1990", "0909123456",
                "nva@gmail.com", "123 ABC", "012345678");

        // Them san pham mac dinh
        manager.addProduct(new Product(1, "Banh", "Thuc pham", 100, 5.0));
        manager.addProduct(new Product(2, "Sua", "Do uong", 50, 10.0));

        if (loggedIn.getRole().equals("manager") || loggedIn.getRole().equals("admin")) {
            managerMenu(manager, sc);
        } else if (loggedIn.getRole().equals("customer")) {
            Customer customer = new Customer("Tran Thi B", "Nu", "15/05/1995",
                    "0911223344", "ttb@gmail.com", "456 XYZ", "032456789");
            customerMenu(manager, customer, sc);
        }
    }
}
