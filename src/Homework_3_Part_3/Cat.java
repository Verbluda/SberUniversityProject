package Homework_3_Part_3;

import java.util.Random;

public class Cat {
    private static void sleep() {
        System.out.println("Sleep");
    }
    private static void meow() {
        System.out.println("Meow");
    }
    private static void eat() {
        System.out.println("Eat");
    }
    public static void status() {
        Random randomizer = new Random();
        int choice = randomizer.nextInt(3);
        if (choice == 0) {
            Cat.sleep();
        }
        else if (choice == 1) {
            Cat.meow();
        }
        else if (choice == 2) {
            Cat.eat();
        }
    }
}
