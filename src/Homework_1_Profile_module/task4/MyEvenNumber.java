package Homework_1_Profile_module.task4;

import java.io.IOException;
import java.util.Scanner;

public class MyEvenNumber {
    private static final Scanner scanner = new Scanner(System.in);
    private int n;
    public MyEvenNumber() throws NotEvenNumberException {
        int m = scanner.nextInt();
        if (m % 2 == 0) {
            n = m;
        } else {
            throw new NotEvenNumberException();
        }
    }

    @Override
    public String toString() {
        return "MyEvenNumber{" +
                "n=" + n +
                '}';
    }
}
