package com.example.gameboi.MathGame;

import com.example.gameboi.UserClasses.User;

public interface Gameable {
    int getLives();
    String getPlayerIcon();
    int getScore();
    int getMultiplier();
    boolean isGameOver();
    boolean isWinner();
    User getPlayer();
    int getBackgroundColor();
}
