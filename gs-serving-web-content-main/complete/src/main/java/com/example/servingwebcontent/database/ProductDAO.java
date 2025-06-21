package com.example.servingwebcontent.database;

import java.util.List;

import com.example.servingwebcontent.model.Product;

public interface ProductDAO {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
    Product getProductById(int productId);

    //lấy danh sách tất cả sản phẩm của một Seller
    
    List<Product> getProductsBySellerId(String sellerId); // ✅ mới thêm
}