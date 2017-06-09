package dz8;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private Student[] student;
    private int kolStud;    //количество студентов 

    public static void main(String[] args) throws ParseException {

        Main main = new Main();
        main.kolStud();
        main.name();
        main.birthday();
        main.averageAge();
    }

    public void kolStud() {
        do {
            System.out.print("Введите количество студентов:\t");
            while (!scan.hasNextInt()) {
                System.out.println("Это не число!");
                scan.next();
            }
            kolStud = scan.nextInt();
        } while (kolStud <= 0);
        scan.nextLine();

        student = new Student[kolStud];

        for (int i = 0; i < kolStud; i++) {
            student[i] = new Student();
        }
    }

    //имя пациентов
    public void name() {
        for (int i = 0; i < kolStud; i++) {
            System.out.print("Введите имя и фамилию студента №" + (i + 1) + ":\t");
            student[i].setName(scan.nextLine());
        }
    }

    //дата рождения
    public void birthday() throws ParseException {
        System.out.println("\nВведите дату рождения в формате: dd MM yyyy. Пример: 08 02 1972");
        for (int i = 0; i < kolStud; i++) {
            System.out.print("Студент №" + (i + 1) + ":\t");
            student[i].setBirthday(scan.nextLine());
        }
    }

    public void averageAge() {

        long averageAge;
        long age = 0;
        for (int i = 0; i < kolStud; i++) {

            Date today = new Date();
            age += (today.getTime() - student[i].getBirthday().getTime());
        }

        averageAge = age / kolStud;         //средний возраст в миллисекундах
        Date averAge = new Date(averageAge);        

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(averAge);
        System.out.println("\nСредний возраст студентов:");
        System.out.print(calendar.get(Calendar.YEAR) - 1970 + averageAge2(calendar.get(Calendar.YEAR) - 1970, " год ", " года ", " лет "));
        System.out.print(calendar.get(Calendar.MONTH) + averageAge2(calendar.get(Calendar.MONTH), " месяц ", " месяца ", " месяцев "));
        System.out.print(calendar.get(Calendar.DAY_OF_MONTH) - 1 + averageAge2(calendar.get(Calendar.DAY_OF_MONTH) - 1, " день ", " дня ", " дней "));
        System.out.print(calendar.get(Calendar.HOUR_OF_DAY) + averageAge2(calendar.get(Calendar.HOUR_OF_DAY), " час ", " часа ", " часов "));
        System.out.println(calendar.get(Calendar.MINUTE) + averageAge2(calendar.get(Calendar.MINUTE), " минута ", " минуты ", " минут "));
    }

    public static String averageAge2(int year, String str1, String str2, String str3) {
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
