package com.artyombash.data.entityMapper;

import com.artyombash.data.entity.teams.TeamData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.domain.entity.teams.Team;
import com.artyombash.domain.entity.teams.Teams;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link TeamsData} (in the data layer) to {@link Teams}
 * in the domain layer.
 */
@Singleton
public class TeamsDataMapper {

    @Inject
    public TeamsDataMapper() {}

    /**
     * Transform a {@link TeamsData} into a {@link Teams}.
     *
     * @param teamsData Object to be transformed.
     * @return {@link Teams} if valid {@link TeamsData} otherwise null.
     */
    public Teams transform(TeamsData teamsData) {
        Teams teams = null;
        if (teamsData != null) {
            teams = new Teams();
            teams.setCount(teamsData.getCount());
            teams.setTeams(transformTeams(teamsData.getTeams()));
        }
        return teams;
    }

    private List<Team> transformTeams(List<TeamData> teamData) {
        List<Team> teams = null;
        if (teamData != null) {
            teams = new ArrayList<>();
            Team team;
            for (TeamData tData : teamData) {
                team = new Team();
                team.setName(tData.getName());
                team.setCode(tData.getCode());
                team.setShortName(tData.getShortName());
                team.setSquadMarketValue(tData.getSquadMarketValue());
                team.setCrestUrl(tData.getCrestUrl());
                teams.add(team);
            }
        }
        return teams;
    }

}
