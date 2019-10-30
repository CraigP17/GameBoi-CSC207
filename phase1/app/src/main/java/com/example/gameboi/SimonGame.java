package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class SimonGame extends AppCompatActivity {

    ArrayList<Integer> userGuess = new ArrayList<>();
    User user = new User("moogah", 1, 0, 0 ,0, Color.WHITE, "fds", 0, 0);
    FlashColors flash = new FlashColors(user);
    private int incorrect = 0;
    private int flashLevels = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
        //Setting up the user icon
        ImageView icon = findViewById(R.id.imageView1);
        int resID = getResources().getIdentifier("weirdguy",
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
        //Setting up the background Colour
        View flashColor = findViewById(R.id.textView2); //finds random view
        View Root = flashColor.getRootView(); //finds the root view
        Root.setBackgroundColor(-7829368); //set background color
//      Here is the code needed to set the score up at startup:
        TextView scoreBoard = findViewById(R.id.textView10);
        scoreBoard.setText("0");
    }

    public void toNext(View view) {
        //says to switch from this activity to the next one
        Intent intent = new Intent(this, RockPaperScissors.class);
        startActivity(intent); //now intent has key value
        //goes to MathGame.class
    }

    // When a button is clicked by the user as an answer for the pattern, add their input to list of inputs
    public void greenClicked(View view) {
        userGuess.add(Color.GREEN);
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
        ArrayList<Integer> pattern;
        if(flash.isSubmitted()){
            flash.setSubmitted(false);
            pattern = flash.generatePattern();
        }
        else{
            pattern = flash.getCorrectPattern();
        }
        Button but = findViewById(R.id.button8);
        but.setText("");

        ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
                pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3));
        colorAnim.setDuration(4000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }

    public void SubmitButton(View view){

        Button but = findViewById(R.id.button8);
        TextView scoreBoard = findViewById(R.id.textView10);
        CharSequence message = "START";
        but.setText(message);
        flash.setSubmitted(true); //changes the submit value to true so that new pattern can be made

        Context context = getApplicationContext();
        CharSequence success = "Nice Job! Can you get the next one?";
        CharSequence failure = "Uh-oh. You guessed incorrectly. You have one more chance!";
        int duration = Toast.LENGTH_SHORT;
        System.out.println(userGuess);
        // Check if the submitted pattern is correct then clear their pattern
        if (flash.isCorrect(userGuess)) {
            Toast toast = Toast.makeText(context, success, duration);
            toast.show();
            flashLevels++;
            scoreBoard.setText(flash.getNewScore(scoreBoard.getText())); //here we set the new score
        } else {
            Toast toast = Toast.makeText(context, failure, duration);
            toast.show();
            incorrect++;
            flashLevels++;
        }
        userGuess.clear();

        // Check if the user got 2 incorrect answers and take them to the Lose a Life Activity
        if (incorrect == 2) {
            flash.setScore(Integer.parseInt(String.valueOf(scoreBoard.getText()))); //updates the score
            Intent intent = new Intent(this, FlashLoss.class);
            intent.putExtra("player", user);
            startActivity(intent);
        }

        // Check if the user has played 4 levels of FlashColour and then move to the Winner Activity
        if (flashLevels == 4) {
            flash.setScore(Integer.parseInt(String.valueOf(scoreBoard.getText()))); //updates the score
            int finalScores = flashLevels-incorrect;
            Intent intent = new Intent(this, FlashWin.class);
            intent.putExtra("player", user);
            intent.putExtra("gamesWon", finalScores);
            startActivity(intent);
        }

    }
}