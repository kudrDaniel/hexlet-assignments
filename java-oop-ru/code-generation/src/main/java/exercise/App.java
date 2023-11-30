package exercise;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) {
        String json = car.serialize();
        filePath = filePath.toAbsolutePath().normalize();
        try {
            Files.writeString(filePath, json, StandardOpenOption.WRITE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path filePath) {
        String json = "{}";
        filePath = filePath.toAbsolutePath().normalize();
        try {
            json = Files.readString(filePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Car.unserialize(json);
    }
}
// END
