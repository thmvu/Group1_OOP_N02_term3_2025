package com.example.servingwebcontent.model;

import java.sql.Date;

public class Customer_Product {
    private Customer customer;
    private Product product;
    private Date date;

    public Customer_Product(Customer customer, Product product, Date date) {
        this.customer = customer;
        this.product = product;
        this.date = date;
    }

    public Customer getCustomer() { return customer; }
    public Product getProduct() { return product; }
    public Date getDate() { return date; }
    @Override
public String toString() {
    return "Customer ID: " + getCustomer().getUserID() + ", Product ID: " + getProduct().getProductId() + ", Date: " + getDate();
}

}
