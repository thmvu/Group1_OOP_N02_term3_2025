import java.util.ArrayList;

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
    public ArrayList<Product> getDeleteProduct(int producId){
        for(int i = 0; i < pr.size(); i++){
            if(pr.get(i).getProductId() == producId){
                pr.remove(i);
            }
        }
        return pr;
    }
    public void printProductList(){
        int len = pr.size();

        for(int i = 0; i < len; i++){
            System.out.println("Product ID: " + pr.get(i).getProductId() + " Product Name: " + pr.get(i).getProductName());
        }
    }

}
