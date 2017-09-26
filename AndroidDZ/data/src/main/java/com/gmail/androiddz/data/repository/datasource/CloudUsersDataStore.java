package com.gmail.androiddz.data.repository.datasource;


import com.gmail.androiddz.data.cache.Cache;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.net.RestService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

@Singleton
public class CloudUsersDataStore implements UsersDataStore {

    private final Cache cache;
    private final RestService restService;

    @Inject
    public CloudUsersDataStore(Cache cache, RestService restService) {
        this.cache = cache;
        this.restService = restService;
    }

    @Override
    public Observable<List<ProfileData>> userEntityList() {
        return restService.getProfiles()
                .doOnNext(new Consumer<List<ProfileData>>() {
            @Override
            public void accept(List<ProfileData> profileDatas) throws Exception {
                cache.put(profileDatas);
            }
        });
    }

}
