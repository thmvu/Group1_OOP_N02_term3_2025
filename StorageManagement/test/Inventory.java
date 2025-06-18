package models;

import java.util.*;

import model.Product;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(String productId) {
        products.remove(productId);
    }

    public Product findProduct(String productId) {
        return products.get(productId);
    }

    public void listProducts() {
        for (Product p : products.values()) {
            System.out.println(p.getInfo());
        }
    }
}

