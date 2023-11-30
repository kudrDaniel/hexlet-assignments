package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public final class FileKV implements KeyValueStorage {
    private Map<String, String> map;

    private String path;

    public FileKV(String path, Map<String, String> map) {
        String content = "";
        this.map = new HashMap<>(map);
        this.path = path;
        try {
            content = Utils.readFile(this.path);
        } catch (Exception readFileException) {
            System.out.println(readFileException.getMessage());
        }
        try {
            Map<String, String> unserializedMap = Utils.unserialize(content);
            this.map.putAll(unserializedMap);
        } catch (Exception unserializeException) {
            System.out.println(unserializeException.getMessage());
        }
    }

    @Override
    public void set(String key, String value) {
        this.map.put(key, value);
        this.updateFile();
    }

    @Override
    public void unset(String key) {
        this.map.remove(key);
        this.updateFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.map);
    }

    private void updateFile() {
        String content = Utils.serialize(this.map);
        Utils.writeFile(this.path, content);
    }
}
// END
