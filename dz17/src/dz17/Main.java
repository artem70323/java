package dz17;

public class Main {
    
    int a = 0;
    volatile boolean isExit = false;
    
    public static void main(String[] args) {
        
        new Main().go();
    }
    
    public void go() {
        new Thread(aaa, "A").start();
        new Thread(bbb, "B").start();
    }

    Runnable aaa = new Runnable() {
        @Override
        public void run() {
            
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(500);
                    a++;
                    System.out.println(Thread.currentThread().getName()
                            + ": " + "a = " + a + " isExit = " + isExit);
                } catch (InterruptedException ex) {}
            }
            
            isExit = true;
            System.out.println(Thread.currentThread().getName()
                    + ": " + " isExit = " + isExit);
        }
    };
    
    Runnable bbb = new Runnable() {
        @Override
        public void run() {
            //если isExit не volatile, то цикл будет крутиться вечно
            while (!isExit) {
            }
            System.out.println("bbb stop");
        }
    };
    
    
    
}
    
    
    
    
    
    
    
    
    

