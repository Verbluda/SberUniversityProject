package Homework_1_Profile_module.task6;

import java.io.IOException;

public class WrongGenderFormat extends IOException {
    public WrongGenderFormat(String errorMessage) {
        super(errorMessage);
    }
    public WrongGenderFormat() {
        super("Пол должен быть Male или Female, введите пол в корректном формате.");
    }
}
