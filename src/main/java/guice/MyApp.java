package guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MyApp {

    private final IsomeDao dao;

    @Inject
    public MyApp(IsomeDao dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyAppModule(),
                new JpaPersistModule("myapp-db"));
        injector.getInstance(ApplicationInitializer.class);
        MyApp app = injector.getInstance(MyApp.class);
        MyEntity entity = new MyEntity();
        entity.setName("irannanewmn");
        Address address = app.dao.find("Bangalore", Address.class, "address");
        System.out.println("retrwived address is " + address.getAddress());
        if (address == null)
            throw new RuntimeException("");
        entity.setAddress(address);
        app.dao.save(entity);
        System.out.println("entity saved first");
        MyEntity entity2 = app.dao.find("irannanew", MyEntity.class, "name");
        System.out.println(entity2.getAddress() + " " + entity2.toString());

    }

}
