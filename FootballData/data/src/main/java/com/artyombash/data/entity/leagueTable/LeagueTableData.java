package com.artyombash.data.entity.leagueTable;


import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueTableData {

    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("leagueCaption")
    private String leagueCaption;
    @SerializedName("matchday")
    private Integer matchday;
    @SerializedName("standing")
    private List<StandingData> standing = null;

    public LinksMainData getLinks() {
        return links;
    }

    public void setLinks(LinksMainData links) {
        this.links = links;
    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public List<StandingData> getStanding() {
        return standing;
    }

    public void setStanding(List<StandingData> standing) {
        this.standing = standing;
    }
}
