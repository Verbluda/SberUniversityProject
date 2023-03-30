package Homework_4_Profile_module;

import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 101).filter(x -> x % 2 == 0).sum());
    }
}