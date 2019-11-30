package com.example.gameboi.MathGame;

import com.example.gameboi.UserClasses.User;

public abstract class GameFacade{
    public int score;
    public User player;
    public boolean foundHiddenFeature = false;
    public boolean winner = false;

    public GameFacade(User player) {
        this.player = player;
        score = player.getPoints();
    }

    public boolean getFoundHiddenFeature() {return foundHiddenFeature;}

    public void updateFoundHiddenFeature() {
        foundHiddenFeature = true;
        player.foundHiddenfeature();
    }

    abstract boolean isGameOver();

    public String getPlayerIcon() {return player.getIcon();}

    public int getScore() { return score;}

    public int getMultiplier() {return player.getMultiplier();}

    public int getLives() {return player.getLives();}

    public User getPlayer() {return player;}

    public boolean isWinner() {return winner;}

    public int getBackgroundColor(){return player.getBackgroundColor();}

}
