package com.artyombash.data.repository;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.data.entityMapper.CompetitionDataMapper;
import com.artyombash.data.entityMapper.TeamsDataMapper;
import com.artyombash.data.repository.datasource.DataStore;
import com.artyombash.data.repository.datasource.DataStoreFactory;
import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.entity.teams.Teams;
import com.artyombash.domain.entity.fixtures.Fixtures;
import com.artyombash.domain.entity.leagueTable.LeagueTable;
import com.artyombash.domain.repository.FootballRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * {@link FootballRepository} for retrieving football data.
 */
@Singleton
public class FootballDataRepository implements FootballRepository{

    private final DataStoreFactory dataStoreFactory;
    private final CompetitionDataMapper competitionDataMapper;
    private final TeamsDataMapper teamsDataMapper;

    /**
     * Constructs a {@link FootballRepository}.
     *  @param dataStoreFactory A factory to construct different data source implementations.
     * @param competitionDataMapper {@link CompetitionDataMapper}.
     * @param teamsDataMapper
     */
    @Inject
    public FootballDataRepository(DataStoreFactory dataStoreFactory,
                                  CompetitionDataMapper competitionDataMapper,
                                  TeamsDataMapper teamsDataMapper) {
        this.dataStoreFactory = dataStoreFactory;
        this.competitionDataMapper = competitionDataMapper;
        this.teamsDataMapper = teamsDataMapper;
    }

    @Override
    public Observable<List<Competition>> competitions() {
        //we always get all competitions from the cloud
        final DataStore dataStore = this.dataStoreFactory.getCloudDataStore();
        return dataStore.competitionDataList()
                .map(new Function<List<CompetitionData>, List<Competition>>() {
            @Override
            public List<Competition> apply(@NonNull List<CompetitionData> competitionDatas) throws Exception {
                return competitionDataMapper.transform(competitionDatas);
            }
        });
    }

    @Override
    public Observable<Teams> teams(int competitionId) {
        DataStore dataStore = this.dataStoreFactory.create(competitionId);
        return dataStore.teamsData(competitionId)
                .map(new Function<TeamsData, Teams>() {
                    @Override
                    public Teams apply(@NonNull TeamsData teamsData) throws Exception {
                        return teamsDataMapper.transform(teamsData);
                    }
                });
    }

    @Override
    public Observable<LeagueTable> leagueTable(int competitionId) {
        return null;
    }

    @Override
    public Observable<Fixtures> fixtures(int competitionId) {
        return null;
    }
}
