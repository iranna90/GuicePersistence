package synchronize;

/**
 * Created by iranna.patil on 19-07-2016.
 */
public class ThreadLocal extends Abstract {

    public void threadLocalTest() {
        System.out.println("checking thead " + Thread.currentThread().getName() + " local value "
                + myThread.get());
    }
}
