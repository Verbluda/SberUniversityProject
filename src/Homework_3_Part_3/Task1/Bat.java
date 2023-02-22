package Homework_3_Part_3.Task1;

public class Bat extends Mammal implements Flying {
    @Override
    public void wayOfFlying() {
        System.out.print("медленно летает");
    }

    @Override
    public String toString() {
        return "Летучая мышь";
    }
}
