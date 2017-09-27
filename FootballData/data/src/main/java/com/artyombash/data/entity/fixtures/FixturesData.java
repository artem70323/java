package com.artyombash.data.entity.fixtures;

import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * List all fixtures for a certain competition.
 */
public class FixturesData {

    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("count")
    private Integer count;
    @SerializedName("fixtures")
    private List<FixtureData> fixtures = null;

    public LinksMainData getLinks() {
        return links;
    }

    public void setLinks(LinksMainData links) {
        this.links = links;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FixtureData> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixtureData> fixtures) {
        this.fixtures = fixtures;
    }

}
