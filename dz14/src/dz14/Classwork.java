package dz14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classwork {

    public static void main(String[] args) {

        String text = "2017 AB-7";
        Pattern p = Pattern.compile("[0-9]{4}\\s\\w{2}-[0-7]");
        Matcher m = p.matcher(text);
        if (m.matches()) {
            System.out.println("номер белорусский");
        } else {
            System.out.println("номер неверный");
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер");
        String str = scan.nextLine();
        p = Pattern.compile("\\+375(\\(| )?(17|29|44|33)(\\)| )?\\d{7}");
        m = p.matcher(str);
        if (m.matches()) {
            System.out.println("номер белорусский");
        } else {
            System.out.println("номер небелорусский");
        }

        text = "ddasdas test@fd.com fdjfhdjf test@mail.ru";
        text = text.replaceAll("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}", "");
        System.out.println("text = " + text);
    }

}
