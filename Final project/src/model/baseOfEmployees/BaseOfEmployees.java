package model.baseOfEmployees;

import java.util.TreeSet;

public class BaseOfEmployees {

    private BaseOfEmployees() {
    }

    private static class SingletonHolder {
        private final static BaseOfEmployees BASEOFEMPLOYEES = new BaseOfEmployees();
    }

    public static BaseOfEmployees getInstance() {
        return SingletonHolder.BASEOFEMPLOYEES;
    }

    private String name;
    private String location;
    private int baseSalary;
    private TreeSet<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(TreeSet<Employee> employees) {
        this.employees = employees;
    }
    
    @Override
    public String toString() {
        return "BaseOfEmployees{" + "name=" + name + ", location=" + location
                + ", baseSalary=" + baseSalary + ", employees=\n" + employees + '}';
    }
    
}
