/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz4;

import java.util.Scanner;

public class Main {

    static int kolPat;
    static Pacienty[] pacient;
    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        kol();
        bol();
        imia();
        voz();
        diag();
        str();
        System.out.println("\nБольница " + Pacienty.nameHospital);
        for (int i = 0; i < kolPat; i++) {
            vyvod(i);
        }
        poisk();
    }
        
    //количество пациентов
    public static void kol() {
        do {
            System.out.print("Введите количество пациентов:\t");
            while (!scan.hasNextInt()) {
                System.out.println("Это не число!");
                scan.next();
            }
            kolPat = scan.nextInt();
        } while (kolPat <= 0);
        scan.nextLine();

        pacient = new Pacienty[kolPat];

        for (int i = 0; i < kolPat; i++) {
            pacient[i] = new Pacienty();
        }
    }        
    
    //название больницы
    public static void bol() {
        System.out.print("Введите название больницы:\t");
        Pacienty.nameHospital = scan.nextLine();
    }     
        
    //имя пациентов
    public static void imia() {
        for (int i = 0; i < kolPat; i++) {
            System.out.print("Введите имя пациента №" + (i + 1) + ":\t");
            pacient[i].name = scan.nextLine();
        }
    }

    //возраст
    public static void voz() {
        for (int i = 0; i < kolPat; i++) {
            do {
                System.out.print("Введите возраст пациента №" + (i + 1) + ":\t");
                while (!scan.hasNextInt()) {
                    System.out.println("Это не возраст!");
                    scan.next();
                }
                pacient[i].age = scan.nextInt();

            } while (kolPat <= 0);
        }
        scan.nextLine();
    }
    
    //диагноз
    public static void diag() {
        for (int i = 0; i < kolPat; i++) {
            System.out.print("Введите диагноз пациента №" + (i + 1) + ":\t");
            pacient[i].diagnoz = scan.nextLine();
        }
    }
        
    //страховка
    public static void str() {
        for (int i = 0; i < kolPat; i++) {
            System.out.println("Имеет ли пациент №" + (i + 1) + " страховку? (true/false)\t");
            while (!scan.hasNextBoolean()) {
                System.out.println("Введите true или false");
                scan.next();
            }
            pacient[i].isStrahovka = scan.nextBoolean();
        }
        scan.nextLine();
    }

    //вывод на экран
    public static void vyvod(int i) {
        System.out.print("Пациент " + pacient[i].name + " - Возраст = " + pacient[i].age
                + " - диагноз " + pacient[i].diagnoz + " - ");
        if (pacient[i].isStrahovka == true) {
            System.out.println("страховка есть");
        } else {
            System.out.println("страховки нет");
        }
    }
    
    //поиск по имени или возрасту
    public static void poisk() {
        int x = 0;
        System.out.println("\nВведите имя или возраст для поиска");
        if (scan.hasNextInt()) {
            int vozrast = scan.nextInt();
            for (int i = 0; i < kolPat; i++) {
                if (vozrast == pacient[i].age) {
                    System.out.println("Пациент №" + (i + 1) + " :");
                    vyvod(i);
                    x++;
                }
            }
        } else if (scan.hasNextLine()) {
            String name = scan.nextLine();
            for (int i = 0; i < kolPat; i++) {
                if (name.equalsIgnoreCase(pacient[i].name)) {
                    System.out.println("Пациент №" + (i + 1) + " :");
                    vyvod(i);
                    x++;
                }
            }
        }
        if (x == 0) {
            System.out.println("Совпадений не найдено");
        }
    }
}




