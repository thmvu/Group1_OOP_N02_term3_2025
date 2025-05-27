import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void printProductList() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void getEditProduct(int id, String newName, int newQty, double newPrice, String newOrigin, String newColorType) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setQuantity(newQty);
                p.setPrice(newPrice);
                p.setOrigin(newOrigin);
                p.setColorType(newColorType);
                System.out.println("Đã sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID: " + id);
    }

    public void getDeleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
