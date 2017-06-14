package file;

import java.io.*;

public class Main {

    static Student[] student = new Student[4];

    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "D:\\notes.txt";

        for (int i = 0; i < student.length; i++) {
            student[i] = new Student();
        }
        read(fileName);
        for (int i = 0; i < student.length; i++) {
            System.out.println("Имя:" + student[i].getName() + " Возраст:" + student[i].getAge() + " Заочник:" + student[i].isIsZaoch());
        }
    }

    public static void read(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        exists(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                int i = 0;
                while ((line = in.readLine()) != null) {
                    String[] strArray = line.split("\\|");
                    student[i].setName(strArray[0]);
                    student[i].setAge(Integer.parseInt(strArray[1]));
                    student[i].setIsZaoch(Boolean.parseBoolean(strArray[2]));
                    i++;
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

}
