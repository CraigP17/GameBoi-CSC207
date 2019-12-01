package com.example.gameboi.Games.FlashColors;

import com.example.gameboi.Games.GameFacade;
import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

class FlashColorsFacade extends GameFacade {

    /**
     * Helper class for performing the calculation of this game such as comparing User guess with
     * correct answer and generating patterns
     */
    private FlashColorsOperations gameCalculations;

    /**
     * Set up the game based on the User's chosen difficulty
     *
     * @param player The User playing the game
     */
    FlashColorsFacade(User player) {
        super(player);
        if (player.getDifficulty().equals("Hard")) {
            gameCalculations = new FlashColorsOperationsHard(player);
        } else {
            gameCalculations = new FlashColorsOperations(player);
        }
    }

    /**
     * @return whether the User inputted the correct hidden feature
     */
    public boolean checkHidden() {
        return gameCalculations.checkHidden();
    }

    /**
     * @return whether the User's colour guess is correct
     */
    boolean isCorrect() {
        return gameCalculations.isCorrect();
    }

    /**
     *
     */
    void setSubmitted() {
        gameCalculations.setSubmitted(true);
    }

    /**
     * @return a colour which FlashColorsActivity will use of the colour combination display
     */
    ArrayList<Integer> DisplayColors() {
        return gameCalculations.DisplayColors();
    }

    /**
     * @param colour Add the colour of the button pressed by User to list of their guess
     */
    void addColour(int colour) {
        gameCalculations.addColour(colour);
    }

    /**
     * Clear the User's guess to prep for next round of patterns and guesses
     */
    void clearPattern() {
        gameCalculations.clearPattern();
    }

    /**
     * @param multiplier Set the user's new multiplier after getting the bonus
     */
    public void setMultiplier(int multiplier) {
        player.setMultiplier(multiplier);
    }

    /**
     * @return the User's chosen game difficulty
     */
    String getDifficulty() {
        return player.getDifficulty();
    }
}
