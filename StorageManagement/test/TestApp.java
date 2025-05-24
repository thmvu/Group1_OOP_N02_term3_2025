public class TestApp {
    public static void main(String[] args) {

        WarehouseManager manager = new WarehouseManager();

        // Thêm sản phẩm
        manager.addProduct(new Product(1, "Laptop Dell", 10));
        manager.addProduct(new Product(2, "Chuột Logitech", 50));
        manager.addProduct(new Product(3, "Bàn phím cơ", 30));

        // Thêm kho
        manager.addWarehouse(new Warehouse(1, "Kho Hà Nội"));
        manager.addWarehouse(new Warehouse(2, "Kho Sài Gòn"));

        // Thêm nhà cung cấp
        manager.addSupplier(new Supplier(1, "Công ty ABC"));
        manager.addSupplier(new Supplier(2, "Công ty XYZ"));

        // Gán sản phẩm cho kho
        manager.assignProductToWarehouse(1, 1);
        manager.assignProductToWarehouse(2, 1);
        manager.assignProductToWarehouse(3, 2);

        // In danh sách
        System.out.println("Danh sách sản phẩm:");
        manager.printProducts();

        System.out.println("\nDanh sách kho:");
        manager.printWarehouses();

        System.out.println("\nDanh sách nhà cung cấp:");
        manager.printSuppliers();

        // Lưu dữ liệu
        DataIO.writeToFile("products.dat", manager.productList.getProducts());
        DataIO.writeToFile("warehouses.dat", manager.warehouseList.getWarehouses());
        DataIO.writeToFile("suppliers.dat", manager.supplierList.getSuppliers());

        // Đọc dữ liệu lại (ví dụ)
        var productsFromFile = DataIO.readFromFile("products.dat");
        var warehousesFromFile = DataIO.readFromFile("warehouses.dat");
        var suppliersFromFile = DataIO.readFromFile("suppliers.dat");

        System.out.println("\nĐọc dữ liệu từ file:");
        System.out.println("Products: " + productsFromFile);
        System
