package models;

import java.util.*;

import model.Customer;
import model.Product;

public class Order {
    private String id;
    private Customer customer;
    private String date;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String id, Customer customer, String date) {
        this.id = id;
        this.customer = customer;
        this.date = date;
    }

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            product.updateStock(-quantity);
            items.add(new OrderItem(product, quantity));
        } else {
            System.out.println("Không đủ hàng: " + product.getName());
        }
    }

    public double totalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.product.getPrice() * item.quantity;
        }
        return total;
    }

    private class OrderItem {
        Product product;
        int quantity;

        OrderItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }
}

