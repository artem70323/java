package bankomat;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Bankomat bank;

    public static void main(String[] args) {

        Random ran = new Random();
        bank = new Bankomat(ran.nextInt(11), ran.nextInt(11), ran.nextInt(11));        
        System.out.println(bank.gps);
        vyvod();
        System.out.println("Что будете делать?\n1 - загружать деньги, 2 - снимать деньги, "
                + "3 - пойду домой");
        dengi();
    }

    public static void dengi() {        
        while (!scan.hasNextInt()) {
            System.out.println("Неправильный ввод! Введите 1, 2 или 3!");
            scan.next();
        }
        int x = scan.nextInt();
        switch (x) {
            case 1:
                System.out.println("Какой номинал Вы хотите добавить? (20, 50, 100)");
                dobavit();
                break;
            case 2:
                System.out.println("\nСколько не хватает на пиво?");
                sniat();
                break;
            case 3:
                System.out.println("\nДо свидания!");
                return;
            default:
                System.out.println("Неправильный ввод! Введите 1, 2 или 3!");
                dengi();
                break;
        }
    }
    

    //вывод количества денег на экран
    public static void vyvod() {
        System.out.println("\nВ банкомате количество купюр номиналом 20 р.: " + bank.getA() + " шт.");
        System.out.println("В банкомате количество купюр номиналом 50 р.: " + bank.getB() + " шт.");
        System.out.println("В банкомате количество купюр номиналом 100 р.: " + bank.getC() + " шт.");
        System.out.println("Доступная Вам сумма: " + bank.getSum() + " рублей.\n");

    }

    
    //добавление купюр в банкомат
    static void dobavit() {

        while (!scan.hasNextInt()) {
            System.out.println("Неправильный ввод. Введите число!");
            scan.next();
        }
        int x = scan.nextInt();
        if (x != 20 && x != 50 && x != 100) {
            System.out.println("Введите правильный номинал! ");
            dobavit();
            return;
        }

        System.out.println("Введите количество купюр для загрузки");
        while (!scan.hasNextInt()) {
            System.out.println("Неправильный ввод. Введите число!");
            scan.next();
        }
        int y = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 20:
                Bankomat.setAplus(y);
                break;
            case 50:
                Bankomat.setBplus(y);
                break;
            case 100:
                Bankomat.setCplus(y);
                break;
        }
        vyvod();

        for (;;) {
            System.out.println("Будете ещё добавлять купюры? (yes/no)");
            String str = scan.nextLine();
            if (str.equalsIgnoreCase("no")) {
                System.out.println("Что будете делать?\n1 - загружать деньги, 2 - снимать деньги, "
                + "3 - пойду домой");
                dengi();
                break;
            } else if (str.equalsIgnoreCase("yes")) {
                System.out.println("Какой номинал Вы хотите добавить? (20, 50, 100)");
                dobavit();
                break;
            } else {
                System.out.print("Неправильный ввод! ");
            }
        }
    }

    
    //снятие денег на пивасик
    public static void sniat() {

        while (!scan.hasNextInt()) {
            System.out.println("Если Вы с планеты Земля, то вводите арабские цифры!");
            scan.next();
        }
        int x = scan.nextInt();
        if (x < 20 || x < 50 && x % 20 != 0 || x % 10 != 0) {
            System.out.println("Введите число, кратное 20, 50, 100");
            sniat();
            return;
        } else if (x > bank.getSum()) {
            System.out.println("В банкомате нет такой суммы денег, можно пиво и подешевле найти!");
            sniat();
            return;
        }
        boolean bool = kupiury(x);
        if (bool) {
            System.out.println("Операция прошла успешно! Получите и распишитесь!\n");
            vyvod();
            System.out.println("Что будете делать?\n1 - загружать деньги, 2 - снимать деньги, "
                + "3 - пойду домой");
            dengi();
        } else {
            System.out.println("Операция не может пройти успешно: нет мелочи, а в долг я не даю.");
            System.out.println("Попробуйте ввести немного другую сумму или идите домой.\n");
            System.out.println("Что будете делать?\n1 - загружать деньги, 2 - снимать деньги, "
                + "3 - пойду домой");
            dengi();
        }
    }

    public static boolean kupiury(int x) {
        int a = 0;
        int b = 0;
        int c = 0;

        while (x >= 150 && bank.getC() != 0 || x == 140 && bank.getC() != 0
                || x == 120 && bank.getC() != 0 || x == 100 && bank.getC() != 0) {
            x -= 100;
            c++;
            bank.setCminus();
        }
        while (x >= 100 && bank.getB() != 0 || x >= 50 && x % 20 != 0 && bank.getB() != 0) {
            x -= 50;
            b++;
            bank.setBminus();
        }
        while (x > 10 && bank.getA() != 0) {
            x -= 20;
            a++;
            bank.setAminus();
        }
        if (x != 0) {   //если останется 1х50р. и 6х20р., а сумма 120р., то будет актуально
            x += 50;
            b--;
            bank.setBplus(1);
            while (x > 10 && bank.getA() != 0) {
                x -= 20;
                a++;
                bank.setAminus();
            }
        }

        if (x == 0) {
            if (c != 0) {
                System.out.println("\tВам выдано купюр: " + c + " номиналом 100 рублей.");
            }
            if (b != 0) {
                System.out.println("\tВам выдано купюр: " + b + " номиналом 50 рублей.");
            }
            if (a != 0) {
                System.out.println("\tВам выдано купюр: " + a + " номиналом 20 рублей.");
            }
            return true;
        } else {
            bank.setCplus(c);
            bank.setBplus(b);
            bank.setAplus(a);
            return false;
        }
    }
}
