package com.example.gameboi.Games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameboi.ScorePages.LevelResults;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GameActivity extends AppCompatActivity {

    /**
     * The TextView id that displays the User's score
     */
    public TextView scoreboard;
    /**
     * The TextView id that displays the User's multiplier
     */
    public TextView multiplier;

    // The number of life icons displayed represents the number of lives the User has
    /**
     * The ImageView id that displays the User's first life
     */
    public ImageView lifeOne;
    /**
     * The ImageView id that displays the User's second life
     */
    public ImageView lifeTwo;
    /**
     * The ImageView id that displays the User's third life
     */
    public ImageView lifeThree;

    /**
     * Instance of GameFacade which is an abstract class responsible for getting User data and
     * calculating Game data
     */
    public GameFacade gameFacade;

    /**
     * The User's customized chosen icon
     */
    public int icon;

    /**
     * Updates the scoreboard TextView with User's new score
     */
    public void updateScoreBoard() {
        String scoreToDisplay = "Score: " + gameFacade.getScore();
        scoreboard.setText(scoreToDisplay);
    }

    /**
     * Updates lives icons with the correct User's chosen icon
     */
    public void updateLivesIcon() {
        lifeOne.setImageResource(icon);
        lifeTwo.setImageResource(icon);
        lifeThree.setImageResource(icon);
    }

    /**
     * Updates the background colour with the User's chosen customized colour
     */
    public void updateBackgroundColor() {
        getWindow().getDecorView().setBackgroundColor(gameFacade.getBackgroundColor());
    }

    /**
     * Updates the number of icons/lives displayed based on how many lives the User has
     */
    public void updateLives() {
        int numLives = gameFacade.getLives();
        if (numLives <= 2) {
            lifeThree.setImageAlpha(0);
        }
        if (numLives <= 1) {
            lifeTwo.setImageAlpha(0);
        }
        if (numLives == 0) {
            lifeOne.setImageAlpha(0);
        }
    }

    /**
     * Updates the multiplier TextView with the User's current multiplier
     */
    public void updateMultiplier() {
        String multiplierToDisplay = "Multiplier: x" + gameFacade.getMultiplier();
        multiplier.setText(multiplierToDisplay);
    }

    /**
     * @return boolean of whether the Game level is over and can move to LevelResults and next level
     */
    public boolean isGameOver() {
        return gameFacade.isGameOver();
    }

    /**
     * Takes the User to the levelResults Activity after they have finished the current game level
     * Passes the User player and their stats to be displayed on Level results
     * Passes whether the User has won or lost the game in order to display the correct Texts
     */
    public void toNext() {
        Intent intent = new Intent(this, LevelResults.class);
        intent.putExtra("player", gameFacade.getPlayer());
        if (gameFacade.isWinner()) {
            intent.putExtra("success", true);
        } else {
            intent.putExtra("success", false);
        }
        startActivity(intent);
    }

    /**
     * Updates the score, lives, multiplier TextViews, calling each respective method
     */
    public void updateDisplay() {
        updateScoreBoard();
        updateLives();
        updateMultiplier();
    }

    /**
     * Sets up the Game display with the User's chosen customizations and displays their correct stats
     */
    public void setupDisplay() {
        updateBackgroundColor();
        updateLivesIcon();
        updateDisplay();
    }

    /**
     * Checks whether the hidden feature for the game has been found through the correction pattern
     * and displays a Toast telling the User that they got the hidden bonus multiplier and
     * updates their User stats
     * Ensures that the hidden feature can only be found once and multiplier increased once
     */
    public void checkHiddenFeature() {
        // The hidden feature should not be already found so FoundHiddenFeature should be false
        // If FoundHiddenFeature is false and checkHidden is true, then display a Toast and increase
        // multiplier
        if (!gameFacade.getFoundHiddenFeature() && gameFacade.checkHidden()) {
            Context context = getApplicationContext();
            int length = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "Multiplier Increased!", length);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            gameFacade.setFoundHiddenFeature();
            updateMultiplier();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
