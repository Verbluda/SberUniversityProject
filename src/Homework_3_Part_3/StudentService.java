package Homework_3_Part_3;

public class StudentService {
    private StudentService() {
    }

    public static Student bestStudent(Student[] students) {
        double[] gradesPointAvarage = new double[students.length];
        for (int i = 0; i < gradesPointAvarage.length; i++) {
            gradesPointAvarage[i] = students[i].getGradePointAverage();
        }
        int indexBestStudent = 0;
        double maxGPA = gradesPointAvarage[indexBestStudent];
        for (int i = 1; i < gradesPointAvarage.length; i++) {
            if (maxGPA < gradesPointAvarage[i]) {
                maxGPA = gradesPointAvarage[i];
                indexBestStudent = i;
            }
        }
        return students[indexBestStudent];
    }

    public static void sortBySurname(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            Student tempStudent = new Student();
            tempStudent.setName(students[i].getName());
            tempStudent.setSurname(students[i].getSurname());
            tempStudent.setGrades(students[i].getGrades());
            int currentMinStudent = i;
            for (int j = i + 1; j < students.length; j++) {
                if (tempStudent.getSurname().compareTo(students[j].getSurname()) > 0) {
                    tempStudent.setName(students[j].getName());
                    tempStudent.setSurname(students[j].getSurname());
                    tempStudent.setGrades(students[j].getGrades());
                    currentMinStudent = j;
                }
            }
            if (currentMinStudent != i) {
                students[currentMinStudent].setName(students[i].getName());
                students[currentMinStudent].setSurname(students[i].getSurname());
                students[currentMinStudent].setGrades(students[i].getGrades());

                students[i].setName(tempStudent.getName());
                students[i].setSurname(tempStudent.getSurname());
                students[i].setGrades(tempStudent.getGrades());
            }
        }
    }
}

