package com.artyombash.data.entity.links;


import com.google.gson.annotations.SerializedName;

public class LinkToTeamData {

    @SerializedName("team")
    private LinkToSelfData team;

    public LinkToSelfData getTeam() {
        return team;
    }

    public void setTeam(LinkToSelfData team) {
        this.team = team;
    }

}
