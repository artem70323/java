package model.actions;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TimeZone;
import model.baseOfEmployees.BaseOfEmployees;
import model.baseOfEmployees.Employee;

//поиск среднего возраста сотрудников
public class AverageAge {

    public static void averageAge() {
        //получаем сотрудников
        Set<Employee> set = BaseOfEmployees.getInstance().getEmployees();
        int size = set.size();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        //программа может некорректно определять часовой пояс системы, с консоли должно работать как надо
        long averageAge;    //средний возраст
        long age = 0;       //суммарный возраст
        Date today = new Date();

        for (Employee employee : set) {
            age += (today.getTime() - employee.getDateOfBirth().getTimeInMillis());
        }

        averageAge = age / size;     //средний возраст в миллисекундах
        Date averAge = new Date(averageAge);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(averAge);
        view.View.print("Средний возраст сотрудников:");
        view.View.print(calendar.get(GregorianCalendar.YEAR) - 1970 
                + averageAge2(calendar.get(GregorianCalendar.YEAR) - 1970, " год ", " года ", " лет "));
        view.View.print(calendar.get(GregorianCalendar.MONTH) 
                + averageAge2(calendar.get(GregorianCalendar.MONTH), " месяц ", " месяца ", " месяцев "));
        view.View.print(calendar.get(GregorianCalendar.DAY_OF_MONTH) - 1 
                + averageAge2(calendar.get(GregorianCalendar.DAY_OF_MONTH) - 1, " день ", " дня ", " дней "));
        view.View.print(calendar.get(GregorianCalendar.HOUR_OF_DAY) 
                + averageAge2(calendar.get(GregorianCalendar.HOUR_OF_DAY), " час ", " часа ", " часов "));
        view.View.print(calendar.get(GregorianCalendar.MINUTE) 
                + averageAge2(calendar.get(GregorianCalendar.MINUTE), " минута ", " минуты ", " минут "));
    }

    //ставим правильный падеж
    private static String averageAge2(int year, String str1, String str2, String str3) {
        int y10 = year % 10;
        int y100 = year % 100;
        if (y10 == 1 && y100 != 11) {
            return str1;
        } else if (y10 >= 2 && y10 <= 4 && (y100 < 12 || y100 > 14)) {
            return str2;
        } else {
            return str3;
        }
    }

}
