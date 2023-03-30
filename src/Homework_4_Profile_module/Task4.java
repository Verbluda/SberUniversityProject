package Homework_4_Profile_module;

import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> l = List.of(5, 2, 7, 4, 10);
        l.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
