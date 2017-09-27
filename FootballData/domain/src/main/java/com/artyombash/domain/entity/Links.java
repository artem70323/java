package com.artyombash.domain.entity;

import com.artyombash.domain.entity.links.LinkToFixtures;
import com.artyombash.domain.entity.links.LinkToLeagueTable;
import com.artyombash.domain.entity.links.LinkToTeams;
import com.artyombash.domain.entity.links.LinkToSelf;

/**
 * Links to {@link LinkToSelf}, {@link LinkToTeams}, {@link LinkToFixtures} and {@link LinkToLeagueTable} of current
 * competition.
 */

public class Links {

    private LinkToSelf self;
    private LinkToTeams teams;
    private LinkToFixtures fixtures;
    private LinkToLeagueTable leagueTable;

    public LinkToSelf getSelf() {
        return self;
    }

    public void setSelf(LinkToSelf self) {
        this.self = self;
    }

    public LinkToTeams getTeams() {
        return teams;
    }

    public void setTeams(LinkToTeams teams) {
        this.teams = teams;
    }

    public LinkToFixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinkToFixtures fixtures) {
        this.fixtures = fixtures;
    }

    public LinkToLeagueTable getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(LinkToLeagueTable leagueTable) {
        this.leagueTable = leagueTable;
    }

}
