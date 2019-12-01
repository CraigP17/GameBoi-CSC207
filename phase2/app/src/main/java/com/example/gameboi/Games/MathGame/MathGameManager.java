package com.example.gameboi.Games.MathGame;

import com.example.gameboi.Games.GameFacade;
import com.example.gameboi.UserClasses.User;

class MathGameManager extends GameFacade {

    private int response = 0;
    private int numRounds = 0;
    private int numLosses = 0;
    private MathEquation equation = new MathEquation();

    MathGameManager(User player) {
        super(player);
    }

    private void checkHiddenFeature() {
        if (response == 12345 && ! foundHiddenFeature) {
            updateFoundHiddenFeature();
        }
    }

    int getResponse() {
        checkHiddenFeature();
        return response;
    }

    void submitInput(){
        numRounds += 1;
        if (equation.isAnswerCorrect(response)) {score += 1;}
        else {
            numLosses += 1;
        }
        clearResponse();
    }

    private void updateResponse(int num) {response = response * 10 + num;}

    void newEquation() {
        if (player.getDifficulty().equals("Normal")) {
            equation.getEasyEquation();
        }
        else {
            equation.getHardEquation();
        }
    }

    String getEquation() {
        //Creates equation for the first round
        if (equation.getEquation() == null) {newEquation();}
        return equation.getEquation();
    }

    void clickNumButton(int num) {
        if (response < 100000) {updateResponse(num);}
    }

    void pressEnter(){
        submitInput();
        newEquation();
    }

    void clearResponse(){
        response = 0;
    }

    public boolean isGameOver() {
        int maxLosses = 3;
        if (numRounds == 5 && numLosses != maxLosses) {
            winner = true;
            player.setPoints(score);
            return true;
        }
        else if (numLosses == maxLosses) {
            winner = false;
            player.setPoints(score);
            return true;

        }
        return false;
    }
}
