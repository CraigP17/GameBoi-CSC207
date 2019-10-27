package com.example.gameboi;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Collections;

/*The following class is responsible for storing the user playing the FlashColors as well as the
* score during the game and the correct color pattern and user color patterns. This class acts as
* the back end to SimonGame.java*/
class FlashColors {

    private User player;
    private boolean finishedDisplay = false;
    private ArrayList<Integer> correctPattern = new ArrayList<>();
    private ArrayList<Integer> userPattern;
    private int localScore = 0; //set to zero for now

    FlashColors(User player) {
        this.player = player;
    }

    ArrayList<Integer> generatePattern() {
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);

        Collections.shuffle(pattern);
        correctPattern = pattern;

        return pattern;
    }

    public ArrayList<Integer> getCorrectPattern() {
        return correctPattern;
    }

    public boolean isFinishedDisplay() {
        return finishedDisplay;
    }

    public void setFinishedDisplay(boolean finishedDisplay) {
        this.finishedDisplay = finishedDisplay;
    }

    public boolean isCorrect(ArrayList<Integer> userPatterns) {
        setUserPattern(userPatterns);
        return correctPattern.equals(userPattern);
    }


    public void setUserPattern(ArrayList<Integer> userPatterns) {
        this.userPattern = userPatterns;
    }

    int getLocalScore() {
        return localScore;
    }

    void setLocalScore(int localScore) {
        this.localScore += localScore;
    }
}
