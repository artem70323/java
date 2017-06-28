package dz16;

public class Main {

    public static void main(String[] args) {

        MyThread thread0 = new MyThread();
        MyThread thread1 = new MyThread();
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
