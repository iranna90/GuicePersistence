package multimodule.storage;

import com.google.inject.Inject;
import com.hazelcast.core.MapStore;
import jsonb.MyEntity;
import persist.PersistApi;

import java.util.Collection;
import java.util.Map;

/**
 * Created by iranna.patil on 30-07-2016.
 */
public class Storage implements MapStore<String, MyEntity> {

    private final PersistApi persistApi;

    @Inject
    public Storage(PersistApi persistApi) {
        this.persistApi = persistApi;
    }

    @Override
    public void store(String s, MyEntity myEntity) {
        persistApi.saveOrUpdate(myEntity);
    }

    @Override
    public void storeAll(Map<String, MyEntity> map) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void deleteAll(Collection<String> collection) {

    }

    @Override
    public MyEntity load(String s) {
        return null;
    }

    @Override
    public Map<String, MyEntity> loadAll(Collection<String> collection) {
        return null;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        return null;
    }
}
