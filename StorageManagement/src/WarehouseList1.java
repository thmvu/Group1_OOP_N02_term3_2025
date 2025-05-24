import java.util.ArrayList;
import java.util.List;

public class WarehouseList1 {
    private List<Warehouse1> warehouses = new ArrayList<>();

    public void add(Warehouse1 w) { warehouses.add(w); }
    public List<Warehouse1> getWarehouses() { return warehouses; }
    public void print() {
        for (Warehouse1 w : warehouses) System.out.println(w);
    }
}