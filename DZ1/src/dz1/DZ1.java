/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz1;

/**
 *
 * @author Квартира_97
 */
public class DZ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //упражнение №1
        String str = "Первая строка, вторая строка";
        int length = str.length();
        System.out.println("Длина строки = " + length);

        String str1 = str.substring(0, length / 2);
        String str2 = str.substring(length / 2);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        //упражнение №2
        double x = 256.27;
        String y = Double.toString(x);
        //первый вариант
        char ch = y.charAt(y.length() - 1);
        if (ch == '7') {
            System.out.println("\nПоследняя цифра 7");
        } else {
            System.out.println("\nПоследняя цифра не 7");
        }
        //второй вариант
        if (y.endsWith("7")) {
            System.out.println("Последняя цифра 7");
        } else {
            System.out.println("Последняя цифра не 7");
        }

        //упражнение №3
        double a = 4;
        double b = 5;
        double r = 6;
        if (Math.sqrt(a * a + b * b) > (r * 2)) {
            System.out.println("\nПрямоугольник не закрыт");
        } else {
            System.out.println("\nПрямоугольник закрыт");
        }

        //упражнение №4               
        int rub = 4022;
        int r10 = rub % 10;
        int r100 = rub % 100;
        if (r10 == 1 && r100 != 11) {
            System.out.println("\n" + rub + " рубль");
        } else if (r10 >= 2 && r10 <= 4 && (r100 < 12 || r100 > 14)) {
            System.out.println("\n" + rub + " рубля");
        } else {
            System.out.println("\n" + rub + " рублей");
        }

        //упражнение №5
        String hi = "?, #my# friend!#";
        String hello = hi.replace("?", "Hello");
        String hello2 = hello.replace("#", "");
        System.out.println('\n' + hello2);

        //упражнение №6
        double xx = 5;
        double tt = 6;
        double ss = 7;
        double yy = (Math.pow(Math.sin(Math.pow(xx, tt)), 2)) / Math.sqrt(1 + Math.pow(xx, ss));
        System.out.println("\n" + yy);

    }

}
