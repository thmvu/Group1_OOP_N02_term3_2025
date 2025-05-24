import java.io.*;
import java.util.*;

public class DataIO1 {
    public static void writeToFile(String filename, List<?> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<?> readFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}