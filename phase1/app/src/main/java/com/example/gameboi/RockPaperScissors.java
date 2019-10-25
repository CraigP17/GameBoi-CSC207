package com.example.gameboi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
    public String[] arr = new String[] {"Rock", "Paper", "Scissors"};
    User user;
    int wins = 0;
    int losses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
    }
    // get a constructor??, add manager
    RockPaperScissors(User user) {
        this.user = user;
    }

    public void RpSGamePlayed(View view) {
        HashMap winnersRpS = new HashMap();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");

        Random rand = new Random();
        //if this button is for rock
        String userchoice = "Rock";
        String computerchoice = arr[rand.nextInt(arr.length)];
        if (winnersRpS.get(computerchoice).equals(userchoice)) {
            //user wins, do add to wins
            wins++;
        } else if (computerchoice.equals(userchoice)) {
            wins++; //to take into account number of games played
        } else if (!winnersRpS.get(computerchoice).equals(userchoice)) {
            //comp wins, add to losses
            losses++;
        }
        //call checker, where then either goes to final page or reverts to this page


        Intent intent = new Intent(this, RpSWonRoundDisplay.class);
//        String message = "You have won this round!";
//        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }

    private void checker(boolean outcome) {
        if (losses == 2) {
            if (user.getLives() == 1) {
                // go to 'you lost the game' screen
            } else {
                // go to 'you wont the game' screen
            }
        } else if (wins + losses == 5) {
                // go to you won the game screen
        } else {
            if (outcome) {
                //go to you won this round screen
            } else {
                //go to you lost this round screen
            }
        }
    }
}
