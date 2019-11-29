package com.example.gameboi.MathGame;

import com.example.gameboi.UserClasses.User;

abstract class GameFacade {
    Gameable gameManager;

    boolean isGameOver() {return gameManager.isGameOver();}

    String getPlayerIcon() {return gameManager.getPlayerIcon();}

    int getScore() { return gameManager.getScore();}

    int getMultiplier() {return gameManager.getMultiplier();}

    int getLives() {return gameManager.getLives();}

    User getPlayer() {return gameManager.getPlayer();}

    boolean isWinner() {return gameManager.isWinner();}

    int getBackgroundColor(){return gameManager.getBackgroundColor();}

}
