import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvPrinter {

    public static void writeUsersToCsv(List<User> users, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Write CSV header
            writer.append("UserId,Name,Gender,BirthDate,PhoneNumber,Email,Address,UserType\n");
            for (User user : users) {
                writer.append(user.getUserId()).append(",");
                writer.append(user.getName()).append(",");
                writer.append(user.getGender()).append(",");
                writer.append(user.getBirthDate()).append(",");
                writer.append(user.getPhoneNumber()).append(",");
                writer.append(user.getEmail()).append(",");
                writer.append(user.getAddress()).append(",");
                writer.append(user.getUserType()).append("\n");
            }
            System.out.println("CSV file '" + filename + "' has been created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}

