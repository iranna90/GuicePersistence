import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;

import entity.Employee;
import hazelcast.HazelcastApi;
import postgres.initializer.ApplicationDatabaseInitializer;
import postgres.initializer.TitanTestModule;

/**
 * Created by iranna on 13-7-16.
 */
public class TestClass {

    private static final String PERSISTENCE_UNIT_NAME = "titan-unit-test-db";

    Injector injector;

    @BeforeClass
    public void setup() {
        // create JpaPersistModule with properties
        JpaPersistModule jpaPersistModule = new JpaPersistModule(PERSISTENCE_UNIT_NAME);
        // create the guice hierarchy
        injector = Guice.createInjector(new TitanTestModule(), jpaPersistModule);
        //initialize the data base and run flyway scripts
        ApplicationDatabaseInitializer instance = injector.getInstance(ApplicationDatabaseInitializer.class);
        instance.start();
    }

    @Test
    public void check() {
        Employee employee = new Employee();
        employee.setName("iranna");
        HazelcastApi api = injector.getInstance(HazelcastApi.class);
        System.out.println("putting into hazelcast");
        api.put(employee);
        api.put(employee);
    }
}
