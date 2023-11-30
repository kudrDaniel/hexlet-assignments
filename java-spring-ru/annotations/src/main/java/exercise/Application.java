package exercise;

import exercise.annotation.Inspect;
import exercise.model.Address;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (var method : address.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var name = method.getName();
                var type = method.getReturnType().getSimpleName();
                System.out.format("Method %s returns a value of type %s\n", name, type);
            }
        }
        // END
    }
}
