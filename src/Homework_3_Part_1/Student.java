package Homework_3_Part_1;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private int[] grades;

    public Student() {};
    public Student(String name, String surname, int[] grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public int[] getGrades() {
        if (grades == null) {
            System.out.println("Данных по оценкам нет");
        }
        return grades;
    }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setGrades(int[] grades) {
        this.grades = Arrays.copyOf(grades, grades.length);
    }
    public void addGrade(int grade) {
        if (grades == null) {
            grades = new int[1];
            grades[0] = grade;
        }
        else if (grades.length == 10) {
            for (int i = 0; i < grades.length - 1; i++) {
                grades[i] = grades[i + 1];
            }
            grades[grades.length - 1] = grade;
        }
        else if (grades.length < 10) {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = grade;
        }
    }
    public double getGradePointAverage() {
        return (Arrays.stream(grades).sum() * 1.00) / grades.length;
    }
}
