package Homework_3_Profile_module;

import java.util.*;

public class Task4 {
    interface A {
    }

    interface B {
    }

    interface Z extends B, A {}

    static class C implements A {
    }

    static class D extends C implements Z {
    }
    public static Set<Class<?>> getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> result = new HashSet<>();
        List<Class<?>> interfaces = new ArrayList<>();
        while (clazz != Object.class) {
            interfaces.addAll(Arrays.asList(clazz.getInterfaces()));
            clazz = clazz.getSuperclass();
        }
        List<Class<?>> interfaces2 = new ArrayList<>();
        for (Class<?> anInterface : interfaces) {
            interfaces2.addAll(Arrays.asList(anInterface.getInterfaces()));
        }
        interfaces.addAll(interfaces2);
        result.addAll(interfaces);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getAllInterfaces(D.class));
    }
}
