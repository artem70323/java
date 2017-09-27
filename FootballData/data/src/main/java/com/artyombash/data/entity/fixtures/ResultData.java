package com.artyombash.data.entity.fixtures;


import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("goalsHomeTeam")
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    private Integer goalsAwayTeam;
    @SerializedName("halfTime")
    private HalfTimeData halfTime;

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public HalfTimeData getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(HalfTimeData halfTime) {
        this.halfTime = halfTime;
    }

}
