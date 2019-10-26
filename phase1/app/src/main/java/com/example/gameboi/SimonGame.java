package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;


import java.util.ArrayList;

public class SimonGame extends AppCompatActivity {

    ArrayList<String> userGuess = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
    }

    public void toNext(View view) {
        //says to switch from this activity to the next one
        Intent intent = new Intent(this, RockPaperScissors.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        startActivity(intent); //now intent has key value
        //goes to MathGame.class
    }

    // When a button is clicked by the user as an answer for the pattern, add their input to list of inputs
    public void greenClicked(View view) {
        userGuess.add("Color.RED");
    }

    public void yellowClicked(View view) {
        userGuess.add("Color.YELLOW");
    }

    public void redClicked(View view) {
        userGuess.add("Color.RED");
    }

    public void blueClicked(View view) {
        userGuess.add("Color.BLUE");
    }



    public void Flash(View view){

        Button but = findViewById(R.id.button8);
        but.setBackgroundColor(Color.RED);
    }

    public void SubmitButton(View view){
        Context context = getApplicationContext();
        CharSequence text = "Here the message will say you won or you lost";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
