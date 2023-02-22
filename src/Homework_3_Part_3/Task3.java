package Homework_3_Part_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>(m);
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(i + j);
            }
            numbers.add(temp);
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                System.out.print(numbers.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
