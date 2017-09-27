package com.artyombash.domain.entity.links;


/**
 * Links to {@link LinkToSelf}, {@link LinkToFixtures} and {@link LinkToPlayers}.
 */

public class LinksToTeam {

    private LinkToSelf self;
    private LinkToFixtures fixtures;
    private LinkToPlayers players;

    public LinkToSelf getSelf() {
        return self;
    }

    public void setSelf(LinkToSelf self) {
        this.self = self;
    }

    public LinkToFixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinkToFixtures fixtures) {
        this.fixtures = fixtures;
    }

    public LinkToPlayers getPlayers() {
        return players;
    }

    public void setPlayers(LinkToPlayers players) {
        this.players = players;
    }

}
