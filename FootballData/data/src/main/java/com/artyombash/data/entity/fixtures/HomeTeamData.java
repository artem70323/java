package com.artyombash.data.entity.fixtures;

import com.google.gson.annotations.SerializedName;

/**
 * Link to HomeTeam.
 */
public class HomeTeamData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
