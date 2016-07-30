package multimodule.hazelcast.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.*;
import jsonb.MyEntity;
import multimodule.storage.Storage;

import java.util.Properties;

/**
 * Created by iranna on 13-7-16.
 */
public class HazelcastProvider implements Provider<HazelcastInstance> {

    @Inject
    Storage storage;

    public HazelcastInstance get() {
        Config config = new Config();

        MapConfig mapCfg = new MapConfig();
        mapCfg.setName("json");
        config.addMapConfig(mapCfg);

        MapStoreConfig mapStoreCfg = new MapStoreConfig();
        mapStoreCfg.setFactoryImplementation(new MapStoreFactory<String, MyEntity>() {
            public MapLoader<String, MyEntity> newMapStore(String mapName,
                                                           Properties properties) {
                // TODO Auto-generated method stub
                return storage;
            }
        });
        mapCfg.setMapStoreConfig(mapStoreCfg);
        return Hazelcast.newHazelcastInstance(config);
    }
}
