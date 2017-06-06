package bankomat;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        Bankomat bank = new Bankomat(ran.nextInt(11), ran.nextInt(11), ran.nextInt(11));

        System.out.println("Введите название (идентификатор) банкомата");
        String name = scan.nextLine();
        bank.setGps(name);                  //ввод названия банкомата
        System.out.println(bank.getGps());  //вывод названия банкомата
        bank.vyvod();                       //вывод доступных купюр и суммы   
        bank.dengi();                       //метод выбора дальнейших действий
    }
}
