package bankomat;

public class Bankomat {

    String gps = "Банкомат на улице Вязов";
    private static int a; //количество купюр номиналом 20   
    private static int b; //количество купюр номиналом 50
    private static int c; //количество купюр номиналом 100

    public Bankomat(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getSum() {
        return a * 20 + b * 50 + c * 100;
    }
    
    public static void setAplus(int a) {
        Bankomat.a += a;
    }

    public static void setBplus(int b) {
        Bankomat.b += b;
    }

    public static void setCplus(int c) {
        Bankomat.c += c;
    }
    
    public static void setAminus() {
        Bankomat.a--;
    }
    
    public static void setBminus() {
        Bankomat.b--;
    }
    
    public static void setCminus() {
        Bankomat.c--;
    }
}
