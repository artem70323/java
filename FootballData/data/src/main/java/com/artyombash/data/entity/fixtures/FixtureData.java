package com.artyombash.data.entity.fixtures;


import com.google.gson.annotations.SerializedName;

/**
 * The Fixture resource reflects a scheduled football game. A fixture typically belongs to a
 * competition and is played on a certain matchday. Fixture appears as Main Resource and as
 * Subresource of a Competition.
 */
public class FixtureData {

    @SerializedName("_links")
    private LinksToFixturesData links;
    @SerializedName("date")
    private String date;
    @SerializedName("status")
    private String status;
    @SerializedName("matchday")
    private Integer matchday;
    @SerializedName("homeTeamName")
    private String homeTeamName;
    @SerializedName("awayTeamName")
    private String awayTeamName;
    @SerializedName("result")
    private ResultData result;
    @SerializedName("odds")
    private Object odds;

    public LinksToFixturesData getLinks() {
        return links;
    }

    public void setLinks(LinksToFixturesData links) {
        this.links = links;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public ResultData getResult() {
        return result;
    }

    public void setResult(ResultData result) {
        this.result = result;
    }

    public Object getOdds() {
        return odds;
    }

    public void setOdds(Object odds) {
        this.odds = odds;
    }

}
