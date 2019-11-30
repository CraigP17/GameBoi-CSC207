package com.example.gameboi.FlashColors;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

class FlashColorsFacade {

    private User player;
    private FlashColorsOperations gameCalculations;

    FlashColorsFacade(User player){
        this.player = player;
        if(player.getDifficulty().equals("Hard")){
            gameCalculations = new FlashColorsOperationsHard(player);
        }
        else{
            gameCalculations = new FlashColorsOperations(player);
        }
    }

    boolean checkHidden(){
        return gameCalculations.checkHidden();
    }

    ArrayList<Integer> generatePattern() {
         return gameCalculations.generatePattern();
    }

    ArrayList<Integer> getCorrectPattern() {
        return gameCalculations.getCorrectPattern();
    }

    boolean isCorrect() {
        return gameCalculations.isCorrect();
    }

    boolean isSubmitted() {
        return gameCalculations.IsSubmitted();
    }

    void setSubmitted(boolean submitted) {
        gameCalculations.setSubmitted(submitted);
    }

    /*This method is responsible for grabbing the current score, increasing its value by 1 and
     * returning a new charsequence*/
    CharSequence getNewScore(CharSequence c) {
        return gameCalculations.getNewScore(c);
    }

    /*This method will return the local score for a user playing FlashColorsOperations*/
    void setScore(int score) {
        gameCalculations.setScore(score);
    }


    ArrayList<Integer> DisplayColors(){
        return gameCalculations.DisplayColors();
    }

    void addColour(int colour){
        gameCalculations.addColour(colour);
    }

    void clearPattern(){
        gameCalculations.clearPattern();
    }

    /**
     * @return the number of lives the User has
     */
    int getLives() {
        return player.getLives();
    }

    /**
     * @return the User's customized backgroundColor
     */
    int getBackgroundColor() {
        return player.getBackgroundColor();
    }

    /**
     * @return String value that represents logo file name
     */
    String getIcon() {
        return player.getIcon();
    }

    /**
     * @return The current amount of points a user has accumulated
     */
    int getPoints(){
        return player.getPoints();
    }

    /**
     * @return The users current multiplier
     */
    public int getMultiplier() {
        return player.getMultiplier();
    }

    public void setMultiplier(int multiplier) {
        player.setMultiplier(multiplier);
    }

    /**
     * @return the User's chosen game difficulty
     */
    String getDifficulty() { return player.getDifficulty(); }
}
