package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class SimonGame extends AppCompatActivity {

    ArrayList<Integer> userGuess = new ArrayList<>();
    Paint paint = new Paint();
    User user = new User("moogah", 1, 0, 0 ,0, paint, "fds", '0');
    FlashColors flash = new FlashColors(user);
    private int incorrect = 0;
    private int flashLevels = 0;
    private boolean isSubmitted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
//        Here is the code needed to set the score up at startup:
//        TextView scoreBoard = findViewById(R.id.textView10);
//        scoreBoard.setText("0");
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
        userGuess.add(Color.RED);
    }

    public void yellowClicked(View view) {
        userGuess.add(Color.YELLOW);
    }

    public void redClicked(View view) {
        userGuess.add(Color.RED);
    }

    public void blueClicked(View view) {
        userGuess.add(Color.BLUE);
    }

    /*This method is called when the flashing square is pressed. It will generate
    * a random color sequence and keep the sequence in memory until submitted*/
    public void Flash(View view){
        ArrayList<Integer> pattern= new ArrayList<>();
        if(isSubmitted){
            isSubmitted = false;
            //pattern = flashobj.generate()
        }
        else{
            //pattern = flashobj.getCorrectPattern()
        }
        Button but = findViewById(R.id.button8);
        but.setText("");
        ValueAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor", Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }

    public void SubmitButton(View view){

        Button but = findViewById(R.id.button8);
        CharSequence message = "START";
        but.setText(message);

        Context context = getApplicationContext();
        CharSequence success = "Nice Job! Can you get the next one?";
        CharSequence failure = "Uh-oh. You guessed incorrectly. You have one more chance!";
        int duration = Toast.LENGTH_SHORT;

        // Check if the submitted pattern is correct then clear their pattern
        if (flash.isCorrect(userGuess)) {
            Toast toast = Toast.makeText(context, success, duration);
            toast.show();
            flashLevels++;
        } else {
            Toast toast = Toast.makeText(context, failure, duration);
            toast.show();
            incorrect++;
            flashLevels++;
        }
        userGuess.clear();

        // Check if the user got 2 incorrect answers and take them to the Lose a Life Activity
        if (incorrect == 2) {
            Intent intent = new Intent(this, FlashLoss.class);
            startActivity(intent);
        }

        // Check if the user has played 4 levels of FlashColour and then move to the Winner Activity
        if (flashLevels == 4) {
            Intent intent = new Intent(this, FlashWin.class);
            startActivity(intent);
        }

    }
}