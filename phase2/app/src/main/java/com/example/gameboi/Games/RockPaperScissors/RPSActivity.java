package com.example.gameboi.Games.RockPaperScissors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.Games.GameActivity;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

/**
 * Front-end class for RPS, responsible for setting Views depending on difficulty and calling on
 * an instance of RPSAbstract to calculate results of the round
 */
public class RPSActivity extends GameActivity {

    public static int winsRpS = 0;
    /**
     * Current user playing
     */
    private User player;
    /**
     * Instance of backend calculating class depending difficulty chosen by user.
     */
    private RPSAbstract rpsCalc;

    /**
     * Sets which back-end difficulty class to use, as well as views for the game
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        setTypeCalc();
        gameFacade = rpsCalc;
        this.icon = getResources().getIdentifier(rpsCalc.getPlayerIcon(),
                "drawable", getPackageName());
        setupDisplay();
    }


    private void setTypeCalc() {
        player = getIntent().getParcelableExtra("player");
        ImageView lizard = findViewById(R.id.imageButton4);
        ImageView spock = findViewById(R.id.imageButton6);
        if (player.getDifficulty().equals("Normal")) {
            rpsCalc = new RPSCalcEasy(player);
            lizard.setColorFilter(player.getBackgroundColor());
            spock.setColorFilter(player.getBackgroundColor());
            lizard.setEnabled(false);
            spock.setEnabled(false);
        } else if (player.getDifficulty().equals("Hard")) {
            rpsCalc = new RPSCalcHard(player);
            lizard.setEnabled(true);
            spock.setEnabled(true);
        }
    }

    /**
     * If user chooses Rock, rpsCalc calculates which userchoice rock
     */
    public void Rock(View view) {
        toNext(rpsCalc.RpSGamePlayed("Rock"));
    }

    /**
     * If user chooses Paper, rpsCalc calculates which userchoice paper
     */
    public void Paper(View view) {
        toNext(rpsCalc.RpSGamePlayed("Paper"));
    }

    /**
     * If user chooses Scissors, rpsCalc calculates which userchoice Scissors
     */
    public void Scissors(View view) {
        toNext(rpsCalc.RpSGamePlayed("Scissors"));
    }

    /**
     * If user chooses Lizard, rpsCalc calculates which userchoice lizard
     */
    public void Lizard(View view) {
        if (!player.getDifficulty().equals("Normal")) {
            toNext(rpsCalc.RpSGamePlayed("Lizard"));
        }
    }

    /**
     * If user chooses Spock, rpsCalc calculates which userchoice spock
     */
    public void Spock(View view) {
        if (!player.getDifficulty().equals("Normal")) {
            toNext(rpsCalc.RpSGamePlayed("Spock"));
        }
    }

    private void toNext(String[] arr) {
        checkHiddenFeature();
        if (arr[2].equals("Round")) {
            Intent intent = new Intent(this, RPSRoundDisplay.class);
            intent.putExtra("userchoice", arr[0]);
            intent.putExtra("computerchoice", arr[1]);
            intent.putExtra("result", arr[3]);
            intent.putExtra("player", player);
            startActivity(intent);
        } else {
            super.toNext();
        }
    }

    /**
     * sets textview ids in GameActivity to set and update appropriate values in GameActivity
     */
    @Override
    public void setupDisplay() {
        this.scoreboard = findViewById(R.id.RPSScore);
        this.lifeOne = findViewById(R.id.lifeOne3);
        this.lifeTwo = findViewById(R.id.lifeTwo3);
        this.lifeThree = findViewById(R.id.lifeThree3);
        this.multiplier = findViewById(R.id.multiplier3);
        super.setupDisplay();
        updateDisplay();
    }
}
