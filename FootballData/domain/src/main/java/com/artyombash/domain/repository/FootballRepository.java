package com.artyombash.domain.repository;

import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.entity.teams.Teams;
import com.artyombash.domain.entity.fixtures.Fixtures;
import com.artyombash.domain.entity.leagueTable.LeagueTable;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting football related data.
 */

public interface FootballRepository {
    /**
     * Get an {@link Observable} which will emit a List of {@link Competition}.
     */
    Observable<List<Competition>> competitions();

    /**
     * Get an {@link Observable} which will emit a {@link Teams}.
     *
     * @param competitionId The competition id used to retrieve competition teams.
     */
    Observable<Teams> teams(int competitionId);

    /**
     * Get an {@link Observable} which will emit a {@link LeagueTable}.
     *
     * @param competitionId The competition id used to retrieve competition league table.
     */
    Observable<LeagueTable> leagueTable(int competitionId);

    /**
     * Get an {@link Observable} which will emit a {@link Fixtures}.
     *
     * @param competitionId The competition id used to retrieve competition fixtures.
     */
    Observable<Fixtures> fixtures(int competitionId);

}
