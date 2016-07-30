package multimodule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import jsonb.MyEntity;
import jsonb.MyJson;
import multimodule.module2.B;

/**
 * Created by iranna.patil on 30-07-2016.
 */
public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "titan-unit-test-db";

    public static void main(String[] args) {
        System.out.println("started");
        // create JpaPersistModule with properties
        JpaPersistModule jpaPersistModule = new JpaPersistModule(PERSISTENCE_UNIT_NAME);
        // create the guice hierarchy
        Injector injector = Guice.createInjector(new Module1(), jpaPersistModule);
        //initialize the data base and run flyway scripts
        ApplicationDatabaseInitializer instance = injector.getInstance(ApplicationDatabaseInitializer.class);
        instance.start();
        MyJson j = new MyJson();
        j.setLongProp(123L);
        j.setStringProp("abc");
        A a = injector.getInstance(A.class);
        MyEntity e = new MyEntity();
        e.setJsonProperty(j);
        Injector injector1 = Guice.createInjector(new Module2(a));
        B b = injector1.getInstance(B.class);
        b.bImpleMethode(e);
        System.out.println("completed");
    }
}
