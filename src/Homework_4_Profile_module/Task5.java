package Homework_4_Profile_module;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        List<String> l = List.of("abc", "def", "qqq");
        System.out.println(l.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
}
