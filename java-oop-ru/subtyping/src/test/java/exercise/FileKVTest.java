package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void inMemoryKVTest() {
        KeyValueStorage storage0 = new FileKV(filepath.toString(), Map.of("key", "10"));
        assertThat(storage0.get("key2", "default")).isEqualTo("default");
        assertThat(storage0.get("key", "default")).isEqualTo("10");

        storage0.set("key2", "value2");
        storage0.set("key", "value");
        KeyValueStorage storage1 = new FileKV(filepath.toString(), Map.of());

        assertThat(storage1.get("key2", "default")).isEqualTo("value2");
        assertThat(storage1.get("key", "default")).isEqualTo("value");

        storage1.unset("key");
        assertThat(storage1.get("key", "def")).isEqualTo("def");
        assertThat(storage1.toMap()).isEqualTo(Map.of("key2", "value2"));
    }
    // END
}
