package Homework_3_Part_3;

import java.util.Scanner;

public class Afm {
    private double dollarsToRubles;
    private double rublesToDollars;
    private static int afmCounter;
    public Afm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите, пожалуйста, стоимость 1 доллара в рублях: ");
        double dollarPrice = input.nextDouble();
        while(dollarPrice < 0) {
            System.out.println("Значение не может быть отрицательным, пожалуйста, введите другое значение: ");
            dollarPrice = input.nextDouble();
        }
        dollarsToRubles = dollarPrice;
        System.out.println("Введите, пожалуйста, стоимость 1 рубля в долларах: ");
        double rublePrice = input.nextDouble();
        while(rublePrice < 0) {
            System.out.println("Значение не может быть отрицательным, пожалуйста, введите другое значение: ");
            rublePrice = input.nextDouble();
        }
        rublesToDollars = rublePrice;
        afmCounter++;
    }
    public double convertDollarsToRubles(double dollars) {
        return dollars * dollarsToRubles;
    }
    public double convertRublesToDollars(double rubles) {
        return rubles * rublesToDollars;
    }
    public static int getAfmCounter() {
        return afmCounter;
    }
}
