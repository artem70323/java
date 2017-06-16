package listString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String proverka = new String();

        System.out.println("Введите данные массива. Слово для окончания ввода данных: end");
        while (!proverka.equals("end")) {
            proverka = scan.nextLine();
            if (!proverka.equals("end")) {
                list.add(proverka);
            }
        }
        System.out.println(list.toString());

        String str = new String();
        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            if (str.contains("a")) {
                str = str.replaceAll("a", "");
                list.set(i, str);
            }
        }
        System.out.println(list.toString());

        HashSet<String> sort = new HashSet(list);   //убираем повторяющиеся элементы      
        System.out.println(sort);                   //Set не может содержать повторяющиеся элементы
    }

}
