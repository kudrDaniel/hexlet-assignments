package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] input) {
        String[][] output = {};
        if (input == null) {
            return null;
        } else if (input.length == 0) {
            return output;
        }
        output = new String[input.length * 2][input[0].length * 2];
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                output[row * 2][col * 2] = input[row][col];
                output[row * 2 + 1][col * 2] = input[row][col];
                output[row * 2][col * 2 + 1] = input[row][col];
                output[row * 2 + 1][col * 2 + 1] = input[row][col];
            }
        }
        return output;
//        return Arrays.stream(input)
//                .flatMap(row -> Arrays.stream(row))
//                .flatMap(cell -> {
//                    String[][] newCell = {{cell, cell}, {cell, cell}};
//                    return Arrays.stream(newCell)
//                            .flatMap(row -> Arrays.stream(row));
//                })
//                .toArray(size -> new String[size]);
    }
}
// END
