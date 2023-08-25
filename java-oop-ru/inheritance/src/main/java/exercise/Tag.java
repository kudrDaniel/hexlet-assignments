package exercise;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String name;
    private final Map<String, String> attributes = new LinkedHashMap<>();

    protected Tag(String name, Map<String, String> attributes) {
        this.name =  name;
        this.attributes.putAll(attributes);
    }

    protected String getName() {
        return this.name;
    }

    protected String attributesToString() {
        return attributes.entrySet().stream()
                .map(entry -> {
                    return " " + entry.getKey() + "=\"" + entry.getValue() + "\"";
                })
                .collect(Collectors.joining());
    }
}
// END
