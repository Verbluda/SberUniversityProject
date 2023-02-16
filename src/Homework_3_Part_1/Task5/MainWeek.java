package Homework_3_Part_1.Task5;

public class MainWeek {
    public static void main(String[] args) {
        DayOfWeek[] week = new DayOfWeek[7];
        for (int i = 0; i < 7; i++) {
            week[i] = DayOfWeek.ofNumber((byte)(i + 1));
            System.out.println(week[i].getDayNumber() + " " + week[i].getName());
        }
    }
}
