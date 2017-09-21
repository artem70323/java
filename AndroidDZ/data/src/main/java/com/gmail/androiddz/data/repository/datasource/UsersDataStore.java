package com.gmail.androiddz.data.repository.datasource;


import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;

import io.reactivex.Observable;

public interface UsersDataStore {

    Observable<List<ProfileData>> userEntityList();
}
