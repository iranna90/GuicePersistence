package multimodule;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class ApplicationDatabaseInitializer {

    private final PersistService persistService;

    @Inject
    public ApplicationDatabaseInitializer(PersistService service) {
        this.persistService = service;
    }

    public void start() {
        persistService.start();
    }
}
