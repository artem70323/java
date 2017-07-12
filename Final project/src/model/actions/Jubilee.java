package model.actions;

import java.util.Calendar;
import model.baseOfEmployees.BaseOfEmployees;
import model.baseOfEmployees.Employee;


//поиск юбиляров
public class Jubilee {

    public static void jubilee() {

        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (Employee employee : BaseOfEmployees.getInstance().getEmployees()) {
            //находим юбиляров в текущем году
            if (((year - employee.getDateOfBirth().get(Calendar.YEAR)) % 10) == 0) {
                view.View.print(employee.getName());
            }
        }
    }

}
