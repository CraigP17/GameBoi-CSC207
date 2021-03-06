package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tryAgainDisplay extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_again_display);

        Intent intent = getIntent();
        String userChoiceDisplay = intent.getStringExtra("userchoice");
        String cChoiceDisplay = intent.getStringExtra("computerchoice");
        player = getIntent().getParcelableExtra("player");
        //Setting up the background Colour
        View colour = findViewById(R.id.textView6); //finds random view
        View Root = colour.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color

        ImageView uChoice = findViewById(R.id.imageView6);
        ImageView cChoice = findViewById(R.id.imageView7);

        if (cChoiceDisplay.equals("Rock")) {
            cChoice.setImageResource(R.drawable.rock);
        }
        if (cChoiceDisplay.equals("Paper")) {
            cChoice.setImageResource(R.drawable.paper);
        }
        if (cChoiceDisplay.equals("Scissors")) {
            cChoice.setImageResource(R.drawable.scissors);
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
