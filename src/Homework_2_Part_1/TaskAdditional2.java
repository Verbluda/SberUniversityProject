package Homework_2_Part_1;

import java.util.Scanner;

public class TaskAdditional2 {
    public static void main(String[] args) {
        //Получение входных данных
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = console.nextInt();
        }
        //Создание, заполнение и сортировка массива
        int[] b = new int[n];
        for ( int i = 0; i < n; i++) {
            b[i] = (int) Math.pow(a[i], 2);
        }

        int j;
        for (int i = 1; i < n; i++) {
            int temp = b[i];
            for (j = i; j > 0 && temp < b[j - 1]; j--) {
                b[j] = b[j - 1];
            }
            b[j] = temp;
        }

        //Печать нового массива
        for (int e: b){
            System.out.print(e + " ");
        }
    }
}
