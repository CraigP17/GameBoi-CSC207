package com.example.gameboi.MathGame;

public interface Gameable {
    int getLives();
    int getScore();
    int getMultiplier();
    boolean isGameOver();
    boolean isWinner();
}
