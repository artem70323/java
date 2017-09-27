package com.artyombash.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.artyombash.data.cache.Cache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link DataStore}.
 */
@Singleton
public class DataStoreFactory {

    private final Cache cache;
    private final CloudDataStore cloudDataStore;

    @Inject
    public DataStoreFactory(@NonNull Context context, @NonNull Cache cache,
                            CloudDataStore cloudDataStore) {
        this.cache = cache;
        this.cloudDataStore = cloudDataStore;
    }

    /**
     * Create {@link DataStore} from a competition id.
     */
    public DataStore create(int competitionId) {
        DataStore userDataStore;

        if (!this.cache.isExpired() && this.cache.isCached(competitionId)) {
            userDataStore = new DiskDataStore(this.cache);
        } else {
            userDataStore = getCloudDataStore();
        }

        return userDataStore;
    }

    public CloudDataStore getCloudDataStore() {
        return cloudDataStore;
    }

}
