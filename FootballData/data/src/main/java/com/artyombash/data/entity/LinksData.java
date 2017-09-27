package com.artyombash.data.entity;

import com.artyombash.data.entity.links.LinkToFixturesData;
import com.artyombash.data.entity.links.LinkToLeagueTableData;
import com.artyombash.data.entity.links.LinkToTeamsData;
import com.artyombash.data.entity.links.LinkToSelfData;
import com.google.gson.annotations.SerializedName;

/**
 * Links to {@link LinkToSelfData}, {@link LinkToTeamsData}, {@link LinkToFixturesData} and {@link LinkToLeagueTableData} of current
 * competition.
 */

public class LinksData {

    @SerializedName("self")
    private LinkToSelfData self;
    @SerializedName("teams")
    private LinkToTeamsData teams;
    @SerializedName("fixtures")
    private LinkToFixturesData fixtures;
    @SerializedName("leagueTable")
    private LinkToLeagueTableData leagueTable;

    public LinkToSelfData getSelf() {
        return self;
    }

    public void setSelf(LinkToSelfData self) {
        this.self = self;
    }

    public LinkToTeamsData getTeams() {
        return teams;
    }

    public void setTeams(LinkToTeamsData teams) {
        this.teams = teams;
    }

    public LinkToFixturesData getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinkToFixturesData fixtures) {
        this.fixtures = fixtures;
    }

    public LinkToLeagueTableData getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(LinkToLeagueTableData leagueTable) {
        this.leagueTable = leagueTable;
    }

}
