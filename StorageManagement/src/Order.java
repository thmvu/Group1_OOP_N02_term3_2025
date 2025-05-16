import java.util.*;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void displayOrder() {
        System.out.println("=== Chi tiet don hang ===");
        double total = 0;
        for (OrderItem item : items) {
            item.displayItem();
            total += item.getTotalPrice();
        }
        System.out.println("Tong cong: " + total);
    }
}
