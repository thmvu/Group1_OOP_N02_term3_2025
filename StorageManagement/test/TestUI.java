public class TestUI {
    public static void testAll() {
        TestProduct.testProduct();
        TestUser.testUser();
        createUI().run();
        
    }

    public static CustomerProductConsoleUI createUI() {
        CustomerProductManager manager = new CustomerProductManager();
        return new CustomerProductConsoleUI(manager);
    }
}