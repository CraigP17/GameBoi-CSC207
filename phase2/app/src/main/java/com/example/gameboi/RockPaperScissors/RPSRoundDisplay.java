package com.example.gameboi.RockPaperScissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

public class RPSRoundDisplay extends AppCompatActivity {

    private User player;
    String userChoiceDisplay;
    String cChoiceDisplay;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps_round_display);

        setVars();
        setBackgroundColour();
        setImages();
        setAnnouncement();
    }

    private void setBackgroundColour() {
        View colour = findViewById(R.id.textView14); //finds random view
        View Root = colour.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
    }

    private void setImages() {
        ImageView uChoice = findViewById(R.id.imageView4);
        ImageView panda = findViewById(R.id.imageView3);


        if (cChoiceDisplay.equals("Rock")) {
            panda.setImageResource(R.drawable.rock);
        } else if (cChoiceDisplay.equals("Paper")) {
            panda.setImageResource(R.drawable.paper);
        } else if (cChoiceDisplay.equals("Scissors")) {
            panda.setImageResource(R.drawable.scissors);
        } else if (cChoiceDisplay.equals("Lizard")) {
            panda.setImageResource(R.drawable.lizard);
        } else if (cChoiceDisplay.equals("Spock")) {
            panda.setImageResource(R.drawable.spock);
        }



        if (userChoiceDisplay.equals("Rock")) {
            uChoice.setImageResource(R.drawable.rock);
        } else if (userChoiceDisplay.equals("Paper")) {
            uChoice.setImageResource(R.drawable.paper);
        } else if (userChoiceDisplay.equals("Scissors")) {
            uChoice.setImageResource(R.drawable.scissors);
        } else if (userChoiceDisplay.equals("Lizard")) {
            uChoice.setImageResource(R.drawable.lizard);
        } else if (userChoiceDisplay.equals("Spock")) {
            uChoice.setImageResource(R.drawable.spock);
        }
    }

    private void setAnnouncement() {
        TextView announce = (TextView) findViewById(R.id.textView4);

        if (result.equals("Won")) {
            announce.setText("You have won this round! Press Continue to play again.");
        } else if (result.equals("Loss")) {
            announce.setText("You have lost this round! Press Continue to play again.");
        } else {
            announce.setText("No one won this round! Press Continue to play again.");
        }
    }

    private void setVars() {
        Intent intent = getIntent();
        userChoiceDisplay = intent.getStringExtra("userchoice");
        cChoiceDisplay = intent.getStringExtra("computerchoice");
        player = intent.getParcelableExtra("player");
        result = intent.getStringExtra("result");
    }

    public HashMap buildMap() {
        HashMap<String, String> winnersRpS = new HashMap<>();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");
        return winnersRpS;
    }

    public void continueGame(View view) {
        Intent intent = new Intent(this, RPSActivity.class);
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
