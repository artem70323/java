package dz16;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        MyThread thread0 = new MyThread();
        MyThread thread1 = new MyThread();
        
        while (true) {
            System.out.println("Введите start");
            if (scan.nextLine().equals("start"))
                break;
        }
        
        thread0.start();
        thread1.start();
    }

    //без synchronized будет полная каша либо более-менее упорядочено
    public synchronized static void print10(Thread obj, int a, int b) {

        System.out.print(obj.getName() + ":");
        for (int i = a; i <= b; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

}
