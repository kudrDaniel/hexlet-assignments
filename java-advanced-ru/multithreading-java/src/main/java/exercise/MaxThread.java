package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int maxNumber;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        maxNumber = result;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }
}
// END
