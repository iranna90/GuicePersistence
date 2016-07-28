package synchronize;

import org.w3c.dom.ls.LSInput;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * Created by iranna.patil on 17-07-2016.
 */
public class Driver extends Abstract {
    int count1 = 0;
    int count2 = 0;
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Driver driver = new Driver();
        driver.dowork();
    }

    public void increment1() {
        synchronized (lock1) {
            waitForMilliSecond();
            count1 += 1;
        }
    }

    public void increment2() {
        synchronized (lock2) {
            waitForMilliSecond();
            count2 += 1;
        }
    }

    private void waitForMilliSecond() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dowork() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        System.out.println(LocalTime.now());
        IntStream.range(0, 10).forEach(i -> service.submit(() -> {
            myThread.set("how are you " + i);
            doSomeWork(i);
        }));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(LocalTime.now());
        System.out.println("count is " + count1);
        System.out.println("count is " + count2);
    }

    private void doSomeWork(int i) {
        try {
            Thread.sleep(1000);
            new ThreadLocal().threadLocalTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the thread is " + Thread.currentThread().getName() + " and work " + i);
    }

    private IntSupplier getIntValue(int n) {
        return () -> n;
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            increment1();
            increment2();
        }
    }
}
