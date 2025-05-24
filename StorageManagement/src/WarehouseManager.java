public class WarehouseManager {

    private ProductList productList = new ProductList();
    private WarehouseList warehouseList = new WarehouseList();
    private SupplierList supplierList = new SupplierList();

    public void addProduct(Product p) {
        productList.addProduct(p);
    }

    public void addWarehouse(Warehouse w) {
        warehouseList.addWarehouse(w);
    }

    public void addSupplier(Supplier s) {
        supplierList.addSupplier(s);
    }

    public boolean assignProductToWarehouse(int productId, int warehouseId) {
        Product product = null;
        for (Product p : productList.getProducts()) {
            if (p.productId == productId) {
                product = p;
                break;
            }
        }
        if (product == null) return false;

        for (Warehouse w : warehouseList.getWarehouses()) {
            if (w.warehouseId == warehouseId) {
                w.addProduct(product);
                return true;
            }
        }
        return false;
    }

    // Các getter để in danh sách
    public void printProducts() {
        productList.printProductList();
    }

    public void printWarehouses() {
        warehouseList.printWarehouseList();
    }

    public void printSuppliers() {
        supplierList.printSupplierList();
    }

    // Các hàm edit, delete cũng tương tự (bạn có thể mở rộng thêm)
}
