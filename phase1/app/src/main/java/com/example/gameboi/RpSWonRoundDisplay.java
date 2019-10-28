package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import android.os.Bundle;

import java.util.HashMap;

public class RpSWonRoundDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_swon_round_display);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String userChoiceDisplay = intent.getStringExtra("userchoice");
        String cChoiceDisplay = intent.getStringExtra("computerchoice");

        TextView uChoice = findViewById(R.id.textView11);
        uChoice.setText(userChoiceDisplay);
        TextView cChoice = findViewById(R.id.textView13);
        cChoice.setText(cChoiceDisplay);
//        String message = intent.getStringExtra(RockPaperScissors.EXTRA_MESSAGE);

//        String message = "You won this round!";
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);
    }

    public void continueGame(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        startActivity(intent); //now intent has key value
    }
}
