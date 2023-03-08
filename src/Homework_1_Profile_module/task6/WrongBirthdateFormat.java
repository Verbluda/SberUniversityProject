package Homework_1_Profile_module.task6;

import java.io.IOException;

public class WrongBirthdateFormat extends IOException {
    public WrongBirthdateFormat(String errorMessage) {
        super(errorMessage);
    }
    public WrongBirthdateFormat() {
        super("Дата рождения должна быть не раньше 01.01.1900 и не позже текущей даты, введите дату рождения в корректном формате.");
    }
}
