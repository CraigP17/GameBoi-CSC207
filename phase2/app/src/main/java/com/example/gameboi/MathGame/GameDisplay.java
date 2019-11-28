package com.example.gameboi.MathGame;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

abstract class GameDisplay {
    TextView scoreboard;
    TextView multiplier;
    ImageView lifeOne;
    ImageView lifeTwo;
    ImageView lifeThree;

    void updateScoreBoard(int score) {
        String scoreToDisplay = "Score: " + score;
        scoreboard.setText(scoreToDisplay);
    }

    void updateLives(int numLives) {
        if (numLives <= 2) {lifeThree.setImageAlpha(0);}
        if (numLives <= 1) {lifeTwo.setImageAlpha(0);}
        if (numLives == 0) {lifeOne.setImageAlpha(0);}
    }

    void updateMultiplier(int num) {
        String multiplierToDisplay = "x" + num;
        multiplier.setText(multiplierToDisplay);
    }

}
