package bankomat;

import java.util.Scanner;

public class Bankomat {

    Scanner scan = new Scanner(System.in);

    private String gps;     //идентификатор (название) банкомата 
    private int money_20;   //количество купюр номиналом 20 рублей     
    private int money_50;   //количество купюр номиналом 50 рублей  
    private int money_100;  //количество купюр номиналом 100 рублей  

    public Bankomat(int money_20, int money_50, int money_100) {
        this.money_20 = money_20;
        this.money_50 = money_50;
        this.money_100 = money_100;
    }

    public String getGps() {
        return "\nВаш банкомат: " + gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public int getMoney_20() {
        return money_20;
    }

    public int getMoney_50() {
        return money_50;
    }

    public int getMoney_100() {
        return money_100;
    }

    public int getSum() {
        return money_20 * 20 + money_50 * 50 + money_100 * 100;
    }

    public void setMoney_20_plus(int money_20) {
        this.money_20 += money_20;
    }

    public void setMoney_50_plus(int money_50) {
        this.money_50 += money_50;
    }

    public void setMoney_100_plus(int money_100) {
        this.money_100 += money_100;
    }

    public void setMoney_20_minus() {
        this.money_20--;
    }

    public void setMoney_50_minus() {
        this.money_50--;
    }

    public void setMoney_100_minus() {
        this.money_100--;
    }
    

    //вывод доступных купюр и суммы
    public void vyvod() {
        System.out.println("\nВ банкомате количество купюр номиналом 20 р.: " + getMoney_20() + " шт.");
        System.out.println("В банкомате количество купюр номиналом 50 р.: " + getMoney_50() + " шт.");
        System.out.println("В банкомате количество купюр номиналом 100 р.: " + getMoney_100() + " шт.");
        System.out.println("Доступная Вам сумма: " + getSum() + " рублей.");

    }
    

    //метод выбора дальнейших действий
    public void dengi() {

        System.out.println("\nЧто будете делать?\n1 - загружать деньги, 2 - снимать деньги, "
                + "3 - узнаю баланс, 4 - пойду домой");
        while (!scan.hasNextInt()) {
            System.out.println("Неправильный ввод! Введите 1, 2 или 3!");
            scan.next();
        }
        int x = scan.nextInt();
        switch (x) {
            case 1:
                dobavit();
                break;
            case 2:
                System.out.println("\nСколько не хватает на пиво?");
                sniat();
                break;
            case 3:
                vyvod();
                dengi();
                break;
            case 4:
                System.out.println("\nДо свидания!");
                break;
            default:
                System.out.print("Таких вариантов нет! Спрашиваю ещё раз:");
                dengi();
                break;
        }
    }
    

    //добавление купюр в банкомат
    public void dobavit() {

        System.out.println("Какой номинал Вы хотите добавить? (20, 50, 100)");
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

        System.out.println("Введите количество купюр для загрузки (со знаком \"минус\" можно изъять)");
        while (!scan.hasNextInt()) {
            System.out.println("Неправильный ввод. Введите целое число!");
            scan.next();
        }
        int y = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 20:
                setMoney_20_plus(y);
                break;
            case 50:
                setMoney_50_plus(y);
                break;
            case 100:
                setMoney_100_plus(y);
                break;
        }
        vyvod();

        for (;;) {
            System.out.println("\nБудете ещё добавлять купюры? (yes/no)");
            String str = scan.nextLine();
            if (str.equalsIgnoreCase("no")) {
                dengi();
                break;
            } else if (str.equalsIgnoreCase("yes")) {
                dobavit();
                break;
            } else {
                System.out.print("Неправильный ввод! ");
            }
        }
    }
    

    //снятие денег на пивасик
    public void sniat() {

        while (!scan.hasNextInt()) {
            System.out.println("Если Вы с планеты Земля, то вводите арабские цифры!");
            scan.next();
        }
        int x = scan.nextInt(); //сумма для снятия
        if (x < 20 || x < 50 && x % 20 != 0 || x % 10 != 0) {
            System.out.println("Введите положительное число, кратное 20, 50, 100");
            sniat();
            return;
        } else if (x > getSum()) {
            System.out.println("В банкомате нет такой суммы денег, можно пиво и подешевле найти!");
            sniat();
            return;
        }
        boolean bool = kupiury(x);
        if (bool) {
            System.out.println("Операция прошла успешно! Получите и распишитесь!\n");
            vyvod();
            dengi();
        } else {
            System.out.println("Операция не может пройти успешно: не хватает мелочи, а в долг я не даю.");
            System.out.println("Попробуйте ввести немного другую сумму или идите домой.");
            dengi();
        }
    }

    public boolean kupiury(int x) {
        int mon_20 = 0;
        int mon_50 = 0;
        int mon_100 = 0;

        while (x >= 150 && getMoney_100() != 0 || x == 140 && getMoney_100() != 0
                || x == 120 && getMoney_100() != 0 || x == 100 && getMoney_100() != 0) {
            x -= 100;
            mon_100++;
            setMoney_100_minus();
        }
        while (x >= 100 && getMoney_50() != 0 || x >= 50 && x % 20 != 0 && getMoney_50() != 0) {
            x -= 50;
            mon_50++;
            setMoney_50_minus();
        }
        while (x > 10 && getMoney_20() != 0) {
            x -= 20;
            mon_20++;
            setMoney_20_minus();
        }
        if (x != 0 && mon_50 != 0) {   //если останется 1х50р. и 6х20р., а сумма 120р., то будет актуально
            x += 50;
            mon_50--;
            setMoney_50_plus(1);
            while (x > 10 && getMoney_20() != 0) {
                x -= 20;
                mon_20++;
                setMoney_20_minus();
            }
        }

        if (x == 0) {
            if (mon_100 != 0) {
                System.out.println("\tВам выдано купюр: " + mon_100 + " номиналом 100 рублей.");
            }
            if (mon_50 != 0) {
                System.out.println("\tВам выдано купюр: " + mon_50 + " номиналом 50 рублей.");
            }
            if (mon_20 != 0) {
                System.out.println("\tВам выдано купюр: " + mon_20 + " номиналом 20 рублей.");
            }
            return true;
        } else {
            setMoney_100_plus(mon_100);
            setMoney_50_plus(mon_50);
            setMoney_20_plus(mon_20);
            return false;
        }
    }
}
