package com.gmail.androiddz.data.entity;

import com.google.gson.annotations.SerializedName;

public class ProfileData {

    @SerializedName("Name")
    private String name;

    @SerializedName("Surname")
    private String surname;

    @SerializedName("Age")
    private int age;

    @SerializedName("objectId")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
