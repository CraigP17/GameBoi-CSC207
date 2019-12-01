package com.example.gameboi.RockPaperScissors;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.MathGame.GameActivity;
import com.example.gameboi.ScorePages.FlashLoss;
import com.example.gameboi.ScorePages.FlashWin;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

public class RPSActivity extends GameActivity {

    public static int winsRpS = 0;
    private User player;
    private RPSAbstract rpsCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        setTypeCalc();
        gameFacade = rpsCalc;
        this.icon = getResources().getIdentifier(rpsCalc.getPlayerIcon(),
                "drawable", getPackageName());
//        setIcon();
//        setScore();
//        setBackground();
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
    private void setScore() {
        TextView scoreboardRpS = findViewById(R.id.textView12);
        scoreboardRpS.setText(String.valueOf(winsRpS + player.getPoints()));
    }
    private void setIcon() {
        ImageView icon = findViewById(R.id.lifeOne3);
        int resID = getResources().getIdentifier(player.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
    }


    public void Rock(View view) {
        toNext(rpsCalc.RpSGamePlayed("Rock"));
    }

    public void Paper(View view) {
        toNext(rpsCalc.RpSGamePlayed("Paper"));
    }

    public void Scissors(View view) {
        toNext(rpsCalc.RpSGamePlayed("Scissors"));
    }

    public void Lizard(View view) {
        if (!player.getDifficulty().equals("Normal")){
            toNext(rpsCalc.RpSGamePlayed("Lizard"));
        }
    }

    public void Spock(View view) {
        if (!player.getDifficulty().equals("Normal")) {
            toNext(rpsCalc.RpSGamePlayed("Spock"));
        }
    }

    private void toNext(String[] arr) {
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

    @Override
    public void setupDisplay(){
        this.scoreboard = findViewById(R.id.RPSScore);
        this.lifeOne = findViewById(R.id.lifeOne3);
        this.lifeTwo = findViewById(R.id.lifeTwo3);
        this.lifeThree = findViewById(R.id.lifeThree3);
        this.multiplier = findViewById(R.id.multiplier3);
        super.setupDisplay();
        updateDisplay();
    }
}
