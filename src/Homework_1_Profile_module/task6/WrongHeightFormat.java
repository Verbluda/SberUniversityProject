package Homework_1_Profile_module.task6;

import java.io.IOException;

public class WrongHeightFormat extends IOException {
    public WrongHeightFormat(String errorMessage) {
        super(errorMessage);
    }
    public WrongHeightFormat() {
        super("Рост должен быть положительным числом, допустимый формат 175.5, введите рост в корректном формате.");
    }
}
