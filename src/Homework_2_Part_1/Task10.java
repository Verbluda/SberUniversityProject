package Homework_2_Part_1;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int randomizer = new Random().nextInt(1001);
        System.out.print("Я загадал число от 0 до 1000 включительно, попробуйте угадать. Ваш вариант ответа: ");
        int m = new Scanner(System.in).nextInt();
        iWantToPlayAGame(m, randomizer);
    }
    public static void iWantToPlayAGame(int m, int randomizer) {
        Scanner input = new Scanner(System.in);
        while (m >= 0) {
            if (m < randomizer) {
                System.out.println("Это число меньше загаданного.");
                m = input.nextInt();
            } else if (m > randomizer){
                System.out.println("Это число больше загаданного.");
                m = input.nextInt();
            } else {
                System.out.println("Победа!");
                break;
            }
        }
    }
}