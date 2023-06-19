package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String config) {
        config = Arrays.stream(config.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replaceAll("environment=","").replaceAll("\"",""))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .filter(pair -> pair.startsWith("X_FORWARDED_"))
                .map(pair -> pair.replaceAll("X_FORWARDED_",""))
                .collect(Collectors.joining(","));
        return config;
    }
}
//END
