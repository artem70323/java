package com.artyombash.data.net;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link CompetitionData}.
     */
    @GET("competitions")
    Observable<List<CompetitionData>> getCompetitions();

    /**
     * Retrieves an {@link Observable} which will emit a {@link TeamsData}.
     *
     * @param id The competition id used to get teams data.
     */
    @GET("competitions/{id}/teams")
    Observable<TeamsData> getTeams(@Path("id") int id);

    /**
     * Retrieves an {@link Observable} which will emit a {@link LeagueTableData}.
     *
     * @param id The competition id used to get league table.
     */
    @GET("competitions/{id}/leagueTable")
    Observable<LeagueTableData> getLeagueTable(@Path("id") int id);

    /**
     * Retrieves an {@link Observable} which will emit a {@link FixturesData}.
     *
     * @param id The competition id used to get fixtures.
     */
    @GET("competitions/{id}/fixtures")
    Observable<FixturesData> getFixtures(@Path("id") int id);

}
