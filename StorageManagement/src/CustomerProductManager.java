import java.util.*;

public class CustomerProductManager {
    private List<Customer_Product> customerProductList = new ArrayList<>();

    public void add(Customer_Product cp) {
        customerProductList.add(cp);
        System.out.println("Da them giao dich thanh cong.");
    }

    public void delete(int index) {
        if (index >= 0 && index < customerProductList.size()) {
            customerProductList.remove(index);
            System.out.println("Da xoa giao dich tai vi tri " + index);
        } else {
            System.out.println("Vi tri khong hop le.");
        }
    }

    public void update(int index, Customer_Product newCP) {
        if (index >= 0 && index < customerProductList.size()) {
            customerProductList.set(index, newCP);
            System.out.println("Da cap nhat giao dich tai vi tri " + index);
        } else {
            System.out.println("Vi tri khong hop le.");
        }
    }

    public void showAll() {
        System.out.println("=== Danh sach giao dich ===");
        for (int i = 0; i < customerProductList.size(); i++) {
            Customer_Product cp = customerProductList.get(i);
            System.out.println(i + ": Customer: " + cp.getCustomer().getUserID() +
                    ", Product: " + cp.getProduct().getProductId() +
                    ", Date: " + cp.getDate());
        }
    }

    public void reportMostPopularProduct() {
        if (customerProductList.isEmpty()) {
            System.out.println("Chua co giao dich nao.");
            return;
        }
        Map<Integer, Integer> productCount = new HashMap<>();
        for (Customer_Product cp : customerProductList) {
            int pid = cp.getProduct().getProductId();
            productCount.put(pid, productCount.getOrDefault(pid, 0) + 1);
        }
        int max = Collections.max(productCount.values());
        System.out.println("=== San pham duoc mua nhieu nhat ===");
        for (Map.Entry<Integer, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("Product ID: " + entry.getKey() + " | So luot mua: " + entry.getValue());
            }
        }
    }

    public List<Customer_Product> getCustomerProductList() {
        return customerProductList;
    }
}
