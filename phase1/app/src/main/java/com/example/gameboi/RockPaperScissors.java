package com.example.gameboi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Random;

public class RockPaperScissors extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.gameboi.MESSAGE";
    int wins = 0;
    int losses = 0;
    String[] arr = new String[] {"Rock", "Paper", "Scissors"};
    Paint p1 = new Paint();
    User user = new User("faf", 1, 0, 0 ,0, Color.WHITE, "fds", '0');

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
    }

    public void RpSGamePlayed(String playerValue) {
        HashMap winnersRpS = new HashMap();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");

        Random rand = new Random();
        //if this button is for rock
        String computerchoice = arr[rand.nextInt(arr.length)];
        if (winnersRpS.get(playerValue).equals(computerchoice)) {
            //user wins, do add to wins
            wins++;
            checker("won", playerValue, computerchoice);
        } else if (computerchoice.equals(playerValue)) {
            //to take into account number of games played
            checker("tie", playerValue, computerchoice);
        } else  {
            //comp wins, add to losses
            losses++;
            checker("lost", playerValue, computerchoice);
        }

        //call checker, where then either goes to final page or reverts to this page

        // Generating a random value from keys to be the computers move
//        Random randomGenerator = new Random();
//        int randomInt = randomGenerator.nextInt(2);
//        List keys = new ArrayList(winnersRpS.keySet());
//        Object ourValue = keys.get(randomInt);
//        System.out.println(ourValue);
//
//        if (winnersRpS.get(playerValue) == ourValue) {
//            Intent intent = new Intent(this, RpSWonRoundDisplay.class);
////        String message = "You have won this round!";
////        intent.putExtra(EXTRA_MESSAGE, message);
//            startActivity(intent);
//        } else if(winnersRpS.get(ourValue) == playerValue) {
//            // create new intent that will display you lost this round screen
//            Intent intent = new Intent(this, RpsLostRoundDisplay.class);
//            startActivity(intent);
//        } else {
//            // new intent that displays try again
//            Intent intent = new Intent(this, tryAgainDisplay.class);
//            startActivity(intent);
//        }

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

    private void checker(String outcome, String userchoice, String compchoice) {
        if (losses == 2) {
            if (user.getLives() == 1) {
                // go to 'you lost the game' screen
                Intent intent = new Intent(this, RpsFinalLostDisplay.class);
                startActivity(intent);
            } else {
                // go to 'you won the game' screen
                Intent intent = new Intent(this, RpsFinalWonDisplay.class);
                startActivity(intent);
            }
        } else if (wins == 3) {
                // go to you won the game screen
                Intent intent = new Intent(this, RpsFinalWonDisplay.class);
                startActivity(intent);
        } else {
            if (outcome.equals("won")) {
                Intent intent = new Intent(this, RpSWonRoundDisplay.class);
                startActivity(intent);
            } else if (outcome.equals("lost")) {
                //go to you lost this round screen
                Intent intent = new Intent(this, RpsLostRoundDisplay.class);
                startActivity(intent);
            } else {
                // new intent that displays try again
                Intent intent = new Intent(this, tryAgainDisplay.class);
                startActivity(intent);
            }
        }
    }
}
