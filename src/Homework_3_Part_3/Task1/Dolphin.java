package Homework_3_Part_3.Task1;

public class Dolphin extends Mammal implements Swimming {
    @Override
    public void wayOfSwimming() {
        System.out.print("быстро плавает");
    }

    @Override
    public String toString() {
        return "Дельфин";
    }
}
