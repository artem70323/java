package com.artyombash.domain.entity.fixtures;

public class Fixture {

    private LinksToFixtures links;
    private String date;
    private String status;
    private Integer matchday;
    private String homeTeamName;
    private String awayTeamName;
    private Result result;
    private Object odds;

    public LinksToFixtures getLinks() {
        return links;
    }

    public void setLinks(LinksToFixtures links) {
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Object getOdds() {
        return odds;
    }

    public void setOdds(Object odds) {
        this.odds = odds;
    }

}
