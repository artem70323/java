package main;

import controller.Controller;

public class Main {
    
    public static void main(String[] args) {

        try {
            new Controller().startProject();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
