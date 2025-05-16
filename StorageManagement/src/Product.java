public class Product {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(int id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.printf("[ID: %d] %s | Loai: %s | SL: %d | Gia: %.2f\n", id, name, category, quantity, price);
    }

    public void updateQuantity(int delta) {
        quantity += delta;
    }

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }

    public String toCSV() {
        return id + "," + name + "," + category + "," + quantity + "," + price;
    }
}
