import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHelper {
    public static void saveProductsToCSV(List<Product> products, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("ID,Name,Category,Quantity,Price\n");
            for (Product p : products) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Da luu vao file " + fileName);
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
