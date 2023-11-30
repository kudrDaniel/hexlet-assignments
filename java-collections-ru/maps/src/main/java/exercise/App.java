package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence == null || sentence.trim().equals("")) {
            return wordsCount;
        }
        String[] wordsArray = sentence.trim().split(" ");
        for (String s : wordsArray) {
            if (wordsCount.containsKey(s)) {
                int newCount = wordsCount.get(s) + 1;
                wordsCount.put(s, newCount);
            } else {
                wordsCount.put(s, 1);
            }
        }
        return wordsCount;
    }
    public static String toString(Map mapToString) {
        String output;
        if (mapToString.isEmpty()) {
            output = "{";
        } else {
            output = "{\n";
            for (Object key : mapToString.keySet()) {
                output = output.concat(String.format(
                        "\s\s%s: %d\n",
                        key.toString(),
                        (Integer) mapToString.get(key)
                ));
            }
        }
        output = output.concat("}");
        return output;
    }
}
//END
