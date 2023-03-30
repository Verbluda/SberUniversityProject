package Homework_4_Profile_module;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> l = List.of("abc", "", "", "def", "qqq");
        System.out.println(l.stream().filter(x -> x != "").count());
    }
}
