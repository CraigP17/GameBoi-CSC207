package com.example.gameboi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class RockPaperScissors extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.gameboi.MESSAGE";
    public int losses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
    }

    public void checker() {

    }

    public void RpSGamePlayed(String playerValue) {

        // Creating a map to store winning combination of moves
        HashMap winnersRpS = new HashMap();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");


        // Generating a random value from keys to be the computers move
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(2);
        List keys = new ArrayList(winnersRpS.keySet());
        Object ourValue = keys.get(randomInt);
        System.out.println(ourValue);

        if (winnersRpS.get(playerValue) == ourValue) {
            Intent intent = new Intent(this, RpSWonRoundDisplay.class);
//        String message = "You have won this round!";
//        intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else if(winnersRpS.get(ourValue) == playerValue) {
            // create new intent that will display you lost this round screen
            Intent intent = new Intent(this, RpsLostRoundDisplay.class);
            startActivity(intent);
        } else {
            // new intent that displays try again
            Intent intent = new Intent(this, tryAgainDisplay.class);
            startActivity(intent);
        }

    }

    public void Rock(View view) {
        RpSGamePlayed("Rock");

    }

    public void Paper(View view) {
        RpSGamePlayed("Paper");

    }

    public void Scissors(View view) {
        RpSGamePlayed("Scissors");

    }
}

