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

    public void updateScoreBoard() {
        String scoreToDisplay = "Score: " + gameFacade.getScore();
        scoreboard.setText(scoreToDisplay);
    }

    /**
     * Updates the images for the lives icons to be the icon chosen by the player.
     */
    public void updateLivesIcon() {
        lifeOne.setImageResource(icon);
        lifeTwo.setImageResource(icon);
        lifeThree.setImageResource(icon);
    }

    /**
     * Changes the background color based on the choice of the user. Obtains the color for
     * gameFacade
     */
    public void updateBackgroundColor() {
        getWindow().getDecorView().setBackgroundColor(gameFacade.getBackgroundColor());
    }

    /**
     * There are 3 lives set to be the player's icon. The number of lives displayed corresponds to
     * the number of lives that the user has. Sets the transparency to 0 for any lost lives.
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
     * Updates the display for the multiplier number held by the player. Gets the player's
     * multiplier from gameFacade.
     */
    public void updateMultiplier() {
        String multiplierToDisplay = "Multiplier: x" + gameFacade.getMultiplier();
        multiplier.setText(multiplierToDisplay);
    }

    /**
     * @return true if gameActivity is over and false otherwise.
     */
    public boolean isGameOver() {
        return gameFacade.isGameOver();
    }

    /**
     * Ends this activity and sends the player to the LevelResults screen.
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
        finish();
    }

    /**
     * Updates the scoreBoard, lifeOne, lifeTwo, lifeThree and multiplier textviews based on the
     * player's current stats
     */
    public void updateDisplay() {
        updateScoreBoard();
        updateLives();
        updateMultiplier();
    }

    /**
     * Sets up the UI for when the activity is created.
     */
    public void setupDisplay() {
        updateBackgroundColor();
        updateLivesIcon();
        updateDisplay();
    }

    /**
     * Checks if the player has found the hidden feature for the first time and displays a message
     * informing them their multiplier has increased. Increased the multiplier and updates the
     * TextView.
     */
    public void checkHiddenFeature() {
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
    public void onBackPressed() {
    }

}
