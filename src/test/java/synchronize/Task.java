package synchronize;

import java.util.Collection;

/**
 * Created by iranna.patil on 17-07-2016.
 */
public class Task implements Runnable {

    int count = 0;

    synchronized public void increment1() throws InterruptedException {
        count += 1;
        Thread.sleep(1);
    }

   synchronized public void increment2() throws InterruptedException {
        count += 1;
        Thread.sleep(1);
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            process();
        }
        System.out.println("Count "+ count);
    }

    private void process() {
        try {
            increment1();
            increment2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
