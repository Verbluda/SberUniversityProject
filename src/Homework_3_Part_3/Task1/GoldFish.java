package Homework_3_Part_3.Task1;

public class GoldFish extends Fish implements Swimming {
    @Override
    public void wayOfSwimming() {
        System.out.print("медленно плавает");
    }

    @Override
    public String toString() {
        return "Золотая рыбка";
    }
}
