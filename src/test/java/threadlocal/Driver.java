package threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by iranna.patil on 19-07-2016.
 */
public class Driver {

    private int count = 0;

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.processing();
    }

    private void processing() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {

            executorService.submit(() -> {
                count++;
                Local.getThreadLocal().set("iranna" + count);
                System.out.println("Thread name in starting " + Thread.currentThread().getName());
                new Service().check();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
