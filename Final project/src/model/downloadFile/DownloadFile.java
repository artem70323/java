package model.downloadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.parseFile.ParserThread;

public class DownloadFile extends Thread {
    
    private ParserThread parserThread;
    private String link;
    
    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    @Override
    public void run() {

        view.View.print("DownloadFile - скачиваем файл");

        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        File file;
        
        try {
            //открываем соединение
            URL url = new URL(link);
            HttpURLConnection httpURLConnection
                    = (HttpURLConnection) url.openConnection();

            //получаем код ответа (от сайта или сервера)
            int responsecode = httpURLConnection.getResponseCode();

            //проверяем, успешное ли подключение, т.е. проверка на ошибки
            if (responsecode == HttpURLConnection.HTTP_OK) {

                inputStream = httpURLConnection.getInputStream();

                //создаём новый файл с подходящим расширением
                if (link.matches(".+\\.xml$")) {
                    file = new File("Employee.xml");
                } else {
                    file = new File("Employee.json");
                }
                
                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];  //то, что мы скачиваем, т.е. полезная информация
                int bytesRead = -1;  //количество прочитанных байт за одно чтение
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    //записываем в файл байты от "0" до "bytesRead" из массива "buffer"
                    outputStream.write(buffer, 0, bytesRead);
                }
                
            } else {
                view.View.print("responsecode = " + responsecode);
            }
            
        } catch (IOException ex) {
            view.View.print("Ошибка " + ex.getMessage());
            view.View.print("Проверьте подключение к интернету");
            System.exit(0);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                view.View.print("Ошибка при закрытии стрима " + e.getMessage());
            }
        }
        //пробуждаем поток парсера
        synchronized (parserThread) {
            view.View.print("DownloadFile - пробуждаем поток парсера");
            parserThread.notifyAll();
            view.View.print("DownloadFile - завершаем работу");
        }
    }

}
