package Homework_3_Profile_module.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) {
        APrinter aPrinter = new APrinter();
        try {
            Method[] method = aPrinter.getClass().getMethods();
            method[0].invoke(aPrinter, 5);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
