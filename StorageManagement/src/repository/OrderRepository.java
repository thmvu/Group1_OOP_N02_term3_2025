package repository;

import model.*;

import java.util.*;

public class OrderRepository {
    private static List<Order> orders = new ArrayList<>();

    static {
        Customer c1 = new Customer(1, "An");
        Customer c2 = new Customer(2, "Bình");

        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(102, "Chuột");
        Product p3 = new Product(103, "Bàn phím");

        orders.add(new Order(1, c1, Arrays.asList(p1, p2)));
        orders.add(new Order(2, c2, Arrays.asList(p3)));
        orders.add(new Order(3, c1, Arrays.asList(p3)));
    }

    public static List<Product> getProductsByCustomerId(int customerId) {
        List<Product> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId() == customerId) {
                result.addAll(order.getProducts());
            }
        }
        return result;
    }
}
