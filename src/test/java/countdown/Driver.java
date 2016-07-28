package countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by iranna.patil on 17-07-2016.
 */
public class Driver {

    int count = 0;

    CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        //start processing once 2 threads work is done

        Driver driver = new Driver();
        driver.startProcessing();
    }

    public void startProcessing() throws InterruptedException {
        System.out.println("starting processing");

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                process();
                countDownLatch.countDown();
            });
        }
        service.shutdown();
        Thread.getAllStackTraces().keySet().stream().filter(thread -> thread.isAlive()).forEach(thread -> System.out.println(thread.getName()));
        System.out.println("active threads here is " + Thread.activeCount());
        //when 2 thread process completed then it will start processing next
        System.out.println("count before " + count);
        countDownLatch.await(1, TimeUnit.HOURS);
        System.out.println("count after " + count);
        System.out.println("active threads here after processing is " + Thread.activeCount());
        service.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("active threads here after processing is " + Thread.activeCount());
        Thread.getAllStackTraces().keySet().stream().filter(thread -> thread.isAlive()).forEach(thread -> System.out.println(thread.getName()));
    }

    public void process() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }
}
