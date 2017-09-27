package com.artyombash.data.entity.fixtures;

import com.artyombash.data.entity.links.LinkToCompetitionData;
import com.artyombash.data.entity.links.LinkToSelfData;
import com.google.gson.annotations.SerializedName;

public class LinksToFixturesData {

    @SerializedName("self")
    private LinkToSelfData self;
    @SerializedName("competition")
    private LinkToCompetitionData competition;
    @SerializedName("homeTeam")
    private HomeTeamData homeTeam;
    @SerializedName("awayTeam")
    private AwayTeamData awayTeam;

    public LinkToSelfData getSelf() {
        return self;
    }

    public void setSelf(LinkToSelfData self) {
        this.self = self;
    }

    public LinkToCompetitionData getCompetition() {
        return competition;
    }

    public void setCompetition(LinkToCompetitionData competition) {
        this.competition = competition;
    }

    public HomeTeamData getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeamData homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeamData getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeamData awayTeam) {
        this.awayTeam = awayTeam;
    }

}
