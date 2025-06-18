package models;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String unit;

    // Constructor
    public Product(String id, String name, double price, int quantity, String unit) {
        try {
            setId(id);
            setName(name);
            setPrice(price);
            setQuantity(quantity);
            setUnit(unit);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi khởi tạo sản phẩm: " + e.getMessage());
        }
    }

    // Cập nhật số lượng tồn kho
    public void updateStock(int qtyChange) {
        if (this.quantity + qtyChange < 0) {
            System.out.println("Không đủ hàng để trừ. Số lượng hiện tại: " + this.quantity);
        } else {
            this.quantity += qtyChange;
        }
    }

    // Trả về thông tin sản phẩm
    public String getInfo() {
        return name + " - " + quantity + " " + unit + " - " + price + " VND";
    }

    // Getter và Setter có kiểm tra hợp lệ
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID sản phẩm không được để trống.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sản phẩm không được để trống.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Giá sản phẩm không được âm.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Số lượng không được âm.");
        }
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        if (unit == null || unit.trim().isEmpty()) {
            throw new IllegalArgumentException("Đơn vị không được để trống.");
        }
        this.unit = unit;
    }

    // Hàm main kiểm thử
    public static void main(String[] args) {
        System.out.println("=== Sản phẩm hợp lệ ===");
        Product p1 = new Product("P001", "Sữa hộp", 15000, 10, "hộp");
        System.out.println(p1.getInfo());
        p1.updateStock(-3);
        System.out.println("Sau khi trừ 3: " + p1.getInfo());

        System.out.println("\n=== Sản phẩm lỗi ===");
        Product p2 = new Product("", "", -5000, -3, "");
        System.out.println(p2.getInfo());
        p2.updateStock(-100); // Không đủ hàng
    }
}
