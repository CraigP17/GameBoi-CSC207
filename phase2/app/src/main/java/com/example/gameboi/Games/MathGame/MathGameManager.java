package com.example.gameboi.Games.MathGame;

import com.example.gameboi.Games.GameFacade;
import com.example.gameboi.UserClasses.User;

class MathGameManager extends GameFacade {

    // Int of the players input so far
    private int response = 0;
    //The number of rounds the player has played so far
    private int numRounds = 0;
    //The number of losses the player has had
    private int numLosses = 0;
    //The class which generates the equations for the player to answer
    private MathEquation equationGenerator;

    /**
     * Sets the player to the current player and sets equation to a new MathEquation if the player
     * difficulty is "Normal" or a new MathEquationHard if the playerDifficulty is
     *
     * @param player the current user
     */
    MathGameManager(User player) {
        super(player);
        if (player.getDifficulty().equals("Normal")) {
            equationGenerator = new MathEquation();
        } else if (player.getDifficulty().equals("Hard")) {
            equationGenerator = new MathEquationHard();
        }
    }

    @Override
    public boolean checkHidden() {
        if (response == 12345 && !foundHiddenFeature) {
            setFoundHiddenFeature();
            return true;
        }
        return false;
    }

    /**
     * @return the number the user has inputted so far
     */
    int getResponse() {
        checkHidden();
        return response;
    }

    /**
     * Increments numRounds by 1. If the answers is correct, the score is increased by one, else the
     * numLosses increases by one. Resets response view to 0.
     */
    private void submitInput() {
        numRounds += 1;
        if (equationGenerator.isAnswerCorrect(response)) {
            incrementScore();
        } else {
            numLosses += 1;
        }
        clearResponse();
    }

    /**
     * Updates the response to add the digit the player pressed to the end of response
     *
     * @param num number of the button the player pressed
     */
    private void updateResponse(int num) {
        response = response * 10 + num;
    }

    /**
     * Generates a new equation for the player to answer.
     */
    private void newEquation() {
        equationGenerator.generateEquation();
    }

    /**
     * @return String of the current equation to answer
     */
    String getEquation() {
        //Creates equation for the first round
        if (equationGenerator.getEquation() == null) {
            newEquation();
        }
        return equationGenerator.getEquation();
    }

    /**
     * Checks to make sure that the response does not exceed 100000
     *
     * @param num the number pressed by the player
     */
    void clickNumButton(int num) {
        if (response < 100000) {
            updateResponse(num);
        }
    }

    /**
     * Submits the user's input to check against the answer and update score and lives. Generates
     * a new equation.
     */
    void pressEnter() {
        submitInput();
        newEquation();
    }

    /**
     * Resets response to 0.
     */
    void clearResponse() {
        response = 0;
    }

    /**
     * If the number of rounds is 5 and the player hasn't lost 3 times, sets winner to true, updates
     * the player's point and returns true. If numLosses is 3, sets player's points and returns
     * true. Otherwise returns false.
     *
     * @return true if game is over and false otherwise
     */
    public boolean isGameOver() {
        int maxLosses = 3;
        if (numRounds == 5 && numLosses != maxLosses) {
            winner = true;
            setScore(score);
            return true;
        } else if (numLosses == maxLosses) {
            winner = false;
            setScore(score);
            return true;

        }
        return false;
    }
}
