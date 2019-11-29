package com.example.gameboi.MathGame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.ScorePages.FlashLoss;
import com.example.gameboi.ScorePages.FlashWin;

import androidx.appcompat.app.AppCompatActivity;

abstract class GameActivity extends AppCompatActivity {

    TextView scoreboard;
    TextView multiplier;
    ImageView lifeOne;
    ImageView lifeTwo;
    ImageView lifeThree;
    GameFacade gameFacade;
    int icon;

    void updateScoreBoard() {
        String scoreToDisplay = "Score: " + gameFacade.getScore();
        scoreboard.setText(scoreToDisplay);
    }

    void updateLivesIcon(){
        lifeOne.setImageResource(icon);
        lifeTwo.setImageResource(icon);
        lifeThree.setImageResource(icon);
    }

    void updateBackgroundColor(){
        getWindow().getDecorView().setBackgroundColor(gameFacade.getBackgroundColor());
    }

    void updateLives() {
        int numLives = gameFacade.getLives();
        if (numLives <= 2) {lifeThree.setImageAlpha(0);}
        if (numLives <= 1) {lifeTwo.setImageAlpha(0);}
        if (numLives == 0) {lifeOne.setImageAlpha(0);}
    }

    void updateMultiplier() {
        String multiplierToDisplay = "Multiplier: x" + gameFacade.getMultiplier();
        multiplier.setText(multiplierToDisplay);
    }

    boolean isGameOver() {return gameFacade.isGameOver();}

    void toNext() {
        if (gameFacade.isWinner()) {goToWinScreen();}
        else{goToLoseScreen();}
    }

    void goToWinScreen() {
        Intent intent = new Intent(this, FlashLoss.class);
        intent.putExtra("player", gameFacade.getPlayer());
        startActivity(intent);
    }

    void goToLoseScreen() {
        Intent intent = new Intent(this, FlashWin.class);
        intent.putExtra("player", gameFacade.getPlayer());
        startActivity(intent);
    }

    void updateDisplay(){
        updateScoreBoard();
        updateLives();
        updateMultiplier();
    }

    void setupDisplay() {
        updateBackgroundColor();
        updateLivesIcon();
        updateDisplay();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    }
