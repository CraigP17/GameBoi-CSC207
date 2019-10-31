package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import android.os.Bundle;

import java.util.HashMap;

public class RpSWonRoundDisplay extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_swon_round_display);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String userChoiceDisplay = intent.getStringExtra("userchoice");
        String cChoiceDisplay = intent.getStringExtra("computerchoice");
        player = getIntent().getParcelableExtra("player");

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

    public void continueGame(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
