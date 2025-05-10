## HỆ THỐNG QUẢN LÝ KHO HÀNG 

# Giới thiệu 
Quản lí hệ thống kho hàng nhằm tránh thất thoát cũng như để quản lý chặt chẽ

## Thành viên
Từ Hữu Minh Vũ 
Nguyễn Hữu Tình
Vũ Viết Tuấn
## Đối tượng tham chiếu 
   Quản lý thiết bị



class Thiết bị{
int ma thiết bị

String tên thiết bị
}
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
