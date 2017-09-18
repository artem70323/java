package com.gmail.androiddz.domain.entity;

public class ProfileDomainSql {

    private ProfileIdSql profileId;
    private String name;
    private int age;
    private CountryDomain country;

    public ProfileIdSql getProfileId() {
        return profileId;
    }

    public void setProfileId(ProfileIdSql profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CountryDomain getCountry() {
        return country;
    }

    public void setCountry(CountryDomain country) {
        this.country = country;
    }
}
