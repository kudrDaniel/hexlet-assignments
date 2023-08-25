package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            long square = Math.round(circle.getSquare());
            System.out.println(square);
        } catch (NegativeRadiusException negativeRadiusException) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }
}
// END
