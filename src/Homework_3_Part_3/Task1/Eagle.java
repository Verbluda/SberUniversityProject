package Homework_3_Part_3.Task1;

public class Eagle extends Bird implements Flying{
    @Override
    public void wayOfFlying() {
        System.out.print("быстро летает");
    }

    @Override
    public String toString() {
        return "Птица";
    }
}
