package com.example.servingwebcontent.model;

public class Product {
    private int productId;           // Mã sản phẩm
    private Seller seller;          // Người bán (tên hoặc ID người bán)
    private String productName;      // Tên sản phẩm
    private double price;            // Giá sản phẩm
    private int stock;               // Số lượng sản phẩm
    private String description;      // Mô tả sản phẩm

    // Constructor mặc định
    public Product() {
        this.productId = 0;
        this.seller = null;
        this.productName = "";
        this.price = 0.0;
        this.stock = 0;
        this.description = "";
    }

    // Constructor với productId
    public Product(int productId) {
        this.productId = productId;
        this.seller = null;
        this.productName = "Chưa xác định";
        this.price = 0.0;
        this.stock = 0;
        this.description = "Không có mô tả";
    }

    // Getter và Setter
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public Seller getSeller() {return seller;}
    public void setSeller(Seller seller) {this.seller = seller;}

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
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Người bán: " + (seller != null ? seller : "Chưa gán"));
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng còn lại: " + stock);
        System.out.println("Mô tả: " + description);
    }

    // Phương thức cập nhật số lượng sản phẩm sau khi bán
    public void updateStock(int quantitySold) {
        if (quantitySold <= stock) {
            stock -= quantitySold;
            System.out.println("Cập nhật số lượng thành công. Số lượng còn lại: " + stock);
        } else {
            System.out.println("Số lượng bán không hợp lệ. Không đủ hàng!");
        }
    }

    
}