import java.util.ArrayList;
import java.util.List;

public class ProductList1 {
    private List<Product1> products = new ArrayList<>();

    public void add(Product1 p) { products.add(p); }
    public List<Product1> getProducts() { return products; }
    public void print() {
        for (Product1 p : products) System.out.println(p);
    }
}