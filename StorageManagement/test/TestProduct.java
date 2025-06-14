import java.util.Scanner;

public class TestProduct {
    static Scanner scanner = new Scanner(System.in);

    public static void hienThiDanhSach() {
        System.out.println("\n--- DANH SACH SAN PHAM ---");
        if (ProductList.getInstance().getProductList().isEmpty()) {
            System.out.println("Khong co san pham nao trong danh sach.");
            return;
        }
        for (Product sp : ProductList.getInstance().getProductList()) {
            sp.displayProductInfo();
            System.out.println("---------------------------");
        }
    }

    public static void themSanPham() {
        System.out.print("Nhap ma san pham: ");
        int productId = scanner.nextInt(); scanner.nextLine();

        // Kiem tra trung ma
        for (Product p : ProductList.getInstance().getProductList()) {
            if (p.getProductId() == productId) {
                System.out.println("Ma san pham da ton tai. Vui long nhap ma khac.");
                return;
            }
        }

        System.out.print("Nhap ma nguoi ban: ");
        int sellerId = scanner.nextInt(); scanner.nextLine();

        System.out.print("Nhap ten san pham: ");
        String productName = scanner.nextLine();

        System.out.print("Nhap gia san pham: ");
        double price = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Nhap so luong ton kho: ");
        int stock = scanner.nextInt(); scanner.nextLine();

        System.out.print("Nhap mo ta san pham: ");
        String description = scanner.nextLine();

        Product sp = new Product(productId, sellerId, productName, price, stock, description);
        ProductList.getInstance().addProduct(sp);
        System.out.println("Da them san pham thanh cong!");
    }

    public static void suaSanPham() {
        System.out.print("Nhap ma san pham can sua: ");
        int productId = scanner.nextInt(); scanner.nextLine();

        for (Product sp : ProductList.getInstance().getProductList()) {
            if (sp.getProductId() == productId) {
                System.out.print("Nhap ten moi: ");
                String name = scanner.nextLine();

                System.out.print("Nhap gia moi: ");
                double price = scanner.nextDouble(); scanner.nextLine();

                System.out.print("Nhap so luong moi: ");
                int stock = scanner.nextInt(); scanner.nextLine();

                System.out.print("Nhap mo ta moi: ");
                String desc = scanner.nextLine();

                sp.setProductName(name);
                sp.setPrice(price);
                sp.setStock(stock);
                sp.setDescription(desc);

                System.out.println("Cap nhat san pham thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham voi ma da nhap.");
    }

    public static void xoaSanPham() {
        System.out.print("Nhap ma san pham can xoa: ");
        int productId = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < ProductList.getInstance().getProductList().size(); i++) {
            if (ProductList.getInstance().getProductList().get(i).getProductId() == productId) {
                ProductList.getInstance().getProductList().remove(i);
                System.out.println("Da xoa san pham.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham de xoa.");
    }

    public static void banSanPham() {
        System.out.print("Nhap ma san pham can ban: ");
        int productId = scanner.nextInt(); scanner.nextLine();

        for (Product sp : ProductList.getInstance().getProductList()) {
            if (sp.getProductId() == productId) {
                System.out.print("Nhap so luong muon ban: ");
                int quantity = scanner.nextInt(); scanner.nextLine();
                if (quantity <= 0) {
                    System.out.println("So luong ban phai lon hon 0.");
                    return;
                }

                if (sp.getStock() < quantity) {
                    System.out.println("Khong du hang trong kho.");
                    return;
                }

                sp.updateStock(quantity);
                System.out.println("Ban san pham thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay san pham can ban.");
    }

    public static void testProduct() {
        // San pham mau
        ProductList.getInstance().addProduct(new Product(1, 100, "Laptop Dell", 15000000, 10, "Laptop van phong"));
        ProductList.getInstance().addProduct(new Product(2, 101, "Chuot Logitech", 500000, 25, "Chuot khong day"));

        int luaChon;
        do {
            System.out.println("\n===== MENU QUAN LY SAN PHAM =====");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Them san pham");
            System.out.println("3. Sua san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Ban san pham (giam ton kho)");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang: ");
            luaChon = scanner.nextInt(); scanner.nextLine();

            switch (luaChon) {
                case 1: hienThiDanhSach(); break;
                case 2: themSanPham(); break;
                case 3: suaSanPham(); break;
                case 4: xoaSanPham(); break;
                case 5: banSanPham(); break;
                case 6: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 6);
    }
}
