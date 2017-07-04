package threadInternet;

public class Main {
    
    public static void main(String[] args) {
        
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        
        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);
        
        downloaderThread.start();
        parserThread.start();
        
    }
    
}
