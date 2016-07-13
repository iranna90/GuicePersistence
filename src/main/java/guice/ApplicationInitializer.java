package guice;

import org.flywaydb.core.Flyway;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class ApplicationInitializer {
	@Inject
	ApplicationInitializer(PersistService service) {
		service.start();
		// At this point JPA is started and ready.

		// other application initializations if necessary
		
		/*Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:postgresql://localhost:5432/Titan_DB","postgres","Jun@2016");
		*//*flyway.setDataSource("jdbc:h2:mem:test;MODE=PostgreSQL", "", "");*//*
		flyway.init();
		flyway.setLocations("db");
		flyway.migrate();*/
	}
}
