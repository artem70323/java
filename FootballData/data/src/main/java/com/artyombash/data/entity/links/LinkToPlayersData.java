package com.artyombash.data.entity.links;


import com.google.gson.annotations.SerializedName;

/**
 * Link to players.
 */
public class LinkToPlayersData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
