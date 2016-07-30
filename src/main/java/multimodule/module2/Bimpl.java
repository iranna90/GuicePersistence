package multimodule.module2;

import com.google.inject.Inject;
import jsonb.MyEntity;
import multimodule.A;

/**
 * Created by iranna.patil on 30-07-2016.
 */
public class Bimpl implements B {

    private final A a;

    @Inject
    public Bimpl(A a) {
        this.a = a;
    }

    @Override
    public void bImpleMethode(MyEntity entity) {
        System.out.println("Instance of " + this.getClass().getName());
        System.out.println("A value is " + this.a.getClass().getName());

        System.out.println("calling a method");
        a.check(entity);
        System.out.println("called successfully");
    }
}
