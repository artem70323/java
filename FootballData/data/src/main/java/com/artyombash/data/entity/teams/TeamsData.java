package com.artyombash.data.entity.teams;

import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * List all teams for a certain competition.
 */

public class TeamsData {

    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("count")
    private int count;
    @SerializedName("teams")
    private List<TeamData> teams = null;

    public LinksMainData getLinks() {
        return links;
    }

    public void setLinks(LinksMainData links) {
        this.links = links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TeamData> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamData> teams) {
        this.teams = teams;
    }

}
