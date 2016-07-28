package threadlocal;

/**
 * Created by iranna.patil on 19-07-2016.
 */
public class Local {

    private static final ThreadLocal<String> name = new ThreadLocal<String>();

    public static ThreadLocal<String> getThreadLocal() {
        return name;
    }
}
