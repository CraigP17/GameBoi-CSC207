package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/*
The MathGame class.

The UI for a simple mathGame.
 */
public class MathGame extends AppCompatActivity {

    //The response displayed for the user in a TextView.
    private TextView responseView;
    //Displays the Current math question.
    private TextView equationDisplay;
    //Displays the number of questions the user has answered correctly.
    private TextView mathGameScore;
    // The user playing this game. Is set in the onCreate method.
    User player;
    // Keeps track of equation, the answer, the player's response, score, rounds lost and numRounds
    private MathGameManager mgm;

    /**
     * Updates the response view with the response in mathGameManager
     */
    private void updateResponseView() {responseView.setText(String.valueOf(mgm.getResponse()));}

    /**
     * Checks if the game is over. If number of losses is 3, it sends the player to the lose screen
     * and if the total rounds played is 10, sends them to the win screen.
     */
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

    /**
     * Generates a new equation in mathGameManage and sets it to the equationDisplay
     */
    private void setEquation() {
        mgm.newEquation();
        equationDisplay.setText(mgm.getEquation());
    }

    /**
     *  Checks to make sure the response is less than 100000 so the numbers don't run over the
     *  displace, updates the response in MathGameManage and responseView if it is less than 100000
     * @param num The number of the button clicked
     */
    private void clickNumButton(int num) {
        if (mgm.getResponse() < 100000) {
            mgm.updateResponse(num);
            updateResponseView();
        }
    }

    /**
     * Sets up the displays for the player's input, the math question and current score.
     */
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

    /**
     * Resets response in mathGameManager to Zero and updates the responseView
     * @param view the current view
     */
    public void pressClear(View view) {
        mgm.resetResponse();
        updateResponseView();
    }

  /**
   * Checks if the response matches the answer and adds 1 to score if it is. Updates score, resets
   * response in mathGameManager to 0 and generates a new equation for the player
   *
   * @param view the current view
   */
  public void pressEnter(View view) {
        mgm.incrementNumRounds();
        mgm.checkAnswer();
        isGameOver();
        String currScore = "SCORE: " + mgm.getScore();
        mathGameScore.setText(currScore);
        setEquation();
        mgm.resetResponse();
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