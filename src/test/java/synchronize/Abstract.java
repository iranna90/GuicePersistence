package synchronize;

import java.lang.*;
import java.lang.ThreadLocal;

/**
 * Created by iranna.patil on 19-07-2016.
 */
public abstract class Abstract {

    protected final ThreadLocal myThread = new ThreadLocal();
}
