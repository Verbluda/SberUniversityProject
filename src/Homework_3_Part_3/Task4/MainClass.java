package Homework_3_Part_3.Task4;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfParticipants = input.nextInt();

        ArrayList<Participant> participants = new ArrayList<>(numberOfParticipants);
        for (int i = 0; i < numberOfParticipants; i++){
            participants.add(new Participant(input.next()));
        }

        ArrayList<Dog> dogs = new ArrayList<>(numberOfParticipants);
        for (int i = 0; i < numberOfParticipants; i++){
            dogs.add(new Dog(input.next(), participants.get(i)));
        }

        for (int i = 0; i < numberOfParticipants; i++){
            dogs.get(i).setScores(input.nextInt());
            dogs.get(i).setScores(input.nextInt());
            dogs.get(i).setScores(input.nextInt());
        }

        for (int i = 0; i < numberOfParticipants; i++){
            dogs.get(i).averageScore();
        }

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            Dog currentMax = dogs.get(i);
            int currentMaxIndex = i;
            for (int j = i + 1; j < numberOfParticipants; j++) {
                if (currentMax.getAverageScore() < dogs.get(j).getAverageScore()) {
                    currentMax = dogs.get(j);
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != i) {
                dogs.add(currentMaxIndex, dogs.get(i));
                dogs.add(i, currentMax);
            }
        }

        for (int i = 0; i < numberOfParticipants; i++){
            System.out.println(dogs.get(i));
        }
    }
}
