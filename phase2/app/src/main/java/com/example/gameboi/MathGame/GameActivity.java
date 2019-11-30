package com.example.gameboi.MathGame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.ScorePages.LevelResults;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GameActivity extends AppCompatActivity {

    public TextView scoreboard;
    public TextView multiplier;
    public ImageView lifeOne;
    public ImageView lifeTwo;
    public ImageView lifeThree;
    public GameFacade gameFacade;
    public int icon;

    public void updateScoreBoard() {
        String scoreToDisplay = "Score: " + gameFacade.getScore();
        scoreboard.setText(scoreToDisplay);
    }

    public void updateLivesIcon(){
        lifeOne.setImageResource(icon);
        lifeTwo.setImageResource(icon);
        lifeThree.setImageResource(icon);
    }

    public void updateBackgroundColor(){
        getWindow().getDecorView().setBackgroundColor(gameFacade.getBackgroundColor());
    }

    public void updateLives() {
        int numLives = gameFacade.getLives();
        if (numLives <= 2) {lifeThree.setImageAlpha(0);}
        if (numLives <= 1) {lifeTwo.setImageAlpha(0);}
        if (numLives == 0) {lifeOne.setImageAlpha(0);}
    }

    public void updateMultiplier() {
        String multiplierToDisplay = "Multiplier: x" + gameFacade.getMultiplier();
        multiplier.setText(multiplierToDisplay);
    }

    public boolean isGameOver() {return gameFacade.isGameOver();}

    public void toNext() {
        Intent intent = new Intent(this, LevelResults.class);
        intent.putExtra("player", gameFacade.getPlayer());
        if (gameFacade.isWinner()) {
            intent.putExtra("success", true);
        } else {
            intent.putExtra("success", false);
        }
        startActivity(intent);
    }

    public void updateDisplay(){
        updateScoreBoard();
        updateLives();
        updateMultiplier();
    }

    public void setupDisplay() {
        updateBackgroundColor();
        updateLivesIcon();
        updateDisplay();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    }
