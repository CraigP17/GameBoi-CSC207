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
        this.scoreboard = findViewById(R.id.RPSScore);
        this.lifeOne = findViewById(R.id.lifeOne3);
        this.lifeTwo = findViewById(R.id.lifeTwo3);
        this.lifeThree = findViewById(R.id.lifeThree3);
        this.multiplier = findViewById(R.id.multiplier3);
        setTypeCalc();
        gameFacade = rpsCalc;
//        setIcon();
//        setScore();
//        setBackground();
        icon = getResources().getIdentifier(rpsCalc.getPlayerIcon(),
                "drawable", getPackageName());
        setupDisplay();

    }

    private void setBackground() {
        View colour = findViewById(R.id.textView3); //finds random view
        View Root = colour.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
    }

    private void setTypeCalc() {
        player = getIntent().getParcelableExtra("player");
        // add if statement depending on user difficulty attribute
        rpsCalc = new RPSCalcEasy(player);
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

    private void toNext(String[] arr) {
        if (arr[2].equals("Round")) {
            Intent intent = new Intent(this, RPSRoundDisplay.class);
            intent.putExtra("userchoice", arr[0]);
            intent.putExtra("computerchoice", arr[1]);
            intent.putExtra("player", player);
            startActivity(intent);
        } else {
            super.toNext();
        }
    }

    @Override
    public void setupDisplay(){
        super.setupDisplay();
        updateDisplay();
    }
}
