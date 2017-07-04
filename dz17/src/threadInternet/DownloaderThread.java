package threadInternet;


/* Этот поток скачивает JSON, затем ждёт, пока его распарсит другой поток,
*  затем скачивает XML и снова ждёт, пока его распарсит другой поток.
 */

public class DownloaderThread extends Thread{
    
    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }
    
    @Override
    public void run() {
        
        //скачиваем JSON
        System.out.println("DownloaderThread - скачиваем JSON");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        

        synchronized (parserThread) {
            //пробуждаем поток парсера
            System.out.println("DownloaderThread - пробуждаем поток парсера");
            parserThread.notifyAll();
        }
        
         synchronized (this) {
            //затем сами засыпаем
            System.out.println("DownloaderThread - сами засыпаем");
            try {
                wait();
            } catch (InterruptedException ex) {}
         }
        
        //скачиваем XML
        System.out.println("DownloaderThread - скачиваем XML");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        
        synchronized (parserThread) {
            //пробуждаем поток парсера
            System.out.println("DownloaderThread - пробуждаем поток парсера");
            parserThread.notifyAll();
        }
        System.out.println("DownloaderThread - завершаем работу");
    }

}
