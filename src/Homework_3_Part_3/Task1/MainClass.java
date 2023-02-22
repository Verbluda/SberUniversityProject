package Homework_3_Part_3.Task1;

public class MainClass {
    public static void main(String[] args) {
        Bat batman = new Bat();
        Dolphin phlipper = new Dolphin();
        GoldFish magikarp = new GoldFish();
        Eagle pidgeotto = new Eagle();
        System.out.println("Список животных и их характеристики: ");

        System.out.print(batman + ": способ размножения - ");
        batman.wayOfBirth();
        System.out.print(", ");
        batman.wayOfFlying();
        System.out.print(", ");
        batman.wayOfEating();
        System.out.print(", ");
        batman.wayOfSleeping();
        System.out.print(".\n");

        System.out.print(phlipper + ": способ размножения - ");
        phlipper.wayOfBirth();
        System.out.print(", ");
        phlipper.wayOfSwimming();
        System.out.print(", ");
        phlipper.wayOfEating();
        System.out.print(", ");
        phlipper.wayOfSleeping();
        System.out.print(".\n");

        System.out.print(magikarp + ": способ размножения - ");
        magikarp.wayOfBirth();
        System.out.print(", ");
        magikarp.wayOfSwimming();
        System.out.print(", ");
        magikarp.wayOfEating();
        System.out.print(", ");
        magikarp.wayOfSleeping();
        System.out.print(".\n");

        System.out.print(pidgeotto + ": способ размножения - ");
        pidgeotto.wayOfBirth();
        System.out.print(", ");
        pidgeotto.wayOfFlying();
        System.out.print(", ");
        pidgeotto.wayOfEating();
        System.out.print(", ");
        pidgeotto.wayOfSleeping();
        System.out.print(".\n");
    }
}
