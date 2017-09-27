package com.artyombash.domain.entity.leagueTable;


import com.artyombash.domain.entity.links.LinksMain;

import java.util.List;

public class LeagueTable {

    private LinksMain links;
    private String leagueCaption;
    private Integer matchday;
    private List<Standing> standing = null;

    public LinksMain getLinks() {
        return links;
    }

    public void setLinks(LinksMain links) {
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

    public List<Standing> getStanding() {
        return standing;
    }

    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }
}
