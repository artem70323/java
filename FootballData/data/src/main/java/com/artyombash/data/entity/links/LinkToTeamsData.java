package com.artyombash.data.entity.links;

import com.google.gson.annotations.SerializedName;

/**
 * List all teams for a certain competition.
 */

public class LinkToTeamsData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
