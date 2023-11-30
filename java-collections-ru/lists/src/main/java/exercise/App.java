package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String charSet, String word) {
        if (word.length() > charSet.length()) {
            return false;
        }
        List<Character> wordCharList = stringToArrayList(word);
        List<Character> charSetCharList = stringToArrayList(charSet);
        for (Character character: wordCharList) {
            if(charSetCharList.contains(character)) {
                charSetCharList.remove(character);
            } else {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Character> stringToArrayList(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for (char character: str.toLowerCase().toCharArray()) {
            charList.add(character);
        }
        return charList;
    }
}
//END
