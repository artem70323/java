package main2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2 {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        //разбил на две строки, т.к. месяц автоматически склоняется в JDK 8        
        SimpleDateFormat sd = new SimpleDateFormat("MMMM");
        SimpleDateFormat sd2 = new SimpleDateFormat("d'е', h:mm a");
        String dateString = sd.format(date);
        String dateString2 = sd2.format(date);
        System.out.println(dateString + " " + dateString2);

        //последнее задание
        Date date2;
        String str = "2017-06-05 20:25";
        SimpleDateFormat sd3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date2 = sd3.parse(str);
        System.out.println(date2);
    }

}
