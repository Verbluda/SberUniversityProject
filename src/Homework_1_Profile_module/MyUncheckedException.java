package Homework_1_Profile_module;

public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String errorMessage) {
        super(errorMessage);
        System.out.println("LOG: " + errorMessage);
    }

}
