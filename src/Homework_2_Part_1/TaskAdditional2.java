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
        //Создание, заполнение массива (считаем сколько отрицательных чисел)
        int negativeNumberCount = 0;
        int[] b = new int[n];
        for ( int i = 0; i < n; i++) {
            if (a[i] < 0) {
                negativeNumberCount++;
            }
            b[i] = (int) Math.pow(a[i], 2);
        }

        //Сортировка массива
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            if (negativeNumberCount > 0) {
                int j = negativeNumberCount - 1; //индекс левого числа
                int k = 1; //счетчик положения правого числа
                while (j >= 0 && j + k < n) {
                    if (b[j] >= b[j + k]) {
                        c[i] = b[j + k];
                        k++;
                    } else {
                        c[i] = b[j];
                        j--;
                        k++;
                    }
                    i++;
                    negativeNumberCount--; //считаем сколько квадратов отрицательных чисел осталось сравнить
                }
            }
            c[i] = b[i];
        }
        //Печать нового массива
        for (int e: c){
            System.out.print(e + " ");
        }
    }
}
