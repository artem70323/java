package com.gmail.androiddz.data.repository;


import android.content.Context;

import com.gmail.androiddz.data.cache.Cache;
import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.repository.datasource.UsersDataStore;
import com.gmail.androiddz.data.repository.datasource.UsersDataStoreFactory;

import java.util.List;

import io.reactivex.Observable;

public class UsersDataRepository implements UsersRepository {

    private Context context;
    private final UsersDataStoreFactory factory;

    public UsersDataRepository(Context context) {
        this.context = context;
        factory= new UsersDataStoreFactory(new Cache(context));
    }

    @Override
    public Observable<List<ProfileData>> getProfiles() {
        UsersDataStore usersDataStore = factory.create();
        return usersDataStore.userEntityList();
    }

}
