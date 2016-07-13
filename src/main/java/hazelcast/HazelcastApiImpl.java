package hazelcast;

import com.google.inject.Inject;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import entity.Employee;

/**
 * Created by iranna on 13-7-16.
 */
public class HazelcastApiImpl implements HazelcastApi {

    @Inject
    HazelcastInstance hazelcastInstance;

    public void put(Employee employee) {
        hazelcastInstance.getMap("employee").put(employee.getName(), employee);
    }

}
