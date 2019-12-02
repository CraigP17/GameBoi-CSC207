package com.example.gameboi.Games.MathGame;

import java.util.Random;

class MathEquation {

    //String representation of the
    private String equation;
    // Random number generator
    private Random rand = new Random();
    // The answer to the equation.
    private int answer;

    /**
     *
     * @return String equation
     */
    String getEquation(){return equation;}

    /**
     *
     * @param response the int input from the player
     * @return true if the response is the correct answer and false otherwise
     */
    boolean isAnswerCorrect(int response) {return response == answer;}

    //TODO: make only one get equation and use inheritance.
    void getEasyEquation(){
        generateEasyEquation();
    }

    void getHardEquation() {
        generateHardEquation();
    }

    /**
     * Sets an equation to be string of a simple arithmetic (+, -, *, //) equation. Sets answer to
     * the answer of the equation. All division is integer division and the answer cannot be a
     * negative number.
     */
    private void generateEasyEquation() {
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

    private void generateHardEquation() {
        generateEasyEquation();
        String[] operators = {" + ", " // ", " * "};
        int num = rand.nextInt(10) + 1;
        int op = rand.nextInt(3);

        if (op == 0) {answer = answer + num;}
        else if (op == 1) {answer = answer / num;}
        else {answer = answer * num;}

        equation = "(" + equation + ")" + operators[op] + num;

    }
}