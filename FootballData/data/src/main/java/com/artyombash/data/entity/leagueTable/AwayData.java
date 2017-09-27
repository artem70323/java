package com.artyombash.data.entity.leagueTable;


import com.google.gson.annotations.SerializedName;

public class AwayData {

    @SerializedName("goals")
    private Integer goals;
    @SerializedName("goalsAgainst")
    private Integer goalsAgainst;
    @SerializedName("wins")
    private Integer wins;
    @SerializedName("draws")
    private Integer draws;
    @SerializedName("losses")
    private Integer losses;

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

}
