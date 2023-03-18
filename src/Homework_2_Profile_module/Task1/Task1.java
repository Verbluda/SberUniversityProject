package Homework_2_Profile_module.Task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(3);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        newList.add(3);
        System.out.println(newList);
        System.out.println(convertArrayListToSet(newList));
    }
    public static <T> Set<T> convertArrayListToSet(ArrayList<T> list) {
        return new HashSet<>(list);
    }
}
