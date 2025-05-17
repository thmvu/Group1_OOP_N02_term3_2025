package models;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String unit;

    public Product(String id, String name, double price, int quantity, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public void updateStock(int qtyChange) {
        this.quantity += qtyChange;
    }

    public String getInfo() {
        return name + " - " + quantity + " " + unit + " - " + price + " VND";
    }

    // Getters and Setters...
}
