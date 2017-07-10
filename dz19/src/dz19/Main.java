package dz19;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        
        PvtPeople director = new PvtPeople();
        PvtPeople employee1 = new PvtPeople();
        PvtPeople employee2 = new PvtPeople();
        PvtPeople employee3 = new PvtPeople();
        PvtPeople employee4 = new PvtPeople();
        
        StaffCollection<PvtPeople> staf = new StaffCollection<>();
        

        staf.addDirector(director);
        staf.addEmployee("Java", employee1);
        staf.addEmployee("Java", employee2);
        staf.addEmployee("Android", employee3);
        staf.addEmployee("Android", employee4);
        
//        System.out.println(staf.toString());
        
        staf.printAllStaff();
        
        
    }
    
    
}
