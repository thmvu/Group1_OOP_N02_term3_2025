import java.util.ArrayList;

public class WarehouseList {
    private ArrayList<Warehouse> warehouses = new ArrayList<>();

    public ArrayList<Warehouse> addWarehouse(Warehouse w) {
        warehouses.add(w);
        return warehouses;
    }

    public ArrayList<Warehouse> editWarehouse(int warehouseId, String newName) {
        for (Warehouse w : warehouses) {
            if (w.warehouseId == warehouseId) {
                w.warehouseName = newName;
            }
        }
        return warehouses;
    }

    public ArrayList<Warehouse> deleteWarehouse(int warehouseId) {
        warehouses.removeIf(w -> w.warehouseId == warehouseId);
        return warehouses;
    }

    public void printWarehouseList() {
        for (Warehouse w : warehouses) {
            System.out.println("Warehouse ID: " + w.warehouseId + ", Name: " + w.warehouseName + ", Product Count: " + w.getProducts().size());
        }
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }
}
