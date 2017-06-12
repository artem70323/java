package file;

import java.io.*;
import java.util.Scanner;

public class WorkInFile {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = scan.nextLine();

        try (FileWriter writer = new FileWriter("C:\\notes.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (FileReader reader = new FileReader("C:\\notes.txt")) {
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
