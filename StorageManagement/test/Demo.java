import java.util.*;
import java.util.stream.*;

public class Demo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("An", "Bao", "Lan");
        List<String> filtered = names.stream()
                                     .filter(name -> name.startsWith("A"))
                                     .collect(Collectors.toList());

        System.out.println("Names starting with A: " + filtered);
    }
}