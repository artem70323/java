package com.gmail.androiddz.data.repository.datasource;


import com.gmail.androiddz.data.cache.Cache;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class CloudUsersDataStore implements UsersDataStore {

    private final Cache cache;

    public CloudUsersDataStore(Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<List<ProfileData>> userEntityList() {
        return RestService.getInstance().getProfiles()
                .doOnNext(new Consumer<List<ProfileData>>() {
            @Override
            public void accept(List<ProfileData> profileDatas) throws Exception {
                cache.put(profileDatas);
            }
        });
    }

}
