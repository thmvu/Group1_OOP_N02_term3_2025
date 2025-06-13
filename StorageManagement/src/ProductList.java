import java.util.ArrayList;
public class ProductList {
    private static ProductList instance;
    private ArrayList<Product> productList;

    // Constructor riêng tư để đảm bảo Singleton
    private ProductList() {
        productList = new ArrayList<>();
    }

    // Trả về instance duy nhất
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
        }
        return instance;
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Lấy danh sách sản phẩm
    public ArrayList<Product> getProductList() {
        return productList;
    }

    // Sửa tên sản phẩm theo productId
    public boolean editProductName(int productId, String newName) {
        for (Product p : productList) {
            if (p.getProductId() == productId) {
                p.setProductName(newName);
                return true;
            }
        }
        return false;
    }

    // Xóa sản phẩm theo ID
    public boolean deleteProduct(int productId) {
        return productList.removeIf(p -> p.getProductId() == productId);
    }

    // Hiển thị tất cả sản phẩm
    public void printProductList() {
        if (productList.isEmpty()) {
            System.out.println("Khong co san pham nao trong danh sach.");
            return;
        }
        for (Product p : productList) {
            p.displayProductInfo();
            System.out.println("---------------------------");
        }
    }

    // Lấy thông tin 1 sản phẩm theo ID
    public Product getProductInfo(int productId) {
        for (Product p : productList) {
            if (p.getProductId() == productId) return p;
        }
        return null;
    }

    // Kiểm tra sản phẩm có tồn tại
    public boolean isProductExist(int productId) {
        return productList.stream().anyMatch(p -> p.getProductId() == productId);
    }
}
