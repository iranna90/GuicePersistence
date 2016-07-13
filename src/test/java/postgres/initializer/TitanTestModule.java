package postgres.initializer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapStore;

import hazelcast.HazelcastApi;
import hazelcast.HazelcastApiImpl;
import persist.PersistApi;
import persist.PersistImpl;
import postgres.Persist;
import provider.HazelcastProvider;

public class TitanTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HazelcastApi.class).to(HazelcastApiImpl.class);
        bind(PersistApi.class).to(PersistImpl.class);
        bind(HazelcastInstance.class).toProvider(HazelcastProvider.class).in(Singleton.class);
    }
}
