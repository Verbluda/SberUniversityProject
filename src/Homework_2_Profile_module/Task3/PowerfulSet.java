package Homework_2_Profile_module.Task3;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    private PowerfulSet () {}
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(4);
        System.out.println(intersection(set1, set2));
        System.out.println(union(set1, set2));
        System.out.println(relativeComplement(set1, set2));
    }
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }
    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> relativeComplement = new HashSet<>(set1);
        relativeComplement.removeAll(set2);
        return relativeComplement;
    }
}
