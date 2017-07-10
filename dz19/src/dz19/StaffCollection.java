package dz19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StaffCollection<T extends People> implements Iterable<Map.Entry> {

    private T director;
    private HashMap<String, List<T>> data = new HashMap<>();

    public void addDirector(T value) {
        director = value;
    }

    public T getDirector() {
        return director;
    }

    public void removeDirector(T value) {
        director = null;
    }

    public void addDepartment(String department) {
        if (data.containsKey(department)) {
            System.out.println("Такой отдел уже существует");
        } else {
            data.put(department, new ArrayList<>());
        }
    }

    public void removeDepartment(String department) {
        if (data.containsKey(department)) {
            data.remove(department);
        } else {
            System.out.println("Такого отдела нет");
        }
    }

    public void addEmployee(String department, T value) {
        if (data.containsKey(department)) {
            data.get(department).add(value);
        } else {
            List<T> list = data.get(department);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(value);
            data.put(department, list);
        }
    }

    public void removeEmployee(String department, T value) {
        if (data.containsKey(department)) {
            data.get(department).remove(value);
        } else {
            System.out.println("Такого отдела нет");
        }
    }

    public void printAllStaff() {
        System.out.println("Director: " + director);
        Iterator itr = iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Override
    public Iterator<Map.Entry> iterator() {
        return new StaffCollectionIterator<>(data);
    }

}
