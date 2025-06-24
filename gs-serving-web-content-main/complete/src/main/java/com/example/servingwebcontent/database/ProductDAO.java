package com.example.servingwebcontent.database;

import java.util.List;
import com.example.servingwebcontent.model.Product;

public interface ProductDAO {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
    Product getProductById(int productId);

    List<Product> getProductsBySellerId(String sellerId);

    // ✅ MỞ RỘNG:
    List<Product> filterByPriceRange(double minPrice, double maxPrice);
    List<Product> searchByDescription(String keyword);
    List<Product> getProductsPaginated(int page, int pageSize);
}
