public class Product1 {
    private int id;
    private String name;
    private int quantity;

    public Product1(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Số lượng: " + quantity + ")";
    }
}

// Warehouse1.java
public class Warehouse1 {
    private int id;
    private String location;

    public Warehouse1(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return id + " - " + location;
    }
}