package com.artyombash.domain.entity.teams;


import com.artyombash.domain.entity.links.LinksToTeam;

public class Team {

    private LinksToTeam links;
    private String name;
    private String code;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;

    public LinksToTeam getLinks() {
        return links;
    }

    public void setLinks(LinksToTeam links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Object getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public Object getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

}
