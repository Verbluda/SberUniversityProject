package Homework_3_Part_3.Task1;

public abstract class Bird extends Animal {
    protected Bird() {}

    @Override
    public final void wayOfBirth() {
        System.out.print("откладывает яйца");
    }
}
