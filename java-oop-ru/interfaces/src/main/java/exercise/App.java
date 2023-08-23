package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {

    }

    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        return homes.stream()
                .sorted(Home::compareTo)
                .limit(count)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
