package com.example.gameboi.Games.FlashColors;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gameboi.Games.GameActivity;
import com.example.gameboi.R;
import com.example.gameboi.ScorePages.LevelResults;
import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

/**
 * This Activity class is for the FlashColors game where an animation of flashing colours is
 * displayed and the user needs to input the colours in order of that they were displayed in
 */
public class FlashColorsActivity extends GameActivity {

    /**
     * The current User playing the game
     */
    private User player;

    /**
     * The FCFacade which builds the different parts of the game according to User customizations
     */
    private FlashColorsFacade flash;

    /**
     * The number of incorrect answers the User has
     */
    private int incorrect;

    /**
     * The number of levels of the game that the User has played
     */
    private int flashLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
        player = getIntent().getParcelableExtra("player");
        flash = new FlashColorsFacade(player);
        gameFacade = flash;
        icon = getResources().getIdentifier(flash.getPlayerIcon(),
                "drawable", getPackageName());

        setupDisplay();
    }

    /**
     * @param view The view that the button is click on
     */
    // When a button is clicked by the user as an answer for the pattern, add their input to list of inputs
    public void greenClicked(View view) {
        flash.addColour(Color.GREEN);
    }

    /**
     * Checks whether the hidden feature pattern matches user input
     *
     * @param view The view that the button is click on
     */
    public void yellowClicked(View view) {
        flash.addColour(Color.YELLOW);
        checkHiddenFeature();
    }

    /**
     * @param view The view that the button is click on
     */
    public void redClicked(View view) {
        flash.addColour(Color.RED);
    }

    /**
     * @param view The view that the button is click on
     */
    public void blueClicked(View view) {
        flash.addColour(Color.BLUE);
    }

    /**
     * Check whether the hidden feature pattern matches user input
     *
     * @param view The view that the button is click on
     */
    public void blackClicked(View view) {
        flash.addColour(Color.BLACK);
        checkHiddenFeature();
    }

    /**
     * @param view The view that the button is click on
     */
    public void whiteClicked(View view) {
        flash.addColour(Color.WHITE);
    }

    /**
     * This method is called when the flashing square is pressed. It will generate
     * a random color sequence and keep the sequence in memory until submitted
     *
     * @param view The view that the button is click on
     */
    public void Flash(View view) {
        ArrayList<Integer> pattern = flash.DisplayColors();

        Button but = findViewById(R.id.button8);
        but.setText("");

        if (flash.getDifficulty().equals("Normal")) {
            ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
                    pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3));
            colorAnim.setDuration(3000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.start();
        } else {
            ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
                    pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3), pattern.get(4),
                    pattern.get(5));
            colorAnim.setDuration(5000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.start();
        }
    }

    /**
     * Called when the User submits their answer. User wins the game when they have played the game
     * four times, and have less than 2 incorrect answers. If they have two incorrect answers, they
     * lose the game, lose a life, and are directed to the FlashLoss page. For each answer, a Toast
     * will pop up letting them if they got their answer correct
     *
     * @param view the view screen that the User click the button
     */
    public void SubmitButton(View view) {
        CharSequence message = "START";
        Button but = findViewById(R.id.button8);
        but.setText(message);
        flash.setSubmitted(); //changes the submit value to true so that new pattern can be made

        Context context = getApplicationContext();
        CharSequence success = "Nice Job! Can you get the next one?";
        CharSequence failure = "Uh-oh. You guessed incorrectly. You have one more chance!";
        int length = Toast.LENGTH_SHORT;

        // Increment number of games played, and increases their score if User got correct pattern
        flashLevels++;
        if (flash.isCorrect()) {
            flash.incrementScore();
            updateScoreBoard();
        }

        // Displays Toast or takes them to WinLoss Activities, based on incorrect answers and
        // number of games played
        if (flash.isCorrect() & flashLevels < 4) {
            Toast.makeText(context, success, length).show();
            // scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
        } else if (!flash.isCorrect() & incorrect == 1) {
            flash.setScore(flash.getScore());
            Intent intent = new Intent(this, LevelResults.class);
            intent.putExtra("player", player);
            intent.putExtra("success", false);
            startActivity(intent);
            finish();
        } else if (flashLevels == 4) {
            flash.setScore(flash.getScore());
            Intent intent = new Intent(this, LevelResults.class);
            intent.putExtra("player", player);
            intent.putExtra("success", true);
            startActivity(intent);
            finish();
        } else if (!flash.isCorrect() & incorrect == 0) {
            Toast.makeText(context, failure, length).show();
            incorrect++;
        }
        // Clears the User guess to prepare for next pattern guess
        flash.clearPattern();
    }

    /**
     * Connect the TextViews with variables that are used in super GameActivity to set up the Game
     * display with the correct User stats of score, lives, multiplier
     */
    public void setupDisplay() {
        this.scoreboard = findViewById(R.id.flashScore);
        this.lifeOne = findViewById(R.id.lifeOne);
        this.lifeTwo = findViewById(R.id.lifeTwo);
        this.lifeThree = findViewById(R.id.lifeThree);
        this.multiplier = findViewById(R.id.multiplier2);
        super.setupDisplay();
    }
}