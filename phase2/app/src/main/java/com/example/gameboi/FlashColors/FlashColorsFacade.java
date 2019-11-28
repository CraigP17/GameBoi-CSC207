package com.example.gameboi.FlashColors;

import android.app.Activity;
import android.widget.TextView;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

class FlashColorsFacade {

    private FlashDisplay gameDisplay;
    private FlashColors gameCalculations;

    FlashColorsFacade(Activity activity, User player){
        gameDisplay = new FlashDisplay(activity,player);
        gameCalculations = new FlashColors(player);
    }

    ArrayList<Integer> generatePattern() {
         return gameCalculations.generatePattern();
    }

    ArrayList<Integer> getCorrectPattern() {
        return gameCalculations.getCorrectPattern();
    }

    boolean isCorrect(ArrayList<Integer> userPatterns) {
        return gameCalculations.isCorrect(userPatterns);
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

    /*This method will return the local score for a user playing FlashColors*/
    void setScore(int score) {
        gameCalculations.setScore(score);
    }

    TextView DispStartup(){
        gameDisplay.setIcon();
        gameDisplay.setMultiplier();
        gameDisplay.setLives();
        TextView scoreReference = gameDisplay.setScoreText();
        gameDisplay.setBackground();
        return scoreReference;
    }
}
