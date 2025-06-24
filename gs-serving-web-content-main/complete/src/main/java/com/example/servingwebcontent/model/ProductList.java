package com.example.servingwebcontent.model;

import java.util.ArrayList;

public class ProductList {
    private static ProductList instance;
    private ArrayList<Product> productList;

    private ProductList() {
        productList = new ArrayList<>();
    }

    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

    public void addProduct(Product product) {
        if (product != null) {
            productList.add(product);
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public boolean editProductName(int productId, String newName) {
        for (Product p : productList) {
            if (p.getProductId() == productId) {
                p.setProductName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        return productList.removeIf(p -> p.getProductId() == productId);
    }

    public void printProductList() {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong danh sách.");
            return;
        }
        for (Product p : productList) {
            System.out.println(p.getProductName() + " - " + p.getPrice() + " VNĐ");
            System.out.println("---------------------------");
        }
    }

    public Product getProductInfo(int productId) {
        return productList.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    public boolean isProductExist(int productId) {
        return productList.stream().anyMatch(p -> p.getProductId() == productId);
    }

    public ArrayList<Product> searchProductByName(String keyword) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public ArrayList<Product> getProductsBySeller(String sellerId) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getSeller() != null && p.getSeller().getUserID().equals(sellerId)) {
                result.add(p);
            }
        }
        return result;
    }
}
