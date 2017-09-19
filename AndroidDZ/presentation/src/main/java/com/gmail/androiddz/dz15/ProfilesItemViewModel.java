package com.gmail.androiddz.dz15;


import com.gmail.androiddz.domain.entity.ProfileIdSql;

public class ProfilesItemViewModel {

    public ProfileIdSql id;
    public String name;

    public ProfileIdSql getId() {
        return id;
    }

    public void setId(ProfileIdSql id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
