package calculator;

import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static double a;    //первое число
    static String b;    //арифметический оператор
    static double c;    //второе число
    static double d;    //результат
    
    public static void main(String[] args) {
        
        boolean rep = true;
        System.out.println("Введите первое число");
        while (rep) {
            try {
                a = scan.nextDouble();
                rep = false;
            } catch (InputMismatchException im) {
                System.err.println("Ввод данных некорректен, попробуйте ещё раз");
                scan.next();
            }
        }
        rep = true;
        
        System.out.println("Введите арифметический оператор (+, -, *, /)");   
        while (rep) {
            try {
                b = scan.next();                
                plus(b);    //проверка на правильный ввод операторов
                rep = false;
            } catch (MyEX math) {
                System.err.println(math.getRussianMessage());
                scan.nextLine();
            }
        }
        rep = true;        
        
        System.out.println("Введите второе число");
                while (rep) {
            try {
                c = scan.nextDouble();
                rep = false;
            } catch (InputMismatchException im) {
                System.err.println("Ввод данных некорректен, попробуйте ещё раз");
                scan.next();
            }
        }                
        
        switch (b) {
            case "+":
                d = a + c;
                System.out.println("Ваш результат: " + d);
                break;
            case "-":
                d = a - c;
                System.out.println("Ваш результат: " + d);
                break;
            case "*":
                d = a * c;
                System.out.println("Ваш результат: " + d);
                break;
            case "/":
                try {
                    zero(c);
                    d = a / c;
                    System.out.println("Ваш результат: " + d);
                } catch (MyEX2 math) {
                    System.err.println(math.getRussianMessage());
                }
                break;
        }
    }
    

    public static void plus(String b) throws MyEX {
        if (!b.equals("/") && !b.equals("*") && !b.equals("-") && !b.equals("+")) {
            throw new MyEX();
        }
    }
    

    public static void zero(double c) throws MyEX2 {
        if (c == 0) {
            throw new MyEX2();
        }
    }

}
