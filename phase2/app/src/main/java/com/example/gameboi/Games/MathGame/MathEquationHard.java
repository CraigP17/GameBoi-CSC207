package com.example.gameboi.Games.MathGame;

class MathEquationHard extends MathEquation {

    MathEquationHard() {
        super();
    }

    /**
     * Harder version of Generate equation. Has the normal equation in brackets then adds or
     * multiplies or divides by a new number.
     */
    @Override
    void generateEquation() {
        super.generateEquation();
        String[] operators = {" + ", " // ", " * "};
        int num = rand.nextInt(10) + 1;
        int op = rand.nextInt(3);

        if (op == 0) {
            answer = answer + num;
        } else if (op == 1) {
            answer = answer / num;
        } else {
            answer = answer * num;
        }

        equation = "(" + equation + ")" + operators[op] + num;

    }

}
