package com.gmail.androiddz.data.repository.datasource;


import android.util.Log;

import com.gmail.androiddz.data.cache.Cache;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UsersDataStoreFactory {

    private Cache cache;

    @Inject
    public UsersDataStoreFactory(Cache cache) {
        this.cache = cache;
    }

    public UsersDataStore create() {

        UsersDataStore usersDataStore;

        if (!cache.isThereInternetConnection() && !cache.isExpired()) {
            Log.e("create", "DiskUsersDataStore");
            usersDataStore = new DiskUsersDataStore(cache);
        } else {
            Log.e("create", "CloudUsersDataStore");
            usersDataStore = new CloudUsersDataStore(cache);
        }
        return usersDataStore;
    }

}
