package com.artyombash.data.repository.datasource;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface DataStore {

    /**
     * Get an {@link Observable} which will emit a List of {@link CompetitionData}.
     */
    Observable<List<CompetitionData>> competitionDataList();

    /**
     * Get an {@link Observable} which will emit a {@link TeamsData}.
     *
     * @param competitionId The competition id used to retrieve competition teams.
     */
    Observable<TeamsData> teamsData(final int competitionId);

    /**
     * Get an {@link Observable} which will emit a {@link LeagueTableData}.
     *
     * @param competitionId The competition id used to retrieve competition teams.
     */
    Observable<LeagueTableData> leagueTableData(final int competitionId);

    /**
     * Get an {@link Observable} which will emit a {@link FixturesData}.
     *
     * @param competitionId The competition id used to retrieve competition teams.
     */
    Observable<FixturesData> fixturesData(final int competitionId);
}
