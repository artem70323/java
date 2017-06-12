package bankomat;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        Bankomat bank = new Bankomat(ran.nextInt(11), ran.nextInt(11), ran.nextInt(11));

        bank.setListener(new OnGetListener() {
            @Override
            public void onGet(int a) {
                switch (a) {
                    case 1:
                        System.out.println("Подождите, банкомат смеётся с Вашей зарплаты...");
                        break;
                    case 2:
                        System.out.println("Операция прошла успешно! Получите и распишитесь!\n");
                        break;
                    case 3:
                        System.out.println("Операция не может пройти успешно: не хватает мелочи, а в долг я не даю.");
                        System.out.println("Попробуйте ввести немного другую сумму или идите домой.");
                        break;
                }
            }
        });
        
        System.out.println("Введите название (идентификатор) банкомата");
        String name = scan.nextLine();
        bank.setGps(name);                  //ввод названия банкомата
        System.out.println(bank.getGps());  //вывод названия банкомата
        bank.vyvod();                       //вывод доступных купюр и суммы   
        bank.dengi();                       //метод выбора дальнейших действий
    }
    
}
