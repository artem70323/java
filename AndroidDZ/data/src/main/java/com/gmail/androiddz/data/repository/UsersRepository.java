package com.gmail.androiddz.data.repository;


import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;

import io.reactivex.Observable;

public interface UsersRepository {

    Observable<List<ProfileData>> getProfiles();
}
