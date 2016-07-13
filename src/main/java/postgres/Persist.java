package postgres;

import com.google.inject.Inject;

import com.hazelcast.core.MapStore;

import java.util.Collection;
import java.util.Map;

import entity.Employee;
import persist.PersistApi;

/**
 * Created by iranna on 13-7-16.
 */
public class Persist<String,Employee> implements MapStore<String, Employee> {

    @Inject
    PersistApi persistApi;

    public void store(String s, Employee employee) {
        System.out.println("calling perisstence");
        persistApi.saveOrUpdate(employee);
    }

    public void storeAll(Map<String, Employee> map) {

    }

    public void delete(String s) {

    }

    public void deleteAll(Collection<String> collection) {

    }

    public Employee load(String s) {
        return null;
    }

    public Map<String, Employee> loadAll(Collection<String> collection) {
        return null;
    }

    public Iterable<String> loadAllKeys() {
        return null;
    }
}
