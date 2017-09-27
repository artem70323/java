package com.artyombash.data.entity.teams;


import com.artyombash.data.entity.links.LinksToTeamData;
import com.google.gson.annotations.SerializedName;

public class TeamData {

    @SerializedName("_links")
    private LinksToTeamData links;
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("squadMarketValue")
    private String squadMarketValue;
    @SerializedName("crestUrl")
    private String crestUrl;

    public LinksToTeamData getLinks() {
        return links;
    }

    public void setLinks(LinksToTeamData links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

}
