package com.artyombash.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * The list representation of this resource is the de-facto entry point to the API and by default
 * returns all available competitions for the current season.
 */

public class CompetitionData {

    @SerializedName("id")
    private int id;
    @SerializedName("_links")
    private LinksData links;
    @SerializedName("caption")
    private String caption;
    @SerializedName("league")
    private String league;
    @SerializedName("year")
    private String year;
    @SerializedName("currentMatchday")
    private int currentMatchday;
    @SerializedName("numberOfMatchdays")
    private int numberOfMatchdays;
    @SerializedName("numberOfTeams")
    private int numberOfTeams;
    @SerializedName("numberOfGames")
    private int numberOfGames;
    @SerializedName("lastUpdated")
    private String lastUpdated;

    public LinksData getLinks() {
        return links;
    }

    public void setLinks(LinksData links) {
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(int numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
