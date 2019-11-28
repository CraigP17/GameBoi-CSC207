package com.example.gameboi.MathGame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.ScorePages.FlashLoss;
import com.example.gameboi.ScorePages.FlashWin;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

/*
The MathGame class.

Asks the user a series of questions arithmetic questions.
 */
public class MathGame extends AppCompatActivity{

    MathGameFacade mathGameFacade;

    TextView getScoreboard(){return findViewById(R.id.mathGameScore);}
    TextView getMultiplier() {return findViewById(R.id.multiplier);}
    TextView getResponseView() {return findViewById(R.id.responseView);}
    TextView getEquationDisplay() {return findViewById(R.id.equationDisplay);}
    ImageView getLifeOne(){return findViewById(R.id.lifeOne);}
    ImageView getLifeTwo(){return findViewById(R.id.lifeTwo);}
    ImageView getLifeThree(){return findViewById(R.id.lifeThree);}


    // Method takes the number of the button pressed and updates the response and responseView
    // The player response cannot exceed 1000000
    private void clickNumButton(int num) {mathGameFacade.clickNumButton(num);}

    // Methods for the calculator buttons
    public void pressZero(View view) {mathGameFacade.clickNumButton(0);}
    public void pressOne(View view) {mathGameFacade.clickNumButton(1);}
    public void pressTwo(View view) {mathGameFacade.clickNumButton(2);}
    public void pressThree(View view) {mathGameFacade.clickNumButton(3);}
    public void pressFour(View view) {mathGameFacade.clickNumButton(4);}
    public void pressFive(View view) {mathGameFacade.clickNumButton(5);}
    public void pressSix(View view) {mathGameFacade.clickNumButton(6);}
    public void pressSeven(View view) {mathGameFacade.clickNumButton(7);}
    public void pressEight(View view) {mathGameFacade.clickNumButton(8);}
    public void pressNine(View view) {mathGameFacade.clickNumButton(9);}

    //Resets response to Zero and updates the responseView
    public void pressClear(View view) {mathGameFacade.pressClear();}

    // Checks if the response is correct and adds 1 to score if it is. Updates score, resets
    // response and generates a new equation for the player
    public void pressEnter(View view) {
        mathGameFacade.pressEnter();
        if (mathGameFacade.isGameOver() && mathGameFacade.isWinner()) {
            goToWinScreen();
        }
        else if (mathGameFacade.isGameOver() && ! mathGameFacade.isWinner()) {
            goToLoseScreen();
        }
    }

    private void goToWinScreen() {
        Intent intent = new Intent(this, FlashLoss.class);
        intent.putExtra("player", mathGameFacade.getPlayer());
        startActivity(intent);
    }

    private void goToLoseScreen() {
        Intent intent = new Intent(this, FlashWin.class);
        intent.putExtra("player", mathGameFacade.getPlayer());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        User player = getIntent().getParcelableExtra("player");
        mathGameFacade = new MathGameFacade(this);
        ImageView icon = findViewById(R.id.avatarIcon);
        int resID = getResources().getIdentifier(player.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
        getWindow().getDecorView().setBackgroundColor(player.getBackgroundColor());
    }
}