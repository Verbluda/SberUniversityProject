package Homework_3_Profile_module.task1_2;

public class Main {
    public static void writeDescription(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(IsLike.class)) {
            return;
        }
        IsLike isLike = clazz.getAnnotation(IsLike.class);
        System.out.println(isLike.isLike());
    }

    public static void main(String[] args) {
        writeDescription(TestClass.class);
    }
}
