package dz19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StaffCollectionIterator<T extends People> implements Iterator<Map.Entry> {

    private HashMap<String, List<T>> data;
    private int size;
    private int number = 0; //счётчик
    private ArrayList<Map.Entry<String, List<T>>> mapEntry = new ArrayList<>();

    public StaffCollectionIterator(HashMap<String, List<T>> data) {
        this.data = data;
        init();
    }

    private void init() {
        for (Map.Entry<String, List<T>> entry : data.entrySet()) {
            mapEntry.add(entry);
        }
        size = mapEntry.size();
    }

    @Override
    public boolean hasNext() {
        if (number < size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map.Entry next() {
        number++;
        return mapEntry.get(number - 1);
    }

}
