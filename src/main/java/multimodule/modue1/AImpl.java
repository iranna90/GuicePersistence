package multimodule.modue1;

import com.google.inject.Inject;
import com.hazelcast.core.HazelcastInstance;
import jsonb.MyEntity;
import multimodule.A;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by iranna.patil on 30-07-2016.
 */
public class AImpl implements A {

    private final HazelcastInstance hazelcastInstance;

    private final AtomicLong atomicLong = new AtomicLong();

    @Inject
    public AImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public void check(MyEntity entity) {
        System.out.println("in checking");
        hazelcastInstance.getMap("json").put("iranna" + atomicLong.getAndIncrement(), entity);
    }
}
