package com.example.gameboi.RockPaperScissors;

import androidx.annotation.StringRes;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_swon_round_display);

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
        }
        if (cChoiceDisplay.equals("Paper")) {
            panda.setImageResource(R.drawable.paper);
        }
        if (cChoiceDisplay.equals("Scissors")) {
            panda.setImageResource(R.drawable.scissors);
        }


        if (userChoiceDisplay.equals("Rock")) {
            uChoice.setImageResource(R.drawable.rock);
        }
        if (userChoiceDisplay.equals("Paper")) {
            uChoice.setImageResource(R.drawable.paper);
        }
        if (userChoiceDisplay.equals("Scissors")) {
            uChoice.setImageResource(R.drawable.scissors);
        }
    }

    private void setAnnouncement() {
        TextView announce = (TextView) findViewById(R.id.textView4);

        HashMap hash = buildMap();
        if (hash.get(userChoiceDisplay).equals(cChoiceDisplay)) {
            announce.setText("You have won this round! Press Continue to play again.");
        } else if (!userChoiceDisplay.equals(cChoiceDisplay)) {
            announce.setText("You have lost this round! Press Continue to play again.");
        } else {
            announce.setText("No one won this round! Press Continue to play again.");
        }
    }

    private void setVars() {
        Intent intent = getIntent();
        userChoiceDisplay = intent.getStringExtra("userchoice");
        cChoiceDisplay = intent.getStringExtra("computerchoice");
        player = getIntent().getParcelableExtra("player");
    }

    public HashMap buildMap() {
        HashMap<String, String> winnersRpS = new HashMap<>();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");
        return winnersRpS;
    }

    public void continueGame(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
