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

    public boolean isGameOver() {return false;}

    public String getPlayerIcon() {return player.getIcon();}

    public int getScore() { return score;}

    public int getMultiplier() {return player.getMultiplier();}

    public int getLives() {return player.getLives();}

    public User getPlayer() {return player;}

    public boolean isWinner() {return winner;}

    public int getBackgroundColor(){return player.getBackgroundColor();}

    public void setFoundHiddenFeature() {
        this.foundHiddenFeature = true;
        player.foundHiddenfeature();
    }

    public boolean checkHidden() {return false;}

    public boolean getFoundHiddenFeature() { return this.foundHiddenFeature; }

    public void incrementScore() {this.score++;}

    /*This method will return the local score for a user playing FlashColorsOperations*/
    public void setScore(int score) {
        player.setPoints(score);
    }

}
