package model.actions;

import java.util.Calendar;
import model.baseOfEmployees.BaseOfEmployees;
import model.baseOfEmployees.Employee;

//поиск юбиляров
public class Jubilee {

    public static void jubilee(BaseOfEmployees baseOfEmployees) {

        int jubilee = 0;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (Employee employee : baseOfEmployees.getEmployees()) {
            //находим юбиляров в текущем году
            if (((year - employee.getDateOfBirth().get(Calendar.YEAR)) % 10) == 0) {
                view.View.print(employee.getName());
                jubilee++;
            }
        }
        if (jubilee == 0) {
            view.View.print("Юбиляров в этом году нет");
        }
    }

}
