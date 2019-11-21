package com.example.gameboi;

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
    // The random number generator used for creating the numbers for the equation
    private Random rand = new Random();

    /**
     * @return the current user response
     */
    int getResponse() {return response;}

    /**
     * Resets the player's response to 0.
     */
    void resetResponse() {response = 0;}

    /**
     * @return the player's current score
     */
    int getScore() {return score;}

    /**
     * Sets the player's score to newScore.
     * @param newScore the new score for the player
     */
    void setScore(int newScore) {score = newScore;}

    /**
     * @return the number of rounds played thus far
     */
    int getNumRounds() {return numRounds;}

    /**
     * Increases numRounds played by 1
     */
    void incrementNumRounds() {numRounds += 1;}

    /**
     * @return the numLosses so far.
     */
    int getNumLosses() {return numLosses;}

    /**
     * Increases numLosses by 1.
     */
    private void incrementNumLosses() {numLosses += 1;}

    /**
     * @return the current math equation.
     */
    String getEquation() {return equation;}

    /**
     * Creates a new math equation which replaces the previous one.
     */
    void newEquation(){generateEquation();}

    /**
     * Checks if the answer and response are the same. If they are, the score increases by 1. If
     * they are not, numLosses increases by 1.
     */
    void checkAnswer(){
        if (answer == response) {score += 1;}
        else { incrementNumLosses(); }
    }

    /**
     * Updates the response depending on the number pressed.
     * @param num the number of the button pressed
     */
    void updateResponse(int num) {response = response * 10 + num;}

    /**
     * Generates a random math question using addition, subtraction, integer division or
     * multiplication and sets the answer for it. The answer to subtraction questions are always
     * non-negative.
     */
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

        //String representation of the equation for the user
        equation = num1 + operators[op] + num2;
    }
}
