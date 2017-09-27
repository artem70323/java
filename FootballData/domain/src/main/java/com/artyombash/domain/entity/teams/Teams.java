package com.artyombash.domain.entity.teams;


import com.artyombash.domain.entity.links.LinksMain;

import java.util.List;

/**
 * List all teams for a certain competition.
 */

public class Teams {

    private LinksMain links;
    private int count;
    private List<Team> teams = null;

    public LinksMain getLinks() {
        return links;
    }

    public void setLinks(LinksMain links) {
        this.links = links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
