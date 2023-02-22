package Homework_3_Part_3.Task2;

public class MainClass {
    public static void main(String[] args) {
        Stool newStool = new Stool();
        Table newTable = new Table();
        System.out.println(BestCarpenterEver.isPossibleToMend(newStool));
        System.out.println(BestCarpenterEver.isPossibleToMend(newTable));
    }
}
