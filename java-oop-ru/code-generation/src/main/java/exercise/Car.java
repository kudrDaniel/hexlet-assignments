package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

import java.util.Map;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            json = mapper.writeValueAsString(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(json, Car.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }
    // END
}
