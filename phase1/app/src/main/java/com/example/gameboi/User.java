package com.example.gameboi;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

class User {
    /*This class is responsible for storing the user data for a game.
     * It stores the users username, points, lives and customization preferences*/

    private String name;

    private int lives;

    private int levelOnePoints;

    private int levelTwoPoints;
    //List stores only 2 values, [#games played, lost]
    private int[] FlashColors = {0, 0};

    private int levelThreePoints;

    private Paint backgroundColor;

    private String icon; //string icon

    private int currLevel;

    User(String name, int lives, int levelOnePoints, int levelTwoPoints, int levelThreePoints,
         Paint backgroundColor, String icon, int currLevel) {
        this.name = name;
        this.lives = lives;
        this.levelOnePoints = levelOnePoints;
        this.levelTwoPoints = levelTwoPoints;
        this.levelThreePoints = levelThreePoints;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
        this.currLevel = currLevel;

    }

    void loseALife() {
        lives--;
    }

    int getLives() {
        return lives;
    }

    /*The following method will get the number of games played within the FlashColors game*/
    int getFCGamesPlayed() {
        return this.FlashColors[0];
    }

    /*The following method will get the number of games that were lost within FLashColors*/
    int getFCGamesLost() {
        return this.FlashColors[1];
    }
    /*This method will return the local score for a user playing FlashColors*/
    int getFCUserScore() {
        return levelTwoPoints;
    }

    /*The following method will get the number of games played within the FlashColors game*/
    void setFCGamesPlayed(int played) {
        this.FlashColors[0] = played;
    }

    /*The following method will get the number of games that were lost within FLashColors*/
    void setFCGamesLost(int lost) {
        this.FlashColors[1] = lost;
    }
    /*This method will return the local score for a user playing FlashColors*/
    void setFCUserScore(int score) {
        this.levelTwoPoints = score; // score increases here
    }
}
