# 📦 HỆ THỐNG QUẢN LÝ KHO HÀNG - STORAGE MANAGEMENT SYSTEM

## 🧩 Giới thiệu

Đây là một ứng dụng web xây dựng bằng **Java Spring Boot** hỗ trợ quản lý kho hàng cho doanh nghiệp vừa và nhỏ. Hệ thống phân vai trò người dùng (Customer, Seller, Manager), hỗ trợ xử lý hàng hóa, hóa đơn và các tác vụ nghiệp vụ liên quan.

---

## 👨‍💻 Nhóm phát triển

- **Từ Hữu Minh Vũ**  
- **Nguyễn Hữu Tình**  
- **Vũ Viết Tuấn**

---

## 🏗️ Kiến trúc hệ thống

### Các thực thể chính:

| Class        | Vai trò                                                            |
|--------------|---------------------------------------------------------------------|
| `User`       | Lớp cơ sở của tất cả người dùng: `Customer`, `Seller`, `Manager`  |
| `Customer`   | Người mua, có thể đặt hàng và xem lịch sử mua                      |
| `Seller`     | Người bán sản phẩm, quản lý sản phẩm của họ                        |
| `Manager`    | Quản trị viên, có quyền quản lý toàn bộ người dùng và hàng hóa     |
| `Product`    | Sản phẩm trong kho, thuộc sở hữu của một `Seller`                 |
| `Invoice`    | Hóa đơn mua hàng của `Customer`, lưu thông tin đơn hàng và trạng thái |
| `InvoiceItem`| Chi tiết từng sản phẩm trong hóa đơn                              |

---

## 🧱 Mô hình lớp tiêu biểu

### `User.java` (trừu tượng người dùng)

```
public class User {
    private String userID, fullName, gender, phone, email, address, password, role;
    private LocalDate dob;
    
    public boolean login(String username, String password) {
        return (username.equals(phone) || username.equals(email)) && this.password.equals(password);
    }
}
```
**trong đấy có các đối tượng chia theo role**
- Manager
- Seller
- Customer
### `Product.java` (trừu tượng hàng hóa)

```
public class Product {
    private Integer productId;
    private Seller seller;
    private String productName, description, imageUrl;
    private double price;
    private int stock;
    
    public void updateStock(int quantitySold) { ... }
}
```
### `Invoice.java` (trừu tượng hóa đơn)

```
public class Invoice {
    private String invoiceId;
    private Customer customer;
    private LocalDateTime createdAt;
    private List<InvoiceItem> items;
    private String status;
    private double totalAmount;
}
```
⚙️ Tính năng hệ thống
👨‍⚖️ Phân quyền
Customer: đăng nhập, mua hàng, xem hóa đơn

Seller: đăng nhập, quản lý sản phẩm của mình

Manager: toàn quyền quản lý người dùng, sản phẩm và hóa đơn

📦 Quản lý sản phẩm
Thêm / sửa / xóa sản phẩm

Gán sản phẩm cho người bán (seller)

Tìm kiếm sản phẩm theo từ khóa

Hiển thị hình ảnh, mô tả, số lượng, giá

👥 Quản lý người dùng
Thêm / sửa / xóa Customer, Seller, Manager

Xem danh sách người dùng và vai trò

Tìm kiếm người dùng theo tên, email

🧾 Quản lý hóa đơn
Tạo hóa đơn khi khách hàng đặt hàng

Hiển thị các hóa đơn theo trạng thái

Xem chi tiết từng đơn hàng

Quản lý lịch sử giao dịch

💾 Lưu trữ
Dữ liệu có thể lưu trong CSDL MySQL hoặc file nhị phân

Trong bộ nhớ sử dụng: ArrayList, Map, LinkedList, ...

Có thể chuyển hóa sang dùng JPA nếu cần mở rộng quy mô

🖥️ Giao diện người dùng
Giao diện thân thiện sử dụng Thymeleaf

Thiết kế theo Glass UI

Modal hiển thị form thêm/sửa không cần reload

Phân trang bằng Thymeleaf

Responsive, phù hợp cả desktop và mobile

###🚀 Hướng dẫn chạy dự án

# 1. Clone về máy
git clone https://github.com/yourusername/warehouse-management-system.git
cd warehouse-management-system

# 2. Build & run
./mvnw spring-boot:run

# 3. Truy cập
http://localhost:8080/

📸 Demo và mô hình
Biểu đồ UML


Sequence Diagram


Activity Diagram


Giao diện đăng nhập


Giao diện người dùng



📬 Góp ý & Liên hệ
Hãy tạo issue hoặc pull request nếu bạn muốn đóng góp.
Chúng tôi sẵn sàng tiếp nhận mọi ý kiến để cải thiện dự án tốt hơn!


