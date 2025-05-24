import java.util.ArrayList;

public class ProductList {

    ArrayList<Product> products = new ArrayList<>();

    // Thêm sản phẩm, trả về danh sách
    public ArrayList<Product> addProduct(Product p) {
        products.add(p);
        return products;
    }

    // Sửa sản phẩm theo productId, trả về danh sách
    public ArrayList<Product> getEditProduct(int productId, String newName, int newQuantity) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId == productId) {
                System.out.print("true\n");  // báo đã tìm thấy sản phẩm để sửa
                products.get(i).productName = newName;
                products.get(i).quantity = newQuantity;
            }
        }
        return products;
    }

    // Xóa sản phẩm theo productId, trả về danh sách
    public ArrayList<Product> getDeleteProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId == productId) {
                products.remove(i);
                break; // xóa rồi dừng vòng lặp để tránh lỗi
            }
        }
        return products;
    }

    // In danh sách sản phẩm
    public void printProductList() {
        int len = products.size();
        for (int i = 0; i < len; i++) {
            System.out.println("Product ID: " + products.get(i).productId +
                               ", Name: " + products.get(i).productName +
                               ", Quantity: " + products.get(i).quantity);
        }
    }
}
