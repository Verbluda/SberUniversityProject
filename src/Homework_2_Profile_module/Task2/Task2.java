package Homework_2_Profile_module.Task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        System.out.println(convertToSortedList(s).equals(convertToSortedList(t)));
    }
    public static List<Character> convertToSortedList(String s) {
        List<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }
        Collections.sort(sList);
        return sList;
    }
}
