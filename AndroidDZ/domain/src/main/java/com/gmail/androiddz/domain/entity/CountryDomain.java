package com.gmail.androiddz.domain.entity;

import com.google.gson.annotations.SerializedName;

public class CountryDomain {

    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
