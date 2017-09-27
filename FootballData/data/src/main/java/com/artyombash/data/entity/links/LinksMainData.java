package com.artyombash.data.entity.links;


import com.google.gson.annotations.SerializedName;

/**
 * Links to {@link LinkToSelfData} and {@link LinkToCompetitionData}.
 */

public class LinksMainData {

    @SerializedName("self")
    private LinkToSelfData self;
    @SerializedName("competition")
    private LinkToCompetitionData competition;

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

}
