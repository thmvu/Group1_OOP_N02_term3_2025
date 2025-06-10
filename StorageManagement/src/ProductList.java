import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductList {

    ArrayList<Product> pr = new ArrayList<Product>();

    public ArrayList<Product> addProduct(Product pro){

        pr.add(pro);
        return pr;

    }
    public ArrayList<Product> getEditProduct(int productId, String productName){
        for(int i =0; i < pr.size(); i++){

            if(pr.get(i).getProductId() == productId){
                System.out.print("true");
                pr.get(i).setProductName(productName);
            }
        }  
        return pr;  
    }
    // xoa san pham theo ID
    public ArrayList<Product> getDeleteProduct(int producId){
        for(int i = 0; i < pr.size(); i++){
            if(pr.get(i).getProductId() == producId){
                pr.remove(i);
            }
        }
        return pr;
    }
    public void printProductList(){
        for(Product p : pr){
            System.out.println("Product ID: " + p.getProductId() + ", Product Name: " + p.getProductName() + ", Product Price: " + p.getProductPrice());
        }
    }
    public Product getProductInfo(int productId){
        List<Product> filteredProducts = pr.stream()
                .filter(product -> product.getProductId() == productId)
                .collect(Collectors.toList());
        if (filteredProducts.isEmpty()) return null;
        return filteredProducts.get(0);
    }

}
