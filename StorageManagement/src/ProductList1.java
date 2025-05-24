import java.util.*;

public class ProductList1 {
    private List<Product1> products = new ArrayList<>();

    public void add(Product1 product) {
        products.add(product);
    }

    public List<Product1> getProducts() {
        return products;
    }

    public void print() {
        for (Product1 p : products) {
            System.out.println(p);
        }
    }
}

// WarehouseList1.java
import java.util.*;

public class WarehouseList1 {
    private List<Warehouse1> warehouses = new ArrayList<>();

    public void add(Warehouse1 w) {
        warehouses.add(w);
    }

    public List<Warehouse1> getWarehouses() {
        return warehouses;
    }

    public void print() {
        for (Warehouse1 w : warehouses) {
            System.out.println(w);
        }
    }
}
