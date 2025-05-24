import java.util.ArrayList;

public class WarehouseList {
    private ArrayList<Warehouse1> warehouses = new ArrayList<>();

    public ArrayList<Warehouse1> addWarehouse(Warehouse1 w) {
        warehouses.add(w);
        return warehouses;
    }

    public ArrayList<Warehouse1> editWarehouse(int warehouseId, String newName) {
        for (Warehouse1 w : warehouses) {
            if (w.warehouseId == warehouseId) {
                w.warehouseName = newName;
            }
        }
        return warehouses;
    }

    public ArrayList<Warehouse1> deleteWarehouse(int warehouseId) {
        warehouses.removeIf(w -> w.warehouseId == warehouseId);
        return warehouses;
    }

    public void printWarehouseList() {
        for (Warehouse1 w : warehouses) {
            System.out.println("Warehouse ID: " + w.warehouseId + ", Name: " + w.warehouseName + ", Product Count: " + w.getProducts().size());
        }
    }

    public ArrayList<Warehouse1> getWarehouses() {
        return warehouses;
    }
}
