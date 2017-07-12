package model.baseOfEmployees;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Employee implements Comparable<Employee>{
    
    private int id;
    private String name;
    private String degree;
    private Calendar dateOfBirth = Calendar.getInstance();
    @JsonProperty("yearEperience")
    private int yearExperience;
    private ArrayList<String> emails = new ArrayList<>();
    private boolean visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        //задаю формат даты
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOfBirth.setTime(sdf.parse(dateOfBirth));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void addEmails(String email) {
        emails.add(email);
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", name=" + name + ", degree=" 
                + degree + ", dateOfBirth = " + dateOfBirth.get(Calendar.DAY_OF_MONTH) 
                + " " + (dateOfBirth.get(Calendar.MONTH)+1) + " " 
                + dateOfBirth.get(Calendar.YEAR) + ", yearExperience=" 
                + yearExperience + ", emails=" + emails + "}\n";
    }

    //сортируем сотрудников по месяцу и дню рождения
    @Override
    public int compareTo(Employee o) {
        int result = dateOfBirth.get(Calendar.MONTH) - (o.dateOfBirth.get(Calendar.MONTH));
        if (result != 0) {
            return result;
        }

        result = dateOfBirth.get(Calendar.DAY_OF_MONTH) - (o.dateOfBirth.get(Calendar.DAY_OF_MONTH));
        if (result != 0) {
            return result;
        }

        return 0;
    }
    
}