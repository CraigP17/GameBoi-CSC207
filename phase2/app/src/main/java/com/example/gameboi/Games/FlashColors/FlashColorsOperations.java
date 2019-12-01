package com.example.gameboi.Games.FlashColors;

import android.graphics.Color;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*The following class is responsible for storing the user playing the FlashColorsOperations as well as the
 * score during the game and the correct color pattern and user color patterns. This class acts as
 * the back end to FlashColorsActivity.java*/
class FlashColorsOperations {

    protected User player;
    boolean isSubmitted = true; //starts as true to allow initial pattern
    ArrayList<Integer> correctPattern;
    ArrayList<Integer> userPattern;
    ArrayList<Integer> special;

    /**
     * @param player the current player of FlashColors
     */
    FlashColorsOperations(User player) {
        this.player = player;
        userPattern = new ArrayList<>();
        correctPattern = new ArrayList<>();
        this.special = new ArrayList<>(Arrays.asList(Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW));
    }

    /**
     * @return a list of colours that have been randomly generated
     */
    ArrayList<Integer> generatePattern() {
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);

        Collections.shuffle(pattern);
        correctPattern = pattern;
        System.out.println(pattern);
        return pattern;
    }

    /**
     * @return return the pattern that has been generated
     */
    ArrayList<Integer> getCorrectPattern() {
        return correctPattern;
    }

    /**
     * @return true if the user has entered the correct pattern
     */
    boolean isCorrect() {
        return correctPattern.equals(userPattern);
    }

    /**
     * @param colour the users selected color
     */
    void addColour(int colour){
        userPattern.add(colour);
    }

    /**
     * Method responsible for clearing the users guess
     */
    void clearPattern(){
        userPattern.clear();
    }

    /**
     * @param submitted change the status of submitted
     */
    void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    /*This method is responsible for grabbing the current score, increasing its value by 1 and
     * returning a new charsequence*/
    int getNewScore(CharSequence c) {
        int score = Integer.parseInt(c.toString());
        score++;
        //setScore(score); //store the score of the game for an user
        return score;
    }

    /**
     * @return a colour pattern which FlashColorsActivity will use
     */
    ArrayList<Integer> DisplayColors(){
        ArrayList<Integer> pattern;
        if(isSubmitted){
            setSubmitted(false);
            pattern = generatePattern();
            return pattern;
        }
        pattern = getCorrectPattern();
        System.out.println("IM ON NORMAL GENERATE");
        return pattern;

    }

    /**
     * @return true if the user's inputted pattern is the same as the hidden feature
     */
    boolean checkHidden(){
        return userPattern.equals(special);
    }
}
