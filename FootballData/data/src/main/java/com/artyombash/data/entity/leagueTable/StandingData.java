package com.artyombash.data.entity.leagueTable;


import com.artyombash.data.entity.links.LinkToTeamData;
import com.google.gson.annotations.SerializedName;

/**
 * Show current standing.
 */

public class StandingData {

    @SerializedName("_links")
    private LinkToTeamData links;
    @SerializedName("position")
    private Integer position;
    @SerializedName("teamName")
    private String teamName;
    @SerializedName("crestURI")
    private String crestURI;
    @SerializedName("playedGames")
    private Integer playedGames;
    @SerializedName("points")
    private Integer points;
    @SerializedName("goals")
    private Integer goals;
    @SerializedName("goalsAgainst")
    private Integer goalsAgainst;
    @SerializedName("goalDifference")
    private Integer goalDifference;
    @SerializedName("wins")
    private Integer wins;
    @SerializedName("draws")
    private Integer draws;
    @SerializedName("losses")
    private Integer losses;
    @SerializedName("home")
    private HomeData home;
    @SerializedName("away")
    private AwayData away;

    public LinkToTeamData getLinks() {
        return links;
    }

    public void setLinks(LinkToTeamData links) {
        this.links = links;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Object getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public HomeData getHome() {
        return home;
    }

    public void setHome(HomeData home) {
        this.home = home;
    }

    public AwayData getAway() {
        return away;
    }

    public void setAway(AwayData away) {
        this.away = away;
    }

}
