package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));

        assertThat(App.take(numbers, 3))
                .isEqualTo(new ArrayList<>(List.of(1, 2, 3)));
        assertThat(App.take(new ArrayList<>(), 0))
                .isEqualTo(new ArrayList<>());
        assertThat(App.take(numbers, 10))
                .isEqualTo(numbers);
        assertThat(App.take(numbers, 11))
                .isEqualTo(numbers);
        // END
    }
}
