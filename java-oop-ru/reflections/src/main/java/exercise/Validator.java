package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public final class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        Arrays.stream(address.getClass().getDeclaredFields())
                .filter(field -> {
                    field.setAccessible(true);
                    try {
                        return field.get(address) == null;
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }
                    return false;

                })
                .forEach(field -> Arrays.stream(field.getDeclaredAnnotations())
                        .filter(annotation -> annotation.annotationType().equals(NotNull.class))
                        .forEach(annotation -> notValidFields.add(field.getName())));
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new LinkedHashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .peek(field -> field.setAccessible(true))
                .peek(field -> Arrays.stream(field.getDeclaredAnnotations())
                        .filter(annotation -> {
                            try {
                                return annotation.annotationType().equals(NotNull.class)
                                        && field.get(address) == null;
                            } catch (IllegalAccessException e) {
                                System.out.println(e.getMessage());
                            }
                            return false;
                        })
                        .forEach(annotation -> {
                            List<String> errors = new ArrayList<>();
                            errors.add("can not be null");
                            notValidFields.put(field.getName(), errors);
                        }))
                .peek(field -> field.setAccessible(true))
                .forEach(field -> Arrays.stream(field.getDeclaredAnnotations())
                        .filter(annotation -> {
                            try {
                                int length = getPossibleNullStringLength((String) field.get(address));
                                return annotation.annotationType().equals(MinLength.class)
                                        && length < ((MinLength) annotation).minLength();
                            } catch (IllegalAccessException e) {
                                System.out.println(e.getMessage());
                            }
                            return false;
                        })
                        .forEach(annotation -> {
                            List<String> errors = new ArrayList<>();
                            errors.add("length less than " + ((MinLength) annotation).minLength());
                            if (notValidFields.containsKey(field.getName())) {
                                notValidFields.get(field.getName()).addAll(errors);
                            } else {
                                notValidFields.put(field.getName(), errors);
                            }
                        }));
        return notValidFields;
    }

    private static int getPossibleNullStringLength(String string) {
        if (string != null) {
            return string.length();
        }
        return 0;
    }
}
// END
