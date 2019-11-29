package com.example.gameboi.MathGame;

import android.app.Activity;
import android.content.Intent;

import com.example.gameboi.ScorePages.FlashLoss;

abstract class GameFacade {
    GameDisplay gameDisplay;
    Gameable gameManager;


    private void updateScoreboard() {
        gameDisplay.updateScoreBoard(gameManager.getScore());
    }

    private void updateLives() {
        gameDisplay.updateLives(gameManager.getLives());
    }

    private void updateMultiplier() {
        gameDisplay.updateMultiplier(gameManager.getMultiplier());
    }

    void updateDisplay(){
        updateScoreboard();
        updateLives();
        updateMultiplier();
    }

    boolean isGameOver() {return gameManager.isGameOver();}

    String getPlayerIcon() {return gameManager.getPlayerIcon();}

    void updateLivesIcon() {gameDisplay.updateLivesIcon();}

}
