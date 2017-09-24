package com.gmail.androiddz.data.repository;


import com.gmail.androiddz.data.entity.ProfileData;
import com.gmail.androiddz.data.repository.datasource.UsersDataStore;
import com.gmail.androiddz.data.repository.datasource.UsersDataStoreFactory;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class UsersDataRepository implements UsersRepository {

    private final UsersDataStoreFactory factory;

    @Inject
    public UsersDataRepository(UsersDataStoreFactory factory) {
        this.factory = factory;
    }

//    @Inject
//    public UsersDataRepository(Context context) {
//        this.context = context;
//        factory= new UsersDataStoreFactory(new Cache(context));
//    }

    @Override
    public Observable<List<ProfileData>> getProfiles() {
        UsersDataStore usersDataStore = factory.create();
        return usersDataStore.userEntityList();
    }

}
