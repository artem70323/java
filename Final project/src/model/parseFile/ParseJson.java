package model.parseFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import java.io.File;
import model.baseOfEmployees.BaseOfEmployees;

//используем библиотеку Jackson
public class ParseJson extends ParserThread {
    
    BaseOfEmployees baseOfEmployees = BaseOfEmployees.getInstance();
    
    @Override
    public void parse() {
    
        synchronized (this) {
            //спим
            view.View.print("ParserThread - спим");
            try {
                wait();
            } catch (InterruptedException ex) {
                view.View.print(ex.getMessage());
            }
        }

        //парсим
        view.View.print("ParserThread - парсим JSON");

        try {
            ObjectMapper mapper = new ObjectMapper();
            baseOfEmployees = mapper.readValue(new File("Employee.json"), BaseOfEmployees.class);
            Controller.baseOfEmployees = baseOfEmployees; 
        } catch (Exception ex) {
            view.View.print(ex.getMessage());
        }
        view.View.print("ParserThread - завершаем работу");
    }

}
