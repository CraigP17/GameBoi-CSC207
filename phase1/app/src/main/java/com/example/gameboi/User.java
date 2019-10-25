package com.example.gameboi;

import android.graphics.Paint;

import java.util.ArrayList;

class User {
/*This class is responsible for storing the user data for a game.
* It stores the users username, points, lives and customization preferences*/

    private String name;

    private int lives;

    private int levelOnePoints;

    private int levelTwoPoints;

    private int levelThreePoints;

    private Paint backgroundColor = new Paint();

    private String icon; //string icon

    private int currLevel;

    User(String name, int lives, int levelOnePoints, int levelTwoPoints, int levelThreePoints,
         Paint backgroundColor, String icon, int currLevel){
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


}
