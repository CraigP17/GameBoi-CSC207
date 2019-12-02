package com.example.gameboi.Games.RockPaperScissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

/**
 * Displays user and computer choice and displays to user if they have lost, tied or won this round.
 */
public class RPSRoundDisplay extends AppCompatActivity {

    private User player;
    /**
     * User's choice
     */
    String userChoiceDisplay;
    /**
     * Computers's choice
     */
    String cChoiceDisplay;
    /**
     * result of round, "Won", "Tied" or "Lost".
     */
    String result;

    /**
     * Sets all variables, background colour, images and text if they won lost or tied this round
     */
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
        ImageView cChoice = findViewById(R.id.imageView3);


        if (cChoiceDisplay.equals("Rock")) {
            cChoice.setImageResource(R.drawable.rock);
        } else if (cChoiceDisplay.equals("Paper")) {
            cChoice.setImageResource(R.drawable.paper);
        } else if (cChoiceDisplay.equals("Scissors")) {
            cChoice.setImageResource(R.drawable.scissors);
        } else if (cChoiceDisplay.equals("Lizard")) {
            cChoice.setImageResource(R.drawable.lizard);
        } else if (cChoiceDisplay.equals("Spock")) {
            cChoice.setImageResource(R.drawable.spock);
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
        TextView announce = findViewById(R.id.textView4);

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

    /**
     * When continue is pushed, takes you back to main RPS activity display.
     */
    public void continueGame(View view) {
        Intent intent = new Intent(this, RPSActivity.class);
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
