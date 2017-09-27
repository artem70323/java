package com.artyombash.data.repository.datasource;

import com.artyombash.data.cache.Cache;
import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;

import java.util.List;

import io.reactivex.Observable;

/**
 * {@link DataStore} implementation based on file system data store.
 */
public class DiskDataStore implements DataStore {

    private final Cache cache;

    /**
     * Construct a {@link DataStore} based file system data store.
     *
     * @param cache A {@link Cache} to cache data retrieved from the api.
     */
    DiskDataStore(Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<List<CompetitionData>> competitionDataList() {
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override
    public Observable<TeamsData> teamsData(int competitionId) {
        return null;
    }

    @Override
    public Observable<LeagueTableData> leagueTableData(int competitionId) {
        return null;
    }

    @Override
    public Observable<FixturesData> fixturesData(int competitionId) {
        return null;
    }
}
