## HỆ THỐNG QUẢN LÝ KHO HÀNG 

# Giới thiệu 
Quản lí hệ thống kho hàng nhằm tránh thất thoát cũng như để quản lý chặt chẽ

## Thành viên
Từ Hữu Minh Vũ 
Nguyễn Hữu Tình
Vũ Viết Tuấn
# Mô tả Đối tượng Quản lý thiết bị

## Mô tả

```
Thiết bị (Device)

Người dùng (User)

Thiết bị và Người dùng (Device-User)


```

## Xây dựng Class 

Thiết bị

```
class Sanpham{
   //tat ca thông tin miêu tả thiết bị

int maThietBi;

String tên thiết bị
}

```

Người dùng 
```

class Nguoidung{

   int maNguoiDung;
   String tenNguoiDung;

   //cac thong tin mo ta nguoi


}
```

Thiết bị người dùng

```
class thietbi_nguoidung{

   int maThietBi;
   int maNguoiDung;
}


```
# Yêu cầu(Request)
- Giao diện Java Spring Boot.
- Có chức năng quản lý Kho Hàng
# PHuong thuc hoat dong (Operations)

```
 Thêm, sửa, xóa hàng hóa

+ Liệt kê thông tin về hàng hóa trong kho, có thể lọc ra các sản phẩm theo phân loại sản phẩm
- Có chức năng quản lý .......

+ Thêm, sửa, xóa người dùng.
- Có chức năng gán sản phẩm cho người dùng. 

- Dữ liệu được lưu trữ xuống file nhị phân

+ Cần tạo các lớp liên quan đến sản phẩm, người dùng, và thietbi_nguoidung để đọc, ghi xuống 1 hay nhiều file.

- Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map, ....

- Sinh viên có thể thêm các chức năng vào chương trình để ứng dụng phong phú hơn bằng cách thêm các nghiệp vụ cho bài toán (tùy chọn)



```
tuong tac giua cac class 
vd top cac san pham(product) ma duoc khach hang ua chuong 
   seller ban duoc nhieu nhat trong tuan 
   
