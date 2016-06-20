package guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MyApp {

	private final IsomeDao dao;
	
	@Inject
	public MyApp(IsomeDao dao){
		this.dao = dao; 
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MyAppModule(), 
                new JpaPersistModule("myapp-db"));
		injector.getInstance(ApplicationInitializer.class);
		MyApp app = injector.getInstance(MyApp.class);
		MyEntity entity = new MyEntity(5, "Iranna",32,"Bangalore",1200);
		app.dao.save(entity);
	}

}
