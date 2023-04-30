package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> level1() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("D", "B", "C", "A", "C", "");
        final QuestionsList question2 = new QuestionsList("10", "2", "3", "4", "3", "");
        final QuestionsList question3 = new QuestionsList("Z", "Y", "X", "F", "Y", "");
        final QuestionsList question4 = new QuestionsList("39", "7", "6", "2", "2", "");
        final QuestionsList question5 = new QuestionsList("Q", "W", "E", "R", "W", "");
        final QuestionsList question6 = new QuestionsList("8", "12", "1", "7", "8", "");
        final QuestionsList question7 = new QuestionsList("L", "K", "J", "H", "K", "");
        final QuestionsList question8 = new QuestionsList("17", "6", "9", "0", "9", "");
        final QuestionsList question9 = new QuestionsList("V", "R", "J", "S", "V", "");
        final QuestionsList question10 = new QuestionsList("7", "16", "1", "5", "1", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    private static List<QuestionsList> level2() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Brown", "Black", "Blue", "Red", "Black", "");
        final QuestionsList question2 = new QuestionsList("Excited", "Dream", "Happy", "Tired", "Excited", "");
        final QuestionsList question3 = new QuestionsList("A", "2", "C", "12", "A", "");
        final QuestionsList question4 = new QuestionsList("Pink", "Sad", "Bad", "7", "Bad", "");
        final QuestionsList question5 = new QuestionsList("Yellow", "32", "Tomato", "Surprise", "Surprise", "");
        final QuestionsList question6 = new QuestionsList("9", "2", "3", "4", "9", "");
        final QuestionsList question7 = new QuestionsList("Grumpy", "Bored", "Nervous", "Happy", "Grumpy", "");
        final QuestionsList question8 = new QuestionsList("White", "Purple", "Orange", "Green", "Purple", "");
        final QuestionsList question9 = new QuestionsList("H", "D", "6", "N", "N", "");
        final QuestionsList question10 = new QuestionsList("Feeling", "Red", "3", "G", "Feeling", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);


        return questionsLists;
    }

    private static List<QuestionsList> level3() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Bicycle", "Ship", "Helicopter", "Truck", "Ship", "");
        final QuestionsList question2 = new QuestionsList("Dog", "Cat", "Lion", "Tiger", "Dog", "");
        final QuestionsList question3 = new QuestionsList("Motorcycle", "Bear", "Bus", "Snake", "Snake", "");
        final QuestionsList question4 = new QuestionsList("Sheep", "Taxi", "Zebra", "Ambulance", "Ambulance", "");
        final QuestionsList question5 = new QuestionsList("X", "3", "Sad", "Brown", "X", "");
        final QuestionsList question6 = new QuestionsList("10", "Y", "M", "4", "4", "");
        final QuestionsList question7 = new QuestionsList("Mouse", "Horse", "Bison", "Monkey", "Horse", "");
        final QuestionsList question8 = new QuestionsList("L", "2", "Black", "Aeroplane", "Aeroplane", "");
        final QuestionsList question9 = new QuestionsList("Tired", "5", "Blue", "Scooter", "Tired", "");
        final QuestionsList question10 = new QuestionsList("Lion", "Elephant", "Gorilla", "Giraffe", "Elephant", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    private static List<QuestionsList> level4() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Apple", "Orange", "Tomato", "Potato", "Apple", "");
        final QuestionsList question2 = new QuestionsList("Lunch", "Dinner", "Breakfast", "Egg", "Breakfast", "");
        final QuestionsList question3 = new QuestionsList("Onion", "Mushroom", "Pumpkin", "Corn", "Mushroom", "");
        final QuestionsList question4 = new QuestionsList("Apple", "Orange", "Tomato", "Potato", "Apple", "");
        final QuestionsList question5 = new QuestionsList("Train", "C", "Yellow", "Happy", "Train", "");
        final QuestionsList question6 = new QuestionsList("A", "0", "Potato", "4", "0", "");
        final QuestionsList question7 = new QuestionsList("Salad", "Blue", "Tiger", "Surprise", "Salad", "");
        final QuestionsList question8 = new QuestionsList("1", "Carrot", "Toast", "Pizza", "Pizza", "");
        final QuestionsList question9 = new QuestionsList("B", "7", "18", "T", "7", "");
        final QuestionsList question10 = new QuestionsList("Dinner", "Truck", "Cat", "Sheep", "Sheep", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestion(String selectedTopic)
    {
        switch (selectedTopic)
        {
            case "Level 1":
                return level1();
            case "Level 2":
                return level2();
            case "Level 3":
                return level3();
            default:
                return level4();
        }
    }
}
