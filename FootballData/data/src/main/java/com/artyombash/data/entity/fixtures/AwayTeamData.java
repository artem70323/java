package com.artyombash.data.entity.fixtures;


import com.google.gson.annotations.SerializedName;

/**
 * Link to AwayTeam.
 */
public class AwayTeamData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
