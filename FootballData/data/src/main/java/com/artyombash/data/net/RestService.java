package com.artyombash.data.net;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<List<CompetitionData>> getCompetitions() {
        return restApi.getCompetitions();
    }

    public Observable<TeamsData> getTeams(int id) {
        return restApi.getTeams(id);
    }

    public Observable<LeagueTableData> getLeagueTable(int id) {
        return restApi.getLeagueTable(id);
    }

    public Observable<FixturesData> getFixtures(int id) {
        return restApi.getFixtures(id);
    }

}
