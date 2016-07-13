package provider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.*;
import postgres.Persist;

import java.util.Properties;

/**
 * Created by iranna on 13-7-16.
 */
public class HazelcastProvider implements Provider<HazelcastInstance> {

    @Inject
    Persist persist;

    public HazelcastInstance get() {
        System.out.println("calling hazelcast get method for the etity from provider");
        Config config = new Config();

        MapConfig mapCfg = new MapConfig();
        mapCfg.setName("employee");
        config.addMapConfig(mapCfg);

        MapStoreConfig mapStoreCfg = new MapStoreConfig();
        mapStoreCfg.setFactoryImplementation(new MapStoreFactory<Object, Object>() {
            public MapStore<Object, Object> newMapStore(String mapName,
                                                        Properties properties) {
                // TODO Auto-generated method stub
                return persist;
            }
        });
        mapCfg.setMapStoreConfig(mapStoreCfg);
        System.out.println("persistence "+persist);
        return Hazelcast.newHazelcastInstance(config);
    }
}
