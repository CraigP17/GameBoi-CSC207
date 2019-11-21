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
public class MathGame extends AppCompatActivity {

    //The response displayed for the user in a TextView.
    private TextView responseView;
    //Displays the Current math question.
    private TextView equationDisplay;
    //Displays the number of questions the user has answered correctly.
    private TextView mathGameScore;
    //
    private MathGameManager mgm;
    User player;


    private void updateResponseView() {responseView.setText(String.valueOf(mgm.getResponse()));}

    private void isGameOver(){
        if (mgm.getNumLosses() > 2) {
            player.setLevelOnePoints(mgm.getScore());
            Intent intent = new Intent(this, FlashLoss.class);
            intent.putExtra("player", player);
            startActivity(intent);
        }
        else if (mgm.getNumRounds() > 9){
            player.setLevelOnePoints(mgm.getScore());
            Intent intent = new Intent(this, FlashWin.class);
            intent.putExtra("player", player);
            startActivity(intent);
        }
    }

    //Generates an arithmetic question for the player
    private void setEquation() {
        mgm.newEquation();
        equationDisplay.setText(mgm.getEquation());
    }

    // Method takes the number of the button pressed and updates the response and responseView
    // The player response cannot exceed 1000000
    private void clickNumButton(int num) {
        if (mgm.getResponse() < 100000) {
            mgm.updateResponse(num);
            updateResponseView();
        }
    }

    //Sets up the displays for the player's input, the math question and current score.
    private void setupMathGameUI(){
        responseView = findViewById(R.id.responseView);
        equationDisplay = findViewById(R.id.equationDisplay);
        mathGameScore = findViewById(R.id.mathGameScore);
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
        mgm.setResponse(0);
        updateResponseView();
    }

    // Checks if the response is correct and adds 1 to score if it is. Updates score, resets
    // response and generates a new equation for the player
    public void pressEnter(View view) {
        mgm.incrementNumRounds();
        mgm.checkAnswer();
        isGameOver();
        String currScore = "SCORE: " + mgm.getScore();
        mathGameScore.setText(currScore);
        setEquation();
        mgm.setResponse(0);
        updateResponseView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        player = getIntent().getParcelableExtra("player");
        mgm = new MathGameManager();
        setupMathGameUI();
        ImageView icon = findViewById(R.id.avatarIcon);
        int resID = getResources().getIdentifier(player.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
        getWindow().getDecorView().setBackgroundColor(player.getBackgroundColor());
        setEquation();
    }
}