package com.example.gameboi.MathGame;

import java.util.Random;

class MathGameManager {

    // int representation of user's response.
    private int response = 0;
    //int representation of the user's answer.
    private int answer = 0;
    // The number of rounds played. Game ends when either 10 rounds have been played or the player
    // loses 3 times
    private int numRounds = 0;
    //The number of questions the player got wrong
    private int numLosses = 0;
    //int representation of the number of questions the user has answered correctly.
    private int score = 0;
    // The current equation to solve
    private String equation;
    private Random rand = new Random();

    int getResponse() {return response;}
    void setResponse() {response = 0;}
    int getScore() {return score;}
    void setScore(int newScore) {score = newScore;}
    int getNumRounds() {return numRounds;}
    void incrementNumRounds() {numRounds += 1;}
    int getNumLosses() {return numLosses;}
    private void incrementNumLosses() {numLosses += 1;}
    String getEquation() {return equation;}
    void newEquation(){generateEquation();}

    void checkAnswer(){
        if (answer == response) {score += 1;}
        else { incrementNumLosses(); }
    }

    void updateResponse(int num) {response = response * 10 + num;}


    private void generateEquation() {
        String[] operators = {" + ", " - ", " // ", " * "};
        int num1 = rand.nextInt(25) + 1;
        int num2 = rand.nextInt(10) + 1;

        //Randomly selects whether its an addition, subtraction, multiplication or division question
        int op = rand.nextInt(4);

        //Checks for which operation was selected from operators
        if (op == 0) {answer = num1 + num2;}
        else if (op == 1) {
            //In the case of subtraction, does not allow for the answer to be a negative number
            if (num1 < num2){
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            answer = num1 - num2;
        }
        else if (op == 2) {answer = num1 / num2;}
        else {answer = num1 * num2;}

        //Displays the equation for the user
        equation = num1 + operators[op] + num2;
    }
}
