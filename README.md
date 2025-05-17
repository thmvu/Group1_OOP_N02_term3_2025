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
class Thietbi{
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

class Quản lý{

int  mã thiết bị

int mã Loại

int  số lượng
}
class User{

int UserID

String UserRole

String Name

Date Ngay sinh

 String Diachi
}
 


# PHuong thuc hoat dong (Operations)

```
Quản lý số lượng
Quản lý phân loại
Quản lý thiết bị theo loại



```
Quản lý số lượng
{
int mã thiết bị

int số lượng
}
Quản lý phân loại
{
int mã loại

String tên loại
}
Quản lý thiết bị theo loại
{
int mã thiết bị
int mã loại
}
