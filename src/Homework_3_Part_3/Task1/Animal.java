package Homework_3_Part_3.Task1;

public abstract class Animal {
    protected Animal() {}
    public final void wayOfEating() {
        System.out.print("ест как все животные");
    }
    public final void wayOfSleeping() {
        System.out.print("спит как все животные");
    }
    public abstract void wayOfBirth();
}
