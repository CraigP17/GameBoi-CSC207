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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class RockPaperScissors extends AppCompatActivity {

    public static int winsRpS = 0;
    public static int lossesRpS = 0;
    String[] arr = new String[] {"Rock", "Paper", "Scissors"};
    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        player = getIntent().getParcelableExtra("player");

        ImageView icon = findViewById(R.id.imageView);
        int resID = getResources().getIdentifier(player.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);

        TextView scoreboardRpS = findViewById(R.id.textView12);
        scoreboardRpS.setText(String.valueOf(winsRpS + player.getLevelOnePoints() + player.getLevelTwoPoints()));

        //Setting up the background Colour
        View colour = findViewById(R.id.textView3); //finds random view
        View Root = colour.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
    }

    private HashMap buildMap() {
        HashMap<String, String> winnersRpS = new HashMap<>();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");
        return winnersRpS;
    }

    public void RpSGamePlayed(String playerValue) {
        HashMap<String, String> winnersRpS = buildMap();
        
        Random rand = new Random();
        //if this button is for rock
        String computerchoice = arr[rand.nextInt(arr.length)];
        if (winnersRpS.get(playerValue).equals(computerchoice)) {
            //user wins, do add to wins
            winsRpS += 1;
            System.out.println("W:");
            System.out.println(winsRpS);
            checker("won", playerValue, computerchoice);
        } else if (computerchoice.equals(playerValue)) {
            //to take into account number of games played
            checker("tie", playerValue, computerchoice);
        } else  {
            //comp wins, add to losses
            lossesRpS += 1;
            System.out.println("L:");
            System.out.println(lossesRpS);
            checker("lost", playerValue, computerchoice);
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

    private void checker(String outcome, String userchoice, String compchoice) {
        if (lossesRpS == 2) {
            System.out.println("Losses");
            if (player.getLives() == 1) {
                // go to 'you lost the game' screen
                Intent intent = new Intent(this, FlashLoss.class);
                intent.putExtra("player", player);
                player.setLevelThreePoints(winsRpS);
                startActivity(intent);
            } else {
                // go to 'you won the game' screen
                Intent intent = new Intent(this, FlashWin.class);
                intent.putExtra("player", player);
                player.setLevelThreePoints(winsRpS);
                startActivity(intent);
            }
        } else if (winsRpS == 3) {
            System.out.println("wins");
                // go to you won the game screen
                Intent intent = new Intent(this, FlashWin.class);
                intent.putExtra("player", player);
                player.setLevelThreePoints(winsRpS);
                startActivity(intent);
        } else {
            if (outcome.equals("won")) {
                Intent intent = new Intent(this, RpSWonRoundDisplay.class);
                intent.putExtra("userchoice", userchoice);
                intent.putExtra("computerchoice", compchoice);
                intent.putExtra("player", player);
                startActivity(intent);
            } else if (outcome.equals("lost")) {
                //go to you lost this round screen
                Intent intent = new Intent(this, RpsLostRoundDisplay.class);
                intent.putExtra("userchoice", userchoice);
                intent.putExtra("computerchoice", compchoice);
                intent.putExtra("player", player);
                startActivity(intent);
            } else {
                // new intent that displays try again
                Intent intent = new Intent(this, tryAgainDisplay.class);
                intent.putExtra("userchoice", userchoice);
                intent.putExtra("computerchoice", compchoice);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        }
    }
}
