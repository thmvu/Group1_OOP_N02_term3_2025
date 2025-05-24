import java.util.ArrayList;

public class SupplierList {
    private ArrayList<Supplier> suppliers = new ArrayList<>();

    public ArrayList<Supplier> addSupplier(Supplier s) {
        suppliers.add(s);
        return suppliers;
    }

    public ArrayList<Supplier> editSupplier(int supplierId, String newName) {
        for (Supplier s : suppliers) {
            if (s.supplierId == supplierId) {
                s.supplierName = newName;
            }
        }
        return suppliers;
    }

    public ArrayList<Supplier> deleteSupplier(int supplierId) {
        suppliers.removeIf(s -> s.supplierId == supplierId);
        return suppliers;
    }

    public void printSupplierList() {
        for (Supplier s : suppliers) {
            System.out.println("Supplier ID: " + s.supplierId + ", Name: " + s.supplierName);
        }
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
