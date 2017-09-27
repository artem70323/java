package com.artyombash.data.cache;

import com.artyombash.data.entity.fixtures.FixturesData;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link Cache} implementation.
 */
@Singleton
public class CacheImpl implements Cache {

    @Inject
    public CacheImpl() {
    }

    @Override
    public Observable<FixturesData> get(int fixturesId) {
        return null;
    }

    @Override
    public void put(FixturesData fixturesData) {

    }

    @Override
    public boolean isCached(int fixturesId) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }
}
