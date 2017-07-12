package controller;

import java.util.Scanner;
import model.actions.AverageAge;
import model.actions.Jubilee;
import model.actions.SearchEmployee;
import model.baseOfEmployees.BaseOfEmployees;
import model.downloadFile.DownloadFile;
import model.parseFile.ParseJson;
import model.parseFile.ParseXml;
import model.parseFile.ParserThread;

public class Controller {

    Scanner scan = new Scanner(System.in);
    public static BaseOfEmployees baseOfEmployees = BaseOfEmployees.getInstance();
    
    private static final String LINKXML = "http://kiparo.ru/t/birthdays.xml";
    private static final String LINKJSON = "http://kiparo.ru/t/birthdays.json";
    private static final String DOWNLOAD = "Выберите файл для скачки: 1 - XML, 2 - JSON";
    private static final String CYCLE = "Выберите дальнейшее действие: 1 - Вывод юбиляра,"
            + " 2 - вывод среднего возраста, 3 - поиск сотрудника по дню\nрождения, "
            + "4 - вывод сотрудников по их дню рождения, 5 - выход из программы";
    private static final String DATA = "Выберите поиск по дню - 1, "
            + "по месяцу - 2, по году - 3 или по дате - 4";

    public void startProject() throws InterruptedException {

        download();
        Thread.sleep(2000);
        cycle();
    }

    //скачка и парсинг файла
    private void download() {
        DownloadFile downloadFile = new DownloadFile();
        ParserThread parserThread = null;
        boolean bool = true;
        do {
            view.View.print(DOWNLOAD);
            while (!scan.hasNextInt()) {
                view.View.print("Неправильный ввод");
                scan.next();
            }
            int scanInt = scan.nextInt();
            if (scanInt == 1) {
                parserThread = new ParseXml();
                downloadFile.setLink(LINKXML);
                bool = false;
            } else if (scanInt == 2) {
                parserThread = new ParseJson();
                downloadFile.setLink(LINKJSON);
                bool = false;
            }
        } while (bool);
        downloadFile.setParserThread(parserThread);
        parserThread.start();   //начинаем первым, потому что он спит изначально
        downloadFile.start();
    }
    
    //распечатка сотрудников
    private void printEmployees() {
        view.View.print(baseOfEmployees);
    }
    
    //цикл выбора дальнейших действий
    public void cycle() {
        do {
            view.View.print(CYCLE);
            while (!scan.hasNextInt()) {
                view.View.print("Неправильный ввод");
                scan.next();
            }
            int scanInt = scan.nextInt();
            if (scanInt == 1) {
                jubilee();
            } else if (scanInt == 2) {
                averAge();
            } else if (scanInt == 3) {
                search();
            } else if (scanInt == 4) {
                printEmployees();
            } else if (scanInt == 5) {
                view.View.print("До свидания");
                return;
            }
        } while (true);
    }

    //юбиляры
    private void jubilee() {
        Jubilee.jubilee();
    }
    
    //средний возраст сотрудников
    private void averAge() {
        AverageAge.averageAge();
    }
    
    //поиск сотрудников
    private void search() {
        do {
            view.View.print(DATA);
            while (!scan.hasNextInt()) {
                view.View.print("Неправильный ввод");
                scan.next();
            }
            int scanData = scan.nextInt();
            if (scanData == 1) {
                searchDay();
                return;
            } else if (scanData == 2) {
                searchMonth();
                return;
            } else if (scanData == 3) {
                searchYear();
                return;
            } else if (scanData == 4) {
                searchDate();
                return;
            }
        } while (true);
    }
    
    private void searchDay() {
        do {
            view.View.print("Введите день до 31");
            while (!scan.hasNextInt()) {
                view.View.print("Неправильный ввод");
                scan.next();
            }
            int scanDay = scan.nextInt();
            if (0 < scanDay && scanDay <= 31) {
                SearchEmployee.searchDay(scanDay);
                return;
            }
        } while (true);
    }
    
    private void searchMonth() {
        do {
            view.View.print("Введите месяц до 12");
            while (!scan.hasNextInt()) {
                view.View.print("Неправильный ввод");
                scan.next();
            }
            int scanMonth = scan.nextInt();
            if (0 < scanMonth && scanMonth <= 12) {
                SearchEmployee.searchMonth(scanMonth);
                return;
            }
        } while (true);
    }
    
    private void searchYear() {
        view.View.print("Введите год");
        while (!scan.hasNextInt()) {
            view.View.print("Неправильный ввод");
            scan.next();
        }
        int scanYear = scan.nextInt();
        SearchEmployee.searchYear(scanYear);
    }
    
    private void searchDate() {
       view.View.print("Введите дату в формате dd MM yyyy");
        scan.nextLine();
        String scanData = scan.nextLine();
        SearchEmployee.searchDate(scanData);
    }

}
