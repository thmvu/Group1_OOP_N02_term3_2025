package com.example.servingwebcontent;


public class Product {
    private int productId;         // Mã sản phẩm
    private int sellerId;          // Mã người bán
    private String productName;    // Tên sản phẩm
    private double price;          // Giá sản phẩm
    private int stock;             // Số lượng sản phẩm
    private String description;    // Mô tả sản phẩm

    // Constructor để khởi tạo đối tượng sản phẩm
    public Product(int productId, int sellerId, String productName, double price, int stock, String description) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public Product(int productId) {
        this.productId = productId;
        this.sellerId = 0;
        this.productName = "Chưa xác định";
        this.price = 0.0;
        this.stock = 0;
        this.description = "Không có mô tả";
    }
    // Getter và Setter cho các thuộc tính

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getSellerId() { return sellerId; }
    public void setSellerId(int sellerId) { this.sellerId = sellerId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // Phương thức hiển thị thông tin sản phẩm
    public void displayProductInfo() {
        System.out.println("Ma san pham: " + productId);
        System.out.println("Ma nguoi ban: " + sellerId);
        System.out.println("Ten san pham: " + productName);
        System.out.println("Gia: " + price);
        System.out.println("So luong con lai: " + stock);
        System.out.println("Mo ta: " + description);
    }

    // Phương thức cập nhật số lượng sản phẩm sau khi bán
    public void updateStock(int quantitySold) {
        if (quantitySold <= stock) {
            stock -= quantitySold;
            System.out.println("Cap nhap so luong thanh cong. so luong con lai: " + stock);
        } else {
            System.out.println("So luong ban khong hop le. khong du hang!");
        }
    }
}
