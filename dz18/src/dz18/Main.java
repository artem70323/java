package dz18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) {
        
        MyTest myTest = new MyTest();
        Class clas = myTest.getClass();
        Field[] fields = clas.getDeclaredFields();
        
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                Class fieldType = f.getType();
                if (fieldType.equals(int.class)) {f.set(myTest, 555);}
                if (fieldType.equals(String.class)) {f.set(myTest, "Test");}
                if (fieldType.equals(float.class)) {f.set(myTest, 5.123f);}
            } catch (Exception ex) {
                System.out.println("error " + ex.getMessage());
            }
        }

        try {
            Method getI = clas.getMethod("getI"); 
            Method getS = clas.getMethod("getS"); 
            Method getF = clas.getMethod("getF"); 
            System.out.println(getI.invoke(myTest));
            System.out.println(getS.invoke(myTest));
            System.out.println(getF.invoke(myTest));
        } catch (Exception ex) {
            System.out.println("error " + ex.getMessage());
        }

        
        
    }
    
}
