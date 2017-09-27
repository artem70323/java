package com.artyombash.data.entity.links;

import com.google.gson.annotations.SerializedName;

/**
 * Show League Table / current standing.
 */

public class LinkToLeagueTableData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
