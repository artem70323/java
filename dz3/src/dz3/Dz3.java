package dz3;

import java.util.Scanner;

public class Dz3 {

    public static void main(String[] args) {

        int[] dz = mass();
        vyvod(dz);
        int[] dz1 = dz.clone();
        int[] dz2 = dz.clone();
        int[] dz3 = dz.clone();
        quickSort(dz1);
        shell(dz2);
        bucketSort(dz3);
        chisla(dz);
    }

    public static int[] mass() {

        int[] mass = new int[10];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < mass.length; i++) {
            mass[i] = scan.nextInt();
        }
        return mass;
    }

    public static void vyvod(int[] vyv) {
        System.out.println("\n");
        for (int i = 0; i < vyv.length - 1; i++) {
            System.out.print(vyv[i] + "|");
        }
        System.out.print(vyv[vyv.length - 1]);
    }

    
    
    //быстрая сортировка
    public static void quickSort(int[] quick) {
        int startIndex = 0;
        int endIndex = quick.length - 1;
        doSort(startIndex, endIndex, quick);
        vyvod(quick);
    }

    public static void doSort(int start, int end, int[] zd) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (zd[i] <= zd[cur])) {
                i++;
            }
            while (j > cur && (zd[cur] <= zd[j])) {
                j--;
            }
            if (i < j) {
                int temp = zd[i];
                zd[i] = zd[j];
                zd[j] = temp;
                if (i == cur) {
                    cur = j;
                } else if (j == cur) {
                    cur = i;
                }
            }
        }
        doSort(start, cur, zd);
        doSort(cur + 1, end, zd);
    }

    
    
    //сортировка Шелла
    public static void shell(int[] shell) {

        int step = shell.length / 2;//инициализируем шаг.
        while (step > 0)//пока шаг не 0
        {
            for (int i = 0; i < (shell.length - step); i++) {
                int j = i;
                //будем идти начиная с i-го элемента
                while (j >= 0 && shell[j] > shell[j + step]) //пока не пришли к началу массива
                //и пока рассматриваемый элемент больше
                //чем элемент находящийся на расстоянии шага
                {
                    //меняем их местами
                    int temp = shell[j];
                    shell[j] = shell[j + step];
                    shell[j + step] = temp;
                    j--;
                }
            }
            step = step / 2;//уменьшаем шаг
        }
        vyvod(shell);
    }

    
    
    //блочная (карманная) сортировка
    public static void bucketSort(int[] arr) {

        //поиск максимального элемента массива
        int maxValue = arr[0];

        for (int k = 1; k < arr.length; k++) {
            if (arr[k] > maxValue) {
                maxValue = arr[k];
            }
        }
        int i, j;
        //создадим вспомогательный массив
        int[] bucket = new int[maxValue + 1];
        //распределим числа по карманам
        for (i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        //отсортируем числа в карманах используя сортировку подсчетом
        for (i = 0, j = 0; i < bucket.length; i++) {
            for (; bucket[i] > 0; (bucket[i])--) {
                arr[j++] = i;
            }
        }
        vyvod(arr);
    }

    
    
    //подсчёт чётных чисел
    public static void chisla(int[] mass) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % 2 == 0) {
                x++;
            }
        }
        int[] chet = new int[x];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % 2 == 0) {
                chet[y] = mass[i];
                y++;
            }
        }
        vyvod(chet);
    }
}
