package com.example.servingwebcontent.model;

public class InvoiceItem {
     private Invoice invoice;
    private Product product;
    private int quantity;
    private double unitPrice;

      public InvoiceItem(Invoice invoice, Product product, int quantity, double unitPrice) {
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Invoice getInvoice() { return invoice; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "Product: " + product.getProductId() + ", Quantity: " + quantity + ", Unit Price: " + unitPrice;
    }
    
}

