package threadInternet;

/* Этот поток ждёт, пока другой поток скачивает JSON, затем парсит его,
*  затем ждёт, пока другой поток скачивает XML, затем парсит его.
 */

public class ParserThread extends Thread{

    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }
    
    @Override
    public void run() {
        
        synchronized (this) {
            //спим
            System.out.println("ParserThread - спим");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        //парсим JSON
        System.out.println("ParserThread - парсим JSON");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
         synchronized (downloaderThread) {
            //пробуждаем поток DownloaderThread
            System.out.println("ParserThread - пробуждаем поток DownloaderThread");
            downloaderThread.notifyAll();
         }
         
         synchronized (this) {
            //затем сами засыпаем
            System.out.println("ParserThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        
        //парсим XML
        System.out.println("ParserThread - парсим XML");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        System.out.println("ParserThread - завершаем работу");
    }
    
}
