package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var minThread = new MinThread(numbers);
        var maxThread = new MaxThread(numbers);

        LOGGER.info("Thread " + minThread.getName() + " started");
        minThread.start();
        LOGGER.info("Thread " + maxThread.getName() + " started");
        maxThread.start();

        try {
            minThread.join();
            LOGGER.info("Thread " + minThread.getName() + " finished");
            maxThread.join();
            LOGGER.info("Thread " + maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Map.of("min", minThread.getMinNumber(), "max", maxThread.getMaxNumber());
    }
    // END
}
