package com.example.gameboi;

import android.widget.TextView;

import java.util.Random;

public class MathGameManager {

    User player;

    // int representation of user's response.
    private int response = 0;
    //int representation of the user's answer.
    private int answer = 0;
    // The number of rounds played. Game ends when either 10 rounds have been played or the player
    // loses 3 times
    private int numRounds = 0;
    //The number of questions the player got wrong
    private int numLosses = 0;
    //int representation of the number of questions the user has answered correctly.
    private int score = 0;
    Random rand = new Random();

    MathGameManager(User player) {
        this.player = player;
    }

    int getResponse() {return response;}
    void setResponse(int newResponse) {response = newResponse;}

}
