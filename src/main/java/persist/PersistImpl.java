package persist;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by iranna on 13-7-16.
 */
public class PersistImpl implements PersistApi {

    @Inject
    Provider<EntityManager> entityManagerProvider;

    @Transactional
    public <T> T saveOrUpdate(T t) {
        return entityManagerProvider.get().merge(t);
    }

}
