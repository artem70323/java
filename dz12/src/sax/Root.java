package sax;

import java.util.ArrayList;

public class Root {

    private String name;
    private ArrayList<People> people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<People> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Root [name=" + name + ", people=" + people + "]";
    }

}
