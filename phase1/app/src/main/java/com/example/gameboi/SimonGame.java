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


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SimonGame extends AppCompatActivity {

    ArrayList<Integer> userGuess = new ArrayList<>();
    private User player;
    private FlashColors flash;
    private int incorrect = 0;
    private int flashLevels = 0;
    private TextView scoreBoard;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
        //setup flashcolors game with player from math game
        player = getIntent().getParcelableExtra("player");
        flash = new FlashColors(player);
        //Setting up the user icon
        ImageView icon = findViewById(R.id.imageView1);
        int resID = getResources().getIdentifier(player.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
        //Setting up the background Colour
        View flashColor = findViewById(R.id.textView2); //finds random view
        View Root = flashColor.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
//      Here is the code needed to set the score up at startup:
        scoreBoard = findViewById(R.id.textView10);
        scoreBoard.setText("0"); //DOES SCORE START AT 0 always?


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
        but = findViewById(R.id.button8);
        but.setText("");

        ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
                pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3));
        colorAnim.setDuration(4000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }

    /**
     * Called when the User submits their answer. User wins the game when they have played the game
     * four times, and have less than 2 incorrect answers. If they have two incorrect answers, they
     * lose the game, lose a life, and are directed to the FlashLoss page. For each answer, a Toast
     * will pop up letting them if they got their answer correct
     */
    public void SubmitButton(View view){
        CharSequence message = "START";
        but.setText(message);
        flash.setSubmitted(true); //changes the submit value to true so that new pattern can be made

        Context context = getApplicationContext();
        CharSequence success = "Nice Job! Can you get the next one?";
        CharSequence failure = "Uh-oh. You guessed incorrectly. You have one more chance!";
        int length = Toast.LENGTH_SHORT;
        System.out.println(userGuess);

        // Increment number of games played, and increases their score if User got correct pattern
        flashLevels++;
        if (flash.isCorrect(userGuess)) {
            scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
        }

        // Displays Toast or takes them to WinLoss Activities, based on incorrect answers and
        // number of games played
        if (flash.isCorrect(userGuess) & flashLevels < 4) {
            Toast.makeText(context, success, length).show();
            // scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
        } else if (!flash.isCorrect(userGuess) & incorrect == 1) {
            flash.setScore(Integer.parseInt(String.valueOf(scoreBoard.getText())));
            Intent intent = new Intent(this, FlashLoss.class);
            intent.putExtra("player", player);
            startActivity(intent);
        } else if (flashLevels == 4) {
            // scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
            Intent intent = new Intent(this, FlashWin.class);
            intent.putExtra("player", player);
            startActivity(intent);
        } else if (!flash.isCorrect(userGuess) & incorrect == 0) {
            Toast.makeText(context, failure, length).show();
            incorrect++;
        }
        // Clears the User guess to prepare for next pattern guess
        userGuess.clear();
    }
}