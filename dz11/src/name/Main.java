package name;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Person[]> hash = new HashMap<>();
        Person[] man = new Person[3];
        for (int i = 0; i < man.length; i++) {
            man[i] = new Person();
        }

        man[0].setName("Иван");
        man[0].setSurname("Иванов");
        man[0].setMiddleName("Иванович");

        man[1].setName("Владимир");
        man[1].setSurname("Путин");
        man[1].setMiddleName("Владимирович");

        man[2].setName("Александр");
        man[2].setSurname("Лукашенко");
        man[2].setMiddleName("Григорьевич");

        Person[] woman = new Person[3];
        for (int i = 0; i < woman.length; i++) {
            woman[i] = new Person();
        }

        woman[0].setName("Дарья");
        woman[0].setSurname("Домрачева");
        woman[0].setMiddleName("Владимировна");

        woman[1].setName("Саша");
        woman[1].setSurname("Грей");
        woman[1].setMiddleName("Александровна");

        woman[2].setName("Наоми");
        woman[2].setSurname("Кэмпбэлл");
        woman[2].setMiddleName("Наоновна");

        hash.put("man", man);
        hash.put("woman", woman);

        Scanner scan = new Scanner(System.in);
        boolean b = true;
        String key = new String();
        
        while (b) {
            System.out.println("Введите man или woman");
            key = scan.next();
            if (key.equals("man") || key.equals("woman")) {
                b = false;
            }
        }

        int i = (int) (Math.random() * 3);
        System.out.println(hash.get(key)[i].getName());
        System.out.println(hash.get(key)[i].getSurname());
        System.out.println(hash.get(key)[i].getMiddleName());
    }

}
