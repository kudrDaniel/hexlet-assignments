package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> bookList, Map<String, String> filterPairs) {
        List<Map<String, String >> bookFoundList = new ArrayList<>();
        for (Map<String, String> bookPairs: bookList) {
            boolean isBookFits = false;
            for (Entry<String, String> filterPair: filterPairs.entrySet()) {
                if (bookPairs.containsKey(filterPair.getKey())) {
                    if (bookPairs.get(filterPair.getKey()).equals(filterPair.getValue())) {
                        isBookFits = true;
                    } else {
                        isBookFits = false;
                        break;
                    }
                } else {
                    isBookFits = false;
                    break;
                }
            }
            if (isBookFits) {
                bookFoundList.add(bookPairs);
            }
        }
        return bookFoundList;
    }
}
//END
