public class TestApp1 {
    public static void main(String[] args) {
        WarehouseManager1 manager = new WarehouseManager1();

        manager.addProduct(new Product1(1, "Laptop Dell", 10));
        manager.addProduct(new Product1(2, "Chuột Logitech", 50));
        manager.addProduct(new Product1(3, "Bàn phím cơ", 30));

        manager.addWarehouse(new Warehouse1(1, "Kho Hà Nội"));
        manager.addWarehouse(new Warehouse1(2, "Kho Sài Gòn"));

        manager.addSupplier(new Supplier1(1, "Công ty ABC"));
        manager.addSupplier(new Supplier1(2, "Công ty XYZ"));

        manager.assignProductToWarehouse(1, 1);
        manager.assignProductToWarehouse(2, 1);
        manager.assignProductToWarehouse(3, 2);

        System.out.println("Danh sách sản phẩm:");
        manager.printProducts();

        System.out.println("\nDanh sách kho:");
        manager.printWarehouses();

        System.out.println("\nDanh sách nhà cung cấp:");
        manager.printSuppliers();

        DataIO1.writeToFile("products1.dat", manager.productList.getProducts());
        DataIO1.writeToFile("warehouses1.dat", manager.warehouseList.getWarehouses());
        DataIO1.writeToFile("suppliers1.dat", manager.supplierList.getSuppliers());

        var productsFromFile = DataIO1.readFromFile("products1.dat");
        var warehousesFromFile = DataIO1.readFromFile("warehouses1.dat");
        var suppliersFromFile = DataIO1.readFromFile("suppliers1.dat");

        System.out.println("\nĐọc dữ liệu từ file:");
        System.out.println("Products: " + productsFromFile);
        System.out.println("Warehouses: " + warehousesFromFile);
        System.out.println("Suppliers: " + suppliersFromFile);
    }
}
