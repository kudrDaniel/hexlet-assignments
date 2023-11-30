package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dict1, Map<String, Object> dict2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> added = new TreeSet<>(dict2.keySet());
        Set<String> deleted = new TreeSet<>(dict1.keySet());
        Set<String> same = new TreeSet<>(dict1.keySet());
        same.retainAll(dict2.keySet());
        Set<String> changed = new TreeSet<>(same);
        Set<String> unchanged = new TreeSet<>(same);

        added.removeAll(dict1.keySet());
        deleted.removeAll(dict2.keySet());

        changed = changed.stream()
                .filter(key -> !dict1.get(key).equals(dict2.get(key)))
                .collect(Collectors.toSet());
        unchanged = unchanged.stream()
                .filter(key -> dict1.get(key).equals(dict2.get(key)))
                .collect(Collectors.toSet());

        result.putAll(added.stream()
                .collect(
                        () -> new LinkedHashMap<>(),
                        (map, key) -> map.put(key, "added"),
                        (map1, map2) -> map1.putAll(map2)
                )
        );
        result.putAll(deleted.stream()
                .collect(
                        () -> new LinkedHashMap<>(),
                        (map, key) -> map.put(key, "deleted"),
                        (map1, map2) -> map1.putAll(map2)
                )
        );
        result.putAll(changed.stream()
                .collect(
                        () -> new LinkedHashMap<>(),
                        (map, key) -> map.put(key, "changed"),
                        (map1, map2) -> map1.putAll(map2)
                )
        );
        result.putAll(unchanged.stream()
                .collect(
                        () -> new LinkedHashMap<>(),
                        (map, key) -> map.put(key, "unchanged"),
                        (map1, map2) -> map1.putAll(map2)
                )
        );

        return result;
    }
}
//END
