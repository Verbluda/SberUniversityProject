package Homework_3_Part_3;

public class TriangleChecker {
    private TriangleChecker() {}
    public static boolean checker(double a, double b, double c) {
        if ( a + b >= c) {
            if (b + c >= a) {
                if (a + c >= b) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(TriangleChecker.checker(2.5, 3.7, 1.3));
        System.out.println(TriangleChecker.checker(2.8, 1.6, 0.5));
    }
}
