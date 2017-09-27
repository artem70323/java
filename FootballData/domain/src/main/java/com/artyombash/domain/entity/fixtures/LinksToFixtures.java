package com.artyombash.domain.entity.fixtures;


import com.artyombash.domain.entity.links.LinkToCompetition;
import com.artyombash.domain.entity.links.LinkToSelf;

public class LinksToFixtures {

    private LinkToSelf self;
    private LinkToCompetition competition;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;

    public LinkToSelf getSelf() {
        return self;
    }

    public void setSelf(LinkToSelf self) {
        this.self = self;
    }

    public LinkToCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(LinkToCompetition competition) {
        this.competition = competition;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

}
