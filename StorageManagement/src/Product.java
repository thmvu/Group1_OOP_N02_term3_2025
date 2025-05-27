public class Product {
    private String name;
    private int id;
    private int quantity;
    private double price;
    private String origin;
    private String colorType;

    public Product(String name, int id, int quantity, double price, String origin, String colorType) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.origin = origin;
        this.colorType = colorType;
    }

    // Getter & Setter (tối thiểu cần cho sửa)
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %s | SL: %d | Giá: %.2f | Xuất xứ: %s | Loại màu: %s",
            id, name, quantity, price, origin, colorType);
    }
}
