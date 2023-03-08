package Homework_1_Profile_module.task6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormValidator {
    private FormValidator() {}


    //длина имени должна быть от 2 до 20 символов, первая буква заглавная
    public static void checkName(String str) throws WrongNameFormat {
        if ((str.length() > 1 && str.length() < 20)
                && ((str.charAt(0) > 'A' && str.charAt(0) < 'Z') || (str.charAt(0) > 'А' && str.charAt(0) < 'Я')) ) {
            System.out.println("Верный формат имени");
        } else {
            throw new WrongNameFormat();
        }
    }

    //дата рождения должна быть не раньше 01.01.1900 и не позже текущей даты
    public static void checkBirthdate(String str) throws WrongBirthdateFormat {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            Date birthdate = format.parse(str);
            Date startdate = format.parse("01.01.1900");
            Date now = new Date();
            if (birthdate.compareTo(startdate) >= 0 && birthdate.compareTo(now) <= 0) {
                System.out.println("Верный формат даты рождения");
            } else {
                throw new WrongBirthdateFormat();
            }
        } catch (ParseException e) {
            throw new WrongBirthdateFormat();
        }
    }

    //пол должен корректно матчится в enum Gender, хранящий Male и Female значения
    public static void checkGender(String str) throws WrongGenderFormat {
        if (str.equals(Gender.MALE.getGender()) || str.equals(Gender.FEMALE.getGender())) {
            System.out.println("Верный формат пола");
        } else {
            throw new WrongGenderFormat();
        }
    }

    //рост должен быть положительным числом и корректно конвертироваться в double
    public static void checkHeight(String str) throws WrongHeightFormat {
        try {
            double height = Double.parseDouble(str);
            if (height > 0) {
                System.out.println("Верный формат роста");
            } else {
                throw new WrongHeightFormat();
            }
        } catch (NumberFormatException e) {
            throw new WrongHeightFormat();
        }
    }
}
