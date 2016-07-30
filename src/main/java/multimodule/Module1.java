package multimodule;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.hazelcast.core.HazelcastInstance;
import multimodule.hazelcast.provider.HazelcastProvider;
import multimodule.modue1.AImpl;
import persist.PersistApi;
import persist.PersistImpl;


/**
 * Created by iranna.patil on 30-07-2016.
 */
public class Module1 extends AbstractModule {
    @Override
    protected void configure() {
        bind(A.class).to(AImpl.class);
        bind(PersistApi.class).to(PersistImpl.class);
        bind(HazelcastInstance.class).toProvider(HazelcastProvider.class).in(Singleton.class);
    }
}
