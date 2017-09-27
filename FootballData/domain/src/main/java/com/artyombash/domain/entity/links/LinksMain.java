package com.artyombash.domain.entity.links;



/**
 * Links to {@link LinkToSelf} and {@link LinkToCompetition}.
 */

public class LinksMain {

    private LinkToSelf self;
    private LinkToCompetition competition;

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

}
