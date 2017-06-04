package dz6;

import java.util.Arrays;

public class Dz6 {

    public static void main(String[] args) {

        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] b = new int[20];
        System.arraycopy(a, 0, b, 5, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
