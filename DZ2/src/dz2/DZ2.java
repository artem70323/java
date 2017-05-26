/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz2;

import java.util.Arrays;

/**
 *
 * @author Квартира_97
 */
public class DZ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //упражнение №1
        int[] mass = {2, 5, 8, 6, 10, 56, 21, 27, 7, 1};
        int min = mass[0];
        int max = mass[0];
        int a = 1;
        int b = 1;
        for (int i = 1; i < mass.length; i++) {
            if (mass[i] < min) {
                min = mass[i];
                a = i + 1;
            } else if (mass[i] > max) {
                max = mass[i];
                b = i + 1;
            }
        }
        System.out.println("min value = " + min);
        System.out.println("max value = " + max);
        mass[a - 1] = 0;
        mass[b - 1] = 99;
        System.out.println(Arrays.toString(mass) + "\n");

        //упражнение №2
        float[] fl = {2, 3, 5, 7, 6, 5, 7, 3, 7, 20};
        boolean[] povtor = new boolean[fl.length]; //ячейки с одинаковыми числами
        float ch = 0; //число, которое повторяется
        int povt; //количество повторений
        int j;
        for (int i = 0; i < fl.length - 1; i++) { //последнюю ячейку не с чем сравнивать, поэтому length - 1
            povt = 1;
            j = i + 1;
            if (povtor[i] == false) { //если ячейка не повторялась, она хранит значение false
                do {
                    if (fl[i] != fl[j]) {
                        j++;
                    } else {
                        ch = fl[i];
                        povt++;
                        povtor[j] = true;
                        j++;
                    }
                } while (j < fl.length);
                if (povt != 1) {
                    System.out.println("[" + ch + "] - повторений " + povt);
                }
            }
        }

        //упражнение №3
        int[] inv = {14, 2, 546, 17, 877, 9, 61, 41, 745, 465, 7, 5, 1, 6, 4};
        System.out.println("\n" + Arrays.toString(inv));
        int len = inv.length / 2;
        for (int i = 0; i < len; i++) {
            int aa = inv.length - 1 - i;
            int bb = inv[i];
            inv[i] = inv[aa];
            inv[aa] = bb;
        }
        System.out.println(Arrays.toString(inv));

        //упражнение №4
        int[] sort = {14, 2, 546, 17, 877, 9, 61, 41, 745, 465, 7, 5, 1, 6, 4};
        for (int i = sort.length - 1; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                if (sort[k] > sort[k + 1]) {
                    int temp = sort[k];
                    sort[k] = sort[k + 1];
                    sort[k + 1] = temp;
                }
            }
        }
        System.out.println("\n" + Arrays.toString(sort));

    }

}
