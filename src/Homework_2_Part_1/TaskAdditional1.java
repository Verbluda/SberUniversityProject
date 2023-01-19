package Homework_2_Part_1;

import java.util.Random;
import java.util.Scanner;

public class TaskAdditional1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите длину пароля: ");
        int n = input.nextInt();
        while (n < 8) {
            System.out.println("Пароль с " + n + " количеством символов небезопасен, введите другую длину пароля: ");
            n = input.nextInt();
        }
        char[] password = generatePassword(n);
        System.out.print("Ваш пароль: ");
        for (int i = 0; i < n; i++) {
            System.out.print(password[i]);
        }
    }
    public static char[] generatePassword(int n) {
        Random random = new Random();
        char[] password = new char[n];
        char[] specialChar = {'_', '*', '-'};
        int randomizer;

        //Обязательная заглавная буква
        password[0] = (char)(random.nextInt(90 + 1 - 65) + 65);
        //Обязательная строчная буква
        password[1] = (char)(random.nextInt(122 + 1 - 97) + 97);
        //Обязательная цифра
        password[2] = (char)(random.nextInt(57 + 1 - 48) + 48);
        //Обязательный спец.символ
        password[3] = specialChar[random.nextInt(3)];
        //Заполняем остальные символы
        for (int i = 4; i < n; i++) {
            randomizer = random.nextInt(4) + 1;
            if (randomizer == 1) {
                password[i] = (char)(random.nextInt(90 + 1 - 65) + 65);
            } else if (randomizer == 2) {
                password[i] = (char)(random.nextInt(122 + 1 - 97) + 97);
            } else if (randomizer == 3) {
                password[i] = (char)(random.nextInt(57 + 1 - 48) + 48);
            } else if (randomizer == 4) {
                password[i] = specialChar[random.nextInt(3)];
            }
        }
        //Перемешиваем символы пароля в случайном порядке
        for (int i = 0; i < password.length; i++) {
            int j = (int)(Math.random() * password.length);
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }

        return password;
    }
}
