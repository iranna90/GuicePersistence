package multimodule;

import com.google.inject.AbstractModule;
import multimodule.module2.B;
import multimodule.module2.Bimpl;

/**
 * Created by iranna.patil on 30-07-2016.
 */
public class Module2 extends AbstractModule {

    private final A a;

    public Module2(A a) {
        this.a = a;
    }

    @Override
    protected void configure() {
        bind(B.class).to(Bimpl.class);
        bind(A.class).toInstance(a);
    }
}
