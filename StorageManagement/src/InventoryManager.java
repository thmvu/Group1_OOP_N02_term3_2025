import java.util.*;

public class InventoryManager extends Human {
    private List<Product> products = new ArrayList<>();

    public InventoryManager(String name, String gender, String birthDate, String phoneNumber,
                            String email, String address, String citizenId) {
        super(name, gender, birthDate, phoneNumber, email, address, citizenId);
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showAllProducts() {
        System.out.println("=== Danh sach san pham ===");
        for (Product p : products) {
            p.display();
        }
    }

    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public boolean sellProduct(String name, int quantity) {
        Product p = findProductByName(name);
        if (p != null && p.getQuantity() >= quantity) {
            p.updateQuantity(-quantity);
            return true;
        }
        return false;
    }

    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getQuantity() * p.getPrice();
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }
}

