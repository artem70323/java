package dz14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File {

    public static void main(String[] args) {

        System.out.println("Введите имя файла");
        Scanner scan = new Scanner(System.in);
        String file = scan.nextLine();
        String regex = "\\.\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(file);
        m.find();
        System.out.println("Расширение файла:    " + m.group());
        if (m.group().equals(".xml") || m.group().equals(".json")) {
            System.out.println("Ваш формат нам подходит");
        } else {
            System.out.println("Ваш формат нам не подходит");
        }
    }

}
