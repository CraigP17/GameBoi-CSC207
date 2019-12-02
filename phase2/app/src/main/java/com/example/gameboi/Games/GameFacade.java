package com.example.gameboi.Games;

import com.example.gameboi.UserClasses.User;

public abstract class GameFacade {
    // The player's score across all games so far
    public int score;
    // The player currently playing
    public User player;
    //Boolean for whether the player has found the hidden feature for this game yet
    protected boolean foundHiddenFeature = false;
    // boolean for whether the player has won the game or not
    protected boolean winner = false;

    /**
     * Sets the player that is playing the game and sets the score to the number of points they've
     * acquired so far.
     *
     * @param player the current player of the game
     */
    public GameFacade(User player) {
        this.player = player;
        score = player.getPoints();
    }

    /**
     * @return true if they found the hidden feature and false otherwise.
     */
    boolean getFoundHiddenFeature() {
        return foundHiddenFeature;
    }

    /**
     * @return true if the game is over and false otherwise.
     */
    public boolean isGameOver() {
        return false;
    }

    /**
     * @return String of the icon the player has chosen
     */
    public String getPlayerIcon() {
        return player.getIcon();
    }

    /**
     * @return int the player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return int the multiplier that the player has
     */
    public int getMultiplier() {
        return player.getMultiplier();
    }

    /**
     * @return int the number of lives the player has
     */
    public int getLives() {
        return player.getLives();
    }

    /**
     * Returns the player in order for the activity to send it along to the results screen.
     *
     * @return User player.
     */
    public User getPlayer() {
        return player;
    }

    /**
     * @return true if the player is the winner of the game and false otherwise
     */
    boolean isWinner() {
        return winner;
    }

    /**
     * @return int backgroundColor that the player has selected
     */
    int getBackgroundColor() {
        return player.getBackgroundColor();
    }

    /**
     * Sets that the player has found the hidden feature. Sets foundHiddenFeature to updates the
     * player's multiplier.
     */
    protected void setFoundHiddenFeature() {
        foundHiddenFeature = true;
        player.foundHiddenfeature();
    }

    /**
     * @return whether the hidden feature was found
     */
    public abstract boolean checkHidden();

    /**
     * Increments the score by 1.
     */
    public void incrementScore() {
        this.score++;
    }

    /*This method will return the local score for a user playing FlashColorsOperations*/
    public void setScore(int score) {
        player.setPoints(score);
    }

}
