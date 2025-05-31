import java.sql.Date;

public class Customer_Product{

//save record product và customer

ArrayList<Customer_Product> customerProduct = new ArrayList<Customer_Product>();

public String customerID;
public String productID;

public Date date;

public Customer_Product(){}


public ArrayList<Customer_Product> addCustomerProduct(Customer_Product cp){

    //save record product id với custormer id
      customerProduct.add(cp);
      return customerProduct;

}


public void reportCustomerProduct(){


    //dua ra san pham duco khach hang mua nhieu nhat
    //tuong tac tren list customerProduct

    //dem records bao nhieu dong du lieu cua cai product ID cu the
    //max


    //stream trong Class List de filter productID cu the  -> collection -->size collection
    
}

}