package com.artyombash.domain.entity.fixtures;

import com.artyombash.domain.entity.links.LinksMain;

import java.util.List;

/**
 * List all fixtures for a certain competition.
 */
public class Fixtures {

    private LinksMain links;
    private Integer count;
    private List<Fixture> fixtures = null;

    public LinksMain getLinks() {
        return links;
    }

    public void setLinks(LinksMain links) {
        this.links = links;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
