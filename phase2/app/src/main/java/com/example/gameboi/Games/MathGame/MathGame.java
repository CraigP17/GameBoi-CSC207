package com.example.gameboi.Games.MathGame;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gameboi.Games.GameActivity;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

/*
The MathGame class.

Asks the user a series of questions arithmetic questions.
 */
public class MathGame extends GameActivity {

    TextView responseView;
    TextView equationDisplay;
    MathGameManager mathGameManager;

    // Method takes the number of the button pressed and updates the response and responseView
    // The player response cannot exceed 1000000
    private void clickNumButton(int num) {
        mathGameManager.clickNumButton(num);
        updateDisplay();
    }

    // Methods for the calculator buttons
    public void pressZero(View view) {clickNumButton(0);}
    public void pressOne(View view) {clickNumButton(1);}
    public void pressTwo(View view) {clickNumButton(2);}
    public void pressThree(View view) {clickNumButton(3);}
    public void pressFour(View view) {clickNumButton(4);}
    public void pressFive(View view) {clickNumButton(5);}
    public void pressSix(View view) {clickNumButton(6);}
    public void pressSeven(View view) {clickNumButton(7);}
    public void pressEight(View view) {clickNumButton(8);}
    public void pressNine(View view) {clickNumButton(9);}

    //Resets response to Zero and updates the responseView
    public void pressClear(View view) {
        mathGameManager.clearResponse();
        updateDisplay();
    }

    // Checks if the response is correct and adds 1 to score if it is. Updates score, resets
    // response and generates a new equation for the player
    public void pressEnter(View view) {
        mathGameManager.pressEnter();
        updateDisplay();
        if (isGameOver()) {toNext();}
    }

    @Override
    public void setupDisplay(){
        this.scoreboard = findViewById(R.id.mathGameScore);
        this.lifeOne = findViewById(R.id.lifeOne);
        this.lifeTwo = findViewById(R.id.lifeTwo);
        this.lifeThree = findViewById(R.id.lifeThree);
        this.multiplier = findViewById(R.id.multiplier);
        this.responseView = findViewById(R.id.responseView);
        this.equationDisplay = findViewById(R.id.equationDisplay);
        super.setupDisplay();
        updateDisplay();
    }

    @Override
    public void updateDisplay(){
        super.updateDisplay();
        updateResponse();
        updateEquation();
    }

    void updateResponse() {responseView.setText(String.valueOf(mathGameManager.getResponse()));}

    void updateEquation() {equationDisplay.setText(mathGameManager.getEquation());}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        User player = getIntent().getParcelableExtra("player");
        mathGameManager = new MathGameManager(player);
        gameFacade = mathGameManager;
        icon = getResources().getIdentifier(mathGameManager.getPlayerIcon(),
                "drawable", getPackageName());
        setupDisplay();
    }
}