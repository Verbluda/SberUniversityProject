package Homework_4_Profile_module;

import java.util.Set;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        Set<Set<Integer>> initialSet = Set.of(Set.of(0, 1, 2), Set.of(3, 4, 5), Set.of(6, 7, 8));
        Set<Integer> flatSet = initialSet.stream()
                .flatMap(Set<Integer>::stream)
                .collect(Collectors.toSet());
        System.out.println(flatSet);
    }
}
