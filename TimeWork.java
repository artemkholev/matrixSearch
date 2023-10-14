public class TimeWork {
    public static long measureTime(Runnable codeToMeasure) {
        long startTime = System.nanoTime();
        codeToMeasure.run();
        return (System.nanoTime() - startTime);
    }
}
