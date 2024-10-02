class Counter {
    private final Object lock = new Object();
    private boolean countingDone = false;

    public void countUp() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }
        synchronized (lock) {
            countingDone = true;
            lock.notify(); // Notify the countdown thread
        }
    }

    public void countDown() {
        synchronized (lock) {
            while (!countingDone) {
                try {
                    lock.wait(); // Wait until counting up is done
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                }
            }
        }
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }
    }
}

public class ConcurrencyExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create threads for counting
        Thread countUpThread = new Thread(counter::countUp);
        Thread countDownThread = new Thread(counter::countDown);

        // Start counting up first
        countUpThread.start();
        // Start counting down
        countDownThread.start();

        // Wait for both threads to finish
        try {
            countUpThread.join();
            countDownThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt status
        }

        System.out.println("Counting completed.");
    }
}
