package com.example.servingwebcontent.model;

import java.util.ArrayList;

public class ProductList {
    private static ProductList instance;
    private ArrayList<Product> productList;

    // Constructor riêng tư để đảm bảo Singleton
    private ProductList() {
        productList = new ArrayList<>();
    }

    // Trả về instance duy nhất
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        if (product != null) {
            productList.add(product);
        }
    }

    // Lấy danh sách sản phẩm
    public ArrayList<Product> getProductList() {
        return productList;
    }

    // Sửa tên sản phẩm theo productId
    public boolean editProductName(int productId, String newName) {
        for (Product p : productList) {
            if (p.getProductId() == productId) {
                p.setProductName(newName);
                return true;
            }
        }
        return false;
    }

    // Xóa sản phẩm theo ID
    public boolean deleteProduct(int productId) {
        return productList.removeIf(p -> p.getProductId() == productId);
    }

    // Hiển thị tất cả sản phẩm
    public void printProductList() {
        if (productList.isEmpty()) {
            System.out.println("Khong co san pham nao trong danh sach.");
            return;
        }
        for (Product p : productList) {
            p.displayProductInfo();
            System.out.println("---------------------------");
        }
    }

    // Lấy thông tin 1 sản phẩm theo ID
    public Product getProductInfo(int productId) {
        return productList.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    // Kiểm tra sản phẩm có tồn tại
    public boolean isProductExist(int productId) {
        return productList.stream().anyMatch(p -> p.getProductId() == productId);
    }

    // Tìm sản phẩm theo tên gần đúng (không phân biệt hoa thường)
    public ArrayList<Product> searchProductByName(String keyword) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Lọc sản phẩm theo sellerId
    public ArrayList<Product> getProductsBySeller(int sellerId) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getSeller().equals(String.valueOf(sellerId))) {
                result.add(p);
            }
        }
        return result;
    }
}
