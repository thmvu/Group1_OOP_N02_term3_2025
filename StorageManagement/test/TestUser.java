// TestUser.java
import java.util.Scanner;

public class TestUser {
    public static void test() {
        UserList userList = new UserList();

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
                    System.out.print("Nhap vai tro (Khach hang / Nha cung cap): ");
                    String role = scanner.nextLine();

                    if(role.equalsIgnoreCase("Khach hang")) {
                        userList.addUser(new Customer(id, name, gender, dob, phone, email, address, pass));
                    } else if(role.equalsIgnoreCase("Nha cung cap")) {
                        userList.addUser(new Seller(id, name, gender, dob, phone, email, address, pass));
                    } else {
                        System.out.println("Vai tro khong hop le, them that bai!");
                    }
                    break;
                case 3:
                    System.out.print("Nhap ID user can sua: ");
                    String idSua = scanner.nextLine();
                    System.out.print("Nhap ten moi: ");
                    String tenMoi = scanner.nextLine();
                    userList.getEditUser(tenMoi, idSua);
                    break;
                case 4:
                    System.out.print("Nhap ID user can xoa: ");
                    String idXoa = scanner.nextLine();
                    userList.getDeleteUser(idXoa);
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
