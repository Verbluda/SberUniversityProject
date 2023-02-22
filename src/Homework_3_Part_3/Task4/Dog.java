package Homework_3_Part_3.Task4;

import Homework_3_Part_2.Book;

import java.util.ArrayList;
import java.util.Objects;

public class Dog {
    private String nameOfDog;
    private Participant nameOfParticipant;
    private ArrayList<Integer> scores;
    private double averageScore;

    public Dog(String nameOfDog, Participant nameOfParticipant) {
        this.nameOfDog = nameOfDog;
        this.nameOfParticipant = nameOfParticipant;
    }

    public String getNameOfDog() {
        return nameOfDog;
    }

    public void setNameOfDog(String nameOfDog) {
        this.nameOfDog = nameOfDog;
    }

    public Participant getNameOfParticipant() {
        return nameOfParticipant;
    }

    public void setNameOfParticipant(Participant nameOfParticipant) {
        this.nameOfParticipant = nameOfParticipant;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(int score) {
        this.scores.add(score);
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void averageScore() {
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        averageScore = (double) sum / scores.size();
    }

    @Override
    public String toString() {
        return nameOfParticipant + " : " + nameOfDog + ", " + averageScore + "." ;
    }
}
