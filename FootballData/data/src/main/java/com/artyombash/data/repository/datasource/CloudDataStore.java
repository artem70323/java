package com.artyombash.data.repository.datasource;

import com.artyombash.data.cache.Cache;
import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.data.net.RestApi;
import com.artyombash.data.net.RestService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link DataStore} implementation based on connections to the api (Cloud).
 */
@Singleton
public class CloudDataStore implements DataStore{

    private final RestService restService;
    private final Cache cache;

    /**
     * Construct a {@link DataStore} based on connections to the api (Cloud).
     *
     * @param restService The {@link RestApi} implementation to use.
     * @param cache A {@link Cache} to cache data retrieved from the api.
     */
    @Inject
    CloudDataStore(RestService restService, Cache cache) {
        this.restService = restService;
        this.cache = cache;
    }

    @Override
    public Observable<List<CompetitionData>> competitionDataList() {
        return restService.getCompetitions();
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
