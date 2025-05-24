import java.io.Serializable;
import java.util.ArrayList;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    public int warehouseId;
    public String warehouseName;

    private ArrayList<Product> products = new ArrayList<>();

    public Warehouse(int warehouseId, String warehouseName) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(p -> p.productId == productId);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Warehouse[id=" + warehouseId + ", name=" + warehouseName + ", productsCount=" + products.size() + "]";
    }
}
