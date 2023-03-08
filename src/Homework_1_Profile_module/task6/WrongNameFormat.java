package Homework_1_Profile_module.task6;

import java.io.IOException;

public class WrongNameFormat extends IOException {
    public WrongNameFormat(String errorMessage) {
        super(errorMessage);
    }
    public WrongNameFormat() {
        super("Длина имени должна быть от 2 до 20 символов, первая буква заглавная, введите имя в корректном формате.");
    }
}
