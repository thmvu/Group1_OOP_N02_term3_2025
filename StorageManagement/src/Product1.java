public class Product1 {
    private int id;
    private String name;
    private int quantity;

    public Product1(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Product1{id=" + id + ", name='" + name + "', quantity=" + quantity + "}";
    }
}