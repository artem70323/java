package com.artyombash.data.entity.links;

import com.google.gson.annotations.SerializedName;

/**
 * Link to oneself.
 */
public class LinkToSelfData {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
