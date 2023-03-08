package Homework_1_Profile_module.task4;

import java.io.IOException;

public class NotEvenNumberException extends IOException {
    public NotEvenNumberException(String errorMessage) {
        super(errorMessage);
    }
    public NotEvenNumberException() {
        super("Вы ввели нечетное число, объект не был создан. Введите четное число.");
    }
}
