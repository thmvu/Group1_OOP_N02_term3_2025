import java.util.Scanner;

public class TestUser {
    public static void testUser() {
        UserList userList = UserList.getInstance();

        // Them user mau
        userList.addUser(new Customer("KH001", "Nguyen Van An", "Nam", "2005-12-16", "0901239303", "a@gmail.com", "Ha Noi", "123456"));
        userList.addUser(new Customer("KH002", "Nguyen Duy Bao", "Nam", "2005-04-04", "0945983647", "b@gmail.com", "TP.HCM", "123456"));
        userList.addUser(new Seller("NC001", "Nguyen Thi Lan Anh", "Nu", "2005-04-09", "0945989814", "c@gmail.com", "Dak Lak", "123456"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU QUAN LY USER =====");
            System.out.println("1. Hien thi danh sach user");
            System.out.println("2. Them user moi");
            System.out.println("3. Sua ten user");
            System.out.println("4. Xoa user");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    userList.printUserList();
                    break;
                case 2:
                    System.out.print("Nhap ID user: ");
                    String id = scanner.nextLine();

                    // Kiểm tra ID trùng
                    if (userList.getCustomerInfo(id) != null) {
                        System.out.println("ID da ton tai. Vui long thu lai!");
                        break;
                    }

                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap gioi tinh: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhap ngay sinh: ");
                    String dob = scanner.nextLine();
                    System.out.print("Nhap so dien thoai: ");
                    String phone = scanner.nextLine();
                    System.out.print("Nhap email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhap dia chi: ");
                    String address = scanner.nextLine();
                    System.out.print("Nhap mat khau: ");
                    String pass = scanner.nextLine();

                    System.out.println("Chon vai tro:");
                    System.out.println("1. Khach hang");
                    System.out.println("2. Nha cung cap");
                    System.out.print("Nhap lua chon: ");
                    int roleChoice = scanner.nextInt(); scanner.nextLine();

                    if (roleChoice == 1) {
                        userList.addUser(new Customer(id, name, gender, dob, phone, email, address, pass));
                        System.out.println("Them khach hang thanh cong.");
                    } else if (roleChoice == 2) {
                        userList.addUser(new Seller(id, name, gender, dob, phone, email, address, pass));
                        System.out.println("Them nha cung cap thanh cong.");
                    } else {
                        System.out.println("Lua chon khong hop le, them that bai!");
                    }
                    break;
                case 3:
                    System.out.print("Nhap ID user can sua: ");
                    String idSua = scanner.nextLine();

                    if (userList.getCustomerInfo(idSua) == null) {
                        System.out.println("Khong tim thay user co ID nay.");
                        break;
                    }

                    System.out.print("Nhap ten moi: ");
                    String tenMoi = scanner.nextLine();
                    userList.getEditUser(tenMoi, idSua);
                    System.out.println("Cap nhat thanh cong.");
                    break;
                case 4:
                    System.out.print("Nhap ID user can xoa: ");
                    String idXoa = scanner.nextLine();

                    if (userList.getCustomerInfo(idXoa) == null) {
                        System.out.println("Khong tim thay user de xoa.");
                        break;
                    }

                    userList.getDeleteUser(idXoa);
                    System.out.println("Da xoa user.");
                    break;
                case 5:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while(choice != 5);

        scanner.close();
    }
}
