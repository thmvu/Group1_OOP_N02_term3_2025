import java.util.ArrayList;
import java.util.List;

public class SupplierList1 {
    private List<Supplier1> suppliers = new ArrayList<>();

    public void add(Supplier1 s) { suppliers.add(s); }
    public List<Supplier1> getSuppliers() { return suppliers; }
    public void print() {
        for (Supplier1 s : suppliers) System.out.println(s);
    }
}