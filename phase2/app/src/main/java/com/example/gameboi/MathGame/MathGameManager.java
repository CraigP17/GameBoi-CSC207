package com.example.gameboi.MathGame;

import com.example.gameboi.UserClasses.User;

class MathGameManager implements Gameable{

    private int response = 0;
    private int numRounds = 0;
    private int numLosses = 0;
    private int maxLosses = 3;
    private boolean foundHiddenFeature = false;
    private int score;
    private boolean winner = false;
    private MathEquation equation = new MathEquation();
    private User player;

    MathGameManager(User player) {
        this.player = player;
        score = player.getPoints();
    }

    private void checkHiddenFeature() {
        if (response == 12345 && ! foundHiddenFeature) {
            foundHiddenFeature = true;
            player.foundHiddenfeature();
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
//            loseLife();
        }
        clearResponse();
    }

//    private void loseLife(){
//        if (numLosses >= maxLosses) {player.loseALife();}
//    }

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

    void clearResponse(){
        response = 0;
    }

    @Override
    public boolean isWinner() {return winner;}

    @Override
    public int getLives() { return player.getLives();}

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getMultiplier() {
        return player.getMultiplier();
    }

    @Override
    public boolean isGameOver() {
        if (numRounds == 4 && numLosses != maxLosses) {
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

    @Override
    public User getPlayer() {return player;}

    @Override
    public String getPlayerIcon() {return player.getIcon();}

    @Override
    public int getBackgroundColor(){return player.getBackgroundColor();}
}
