import java.io.Serializable;

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    public int supplierId;
    public String supplierName;

    public Supplier(int supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "Supplier[id=" + supplierId + ", name=" + supplierName + "]";
    }
}
