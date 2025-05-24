public class WarehouseManager1 {
    ProductList1 productList = new ProductList1();
    WarehouseList1 warehouseList = new WarehouseList1();
    SupplierList1 supplierList = new SupplierList1();

    public void addProduct(Product1 p) { productList.add(p); }
    public void addWarehouse(Warehouse1 w) { warehouseList.add(w); }
    public void addSupplier(Supplier1 s) { supplierList.add(s); }

    public void assignProductToWarehouse(int productId, int warehouseId) {
        System.out.println("Assigned product " + productId + " to warehouse " + warehouseId);
    }

    public void printProducts() { productList.print(); }
    public void printWarehouses() { warehouseList.print(); }
    public void printSuppliers() { supplierList.print(); }
}