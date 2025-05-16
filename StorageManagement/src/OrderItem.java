public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public void displayItem() {
        System.out.printf("%s - SL: %d - Gia: %.2f - Tong: %.2f\n",
                product.getName(), quantity, product.getPrice(), getTotalPrice());
    }
}
