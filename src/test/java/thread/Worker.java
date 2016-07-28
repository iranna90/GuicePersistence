package thread;

/**
 * Created by iranna.patil on 17-07-2016.
 */
public class Worker implements Runnable {
    private final int id;

    public Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("new thread " + Thread.currentThread().getName() + " id is " + id);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
