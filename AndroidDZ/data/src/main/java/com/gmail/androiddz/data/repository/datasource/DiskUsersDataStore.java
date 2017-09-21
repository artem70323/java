package com.gmail.androiddz.data.repository.datasource;


import com.gmail.androiddz.data.cache.Cache;
import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;

import io.reactivex.Observable;

public class DiskUsersDataStore implements UsersDataStore {

    private final Cache cache;

    public DiskUsersDataStore(Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<List<ProfileData>> userEntityList() {
        List<ProfileData> list = cache.get();
        return Observable.just(list);
    }

}
