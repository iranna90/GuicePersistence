package thread;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by iranna.patil on 17-07-2016.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("started " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            System.out.println("starting " + i);
            executorService.submit(()-> {
                System.out.println("new thread " + Thread.currentThread().getName() + " id is ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("complete " + i);
        }
        System.out.println("now name is "+Thread.currentThread().getName());
        executorService.shutdown();
        System.out.println("now name is "+Thread.currentThread().getName());
        System.out.println("all task submitted");
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("complrtrdsd");
    }
}
