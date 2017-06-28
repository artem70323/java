package dz16;

public class MyThread extends Thread {

    @Override
    public void run() {
        int a = 1;
        int b = 10;

        while (b <= 100) {
            Main.print10(this, a, b);
            a += 10;
            b += 10;
        }
    }

}
