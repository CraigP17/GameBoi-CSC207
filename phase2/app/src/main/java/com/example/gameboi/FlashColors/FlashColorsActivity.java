package com.example.gameboi.FlashColors;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameboi.MathGame.GameActivity;
import com.example.gameboi.R;
import com.example.gameboi.ScorePages.LevelResults;
import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

public class FlashColorsActivity extends GameActivity {

    private User player;
    private FlashColorsFacade flash;
    private int incorrect = 0;
    private int flashLevels = 0;
    private TextView scoreBoard;
    private int accessedBonus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon_game);
        //setup flashcolors game with player from math game
        player = getIntent().getParcelableExtra("player");
        flash = new FlashColorsFacade(player);

        setIcon();
        setMultiplier();
        setLives();
        setBackground();
        scoreBoard = setScoreText();
    }

    // When a button is clicked by the user as an answer for the pattern, add their input to list of inputs
    public void greenClicked(View view) {
        flash.addColour(Color.GREEN);
    }

    public void yellowClicked(View view) {
        flash.addColour(Color.YELLOW);
        checkHiddenFeature();
    }

    public void redClicked(View view) {
        flash.addColour(Color.RED);
    }

    public void blueClicked(View view) {
        flash.addColour(Color.BLUE);
    }

    public void blackClicked(View view) {
        flash.addColour(Color.BLACK);
        checkHiddenFeature();
    }

    public void whiteClicked(View view) {
        flash.addColour(Color.WHITE);
    }

    /*This method is called when the flashing square is pressed. It will generate
    * a random color sequence and keep the sequence in memory until submitted*/
    public void Flash(View view){
        ArrayList<Integer> pattern = flash.DisplayColors();

        Button but = findViewById(R.id.button8);
        but.setText("");

        if (flash.getDifficulty().equals("Normal")){
            ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
                    pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3));
            colorAnim.setDuration(3000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.start();
        }
        else{
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
     */
    public void SubmitButton(View view){
        CharSequence message = "START";
        Button but = findViewById(R.id.button8);
        but.setText(message);
        flash.setSubmitted(true); //changes the submit value to true so that new pattern can be made

        Context context = getApplicationContext();
        CharSequence success = "Nice Job! Can you get the next one?";
        CharSequence failure = "Uh-oh. You guessed incorrectly. You have one more chance!";
        int length = Toast.LENGTH_SHORT;

        // Increment number of games played, and increases their score if User got correct pattern
        flashLevels++;
        if (flash.isCorrect()) {
            scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
        }

        // Displays Toast or takes them to WinLoss Activities, based on incorrect answers and
        // number of games played
        if (flash.isCorrect() & flashLevels < 4) {
            Toast.makeText(context, success, length).show();
            // scoreBoard.setText(flash.getNewScore(scoreBoard.getText()));
        } else if (!flash.isCorrect() & incorrect == 1) {
            flash.setScore(Integer.parseInt(scoreBoard.getText().toString()));
            Intent intent = new Intent(this, LevelResults.class);
            intent.putExtra("player", player);
            intent.putExtra("success", false);
            startActivity(intent);
            finish();
        } else if (flashLevels == 4) {
            flash.setScore(Integer.parseInt(scoreBoard.getText().toString()));
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

    private void checkHiddenFeature(){
        if (accessedBonus == 0 && flash.checkHidden()){
            flash.setMultiplier(flash.getMultiplier()*2);
            Context context = getApplicationContext();
            int length = Toast.LENGTH_SHORT;
            Toast toast =Toast.makeText(context, "Multiplier Increased!", length);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            TextView dispMulti = findViewById(R.id.textView43);
            dispMulti.setText(String.valueOf(flash.getMultiplier()));
            accessedBonus = 1;
        }
    }

    private void setIcon(){
        //Setting up the user icon
        ImageView icon = findViewById(R.id.imageView1);
        int resID = getResources().getIdentifier(flash.getIcon(),
                "drawable", getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
    }

    private void setBackground(){
        //Setting up the background Colour
        View flashColor = findViewById(R.id.textView9); //finds random view
        View Root = flashColor.getRootView(); //finds the root view
        Root.setBackgroundColor(flash.getBackgroundColor()); //set background color
    }

    private TextView setScoreText(){
        //Here is the code needed to set the score up at startup:
        TextView scoreBoard = findViewById(R.id.textView10);
        int prevscore = flash.getPoints();
        scoreBoard.setText(String.valueOf(prevscore));

        return scoreBoard;
    }

    private void setLives(){
        //Display the Lives
        TextView dispLives = findViewById(R.id.textView40);
        int userLives = flash.getLives();
        dispLives.setText(String.valueOf(userLives));
    }

    private void setMultiplier(){
        //Display Multiplier
        TextView dispMulti = findViewById(R.id.textView43);
        int userMulti = flash.getMultiplier();
        dispMulti.setText(String.valueOf(userMulti));
    }
}