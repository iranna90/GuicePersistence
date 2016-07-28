package threadlocal;

/**
 * Created by iranna.patil on 19-07-2016.
 */
public class Service {

    public void check() {
        System.out.println("thread local value " + Local.getThreadLocal().get() + " for thread " + Thread.currentThread().getName());
    }
}
