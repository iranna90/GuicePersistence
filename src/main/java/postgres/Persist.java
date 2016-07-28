package postgres;

import com.google.inject.Inject;

import com.hazelcast.core.MapStore;

import java.util.Collection;
import java.util.Map;

import persist.PersistApi;
import entity.PersistEntity;
/**
 * Created by iranna on 13-7-16.
 */
public class Persist<String, PersistEntity> implements MapStore<String, PersistEntity> {

    @Inject
    PersistApi persistApi;

    public void store(String s, PersistEntity persistEntity) {
        System.out.println("calling perisstence");
        persistApi.saveOrUpdate(persistEntity);
    }

    public void storeAll(Map<String, PersistEntity> map) {

    }

    public void delete(String s) {

    }

    public void deleteAll(Collection<String> collection) {

    }

    public PersistEntity load(String s) {
        return null;
    }

    public Map<String, PersistEntity> loadAll(Collection<String> collection) {
        return null;
    }

    public Iterable<String> loadAllKeys() {
        return null;
    }
}
