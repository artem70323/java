package model.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.baseOfEmployees.BaseOfEmployees;
import model.baseOfEmployees.Employee;

//поиск сотрудников по дате
public class SearchEmployee {
    
    //поиск по дню рождения
    public static void searchDay(int day) {
        for (Employee employee : BaseOfEmployees.getInstance().getEmployees()) {
            if (employee.getDateOfBirth().get(Calendar.DAY_OF_MONTH) == day) {
                view.View.print(employee.toString());
            }
        }
    }

    //поиск по месяцу рождения
    public static void searchMonth(int month) {
        for (Employee employee : BaseOfEmployees.getInstance().getEmployees()) {
            if (employee.getDateOfBirth().get(Calendar.MONTH) == month - 1) {
                view.View.print(employee.toString());
            }
        }
    }

    //поиск по году рождения
    public static void searchYear(int year) {
        for (Employee employee : BaseOfEmployees.getInstance().getEmployees()) {
            if (employee.getDateOfBirth().get(Calendar.YEAR) == year) {
                view.View.print(employee.toString());
            }
        }
    }

    //поиск по дате рождения
    public static void searchDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException ex) {
            view.View.print(ex.getMessage());
        }
        for (Employee employee : BaseOfEmployees.getInstance().getEmployees()) {
            if (employee.getDateOfBirth().equals(cal)) {
                view.View.print(employee.toString());
            }
        }
    }

}
