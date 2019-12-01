package com.example.gameboi.Games.MathGame;

import java.util.Random;

class MathEquation {

    private String equation;
    private Random rand = new Random();
    private int answer;

    String getEquation(){return equation;}

    boolean isAnswerCorrect(int response) {return response == answer;}

    void getEasyEquation(){
        generateEasyEquation();
    }

    void getHardEquation() {
        generateHardEquation();
    }

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