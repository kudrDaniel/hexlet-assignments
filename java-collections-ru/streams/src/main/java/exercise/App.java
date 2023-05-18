package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static final String[] FREE_DOMAINS = {
            "@gmail.com",
            "@yandex.ru",
            "@hotmail.com"
    };
    public static Integer getCountOfFreeEmails(List<String> emailList) {
        return (int) emailList.stream()
                .filter(
                        email -> Arrays.asList(FREE_DOMAINS)
                                .contains(
                                        email.substring(email.indexOf("@"))
                                )
                )
                .count();
    }
}
// END
