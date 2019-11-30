package com.example.gameboi.MathGame;

import com.example.gameboi.UserClasses.User;

abstract class GameFacade{
    int score;
    User player;
    boolean foundHiddenFeature = false;
    boolean winner = false;

    GameFacade(User player) {
        this.player = player;
        score = player.getPoints();
    }

    public boolean isGameOver() {return false;}

    public String getPlayerIcon() {return player.getIcon();}

    public int getScore() { return score;}

    public int getMultiplier() {return player.getMultiplier();}

    public int getLives() {return player.getLives();}

    public User getPlayer() {return player;}

    public boolean isWinner() {return winner;}

    public int getBackgroundColor(){return player.getBackgroundColor();}

}
