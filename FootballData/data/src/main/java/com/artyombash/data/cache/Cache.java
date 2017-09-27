package com.artyombash.data.cache;

import com.artyombash.data.entity.fixtures.FixturesData;

import io.reactivex.Observable;

/**
 * An interface representing a Cache.
 */
public interface Cache {

    /**
     * Gets an {@link Observable} which will emit a {@link FixturesData}.
     *
     * @param fixturesId Fixtures id to retrieve data.
     */
    Observable<FixturesData> get(final int fixturesId);

    /**
     * Puts and element into the cache.
     *
     * @param fixturesData Element to insert in the cache.
     */
    void put(FixturesData fixturesData);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param fixturesId Fixtures id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final int fixturesId);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
