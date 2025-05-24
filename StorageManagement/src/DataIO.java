import java.io.*;
import java.util.ArrayList;

public class DataIO {

    public static <T> void writeToFile(String filename, ArrayList<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("Ghi file thành công: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> readFromFile(String filename) {
        ArrayList<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<T>) ois.readObject();
            System.out.println("Đọc file thành công: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
