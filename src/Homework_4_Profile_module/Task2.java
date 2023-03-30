package Homework_4_Profile_module;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        System.out.println(l.stream().reduce((x,y)-> x * y).get());
    }
}
