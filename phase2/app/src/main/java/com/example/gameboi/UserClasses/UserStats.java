package com.example.gameboi.UserClasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class is responsible for keeping track of the users statistics
 */
class UserStats implements Parcelable {

    /**
     * The User's number of lives
     */
    private int lives;

    /**
     * The User's Points
     */
    private int points;

    /**
     * The User's multiplier for their score
     */
    private int multiplier;

    /**
     * The User's high score after playing GameBoi
     */
    private int highScore;

    /**
     * The users original lives
     */
    private int origLives;

    /**
     * The User's current level
     */
    private int currLevel;

    /**
     * @param lives      Their current amount of lives a user chooses
     * @param points     Their current amount of points
     * @param multiplier The users multiplier which is multiplied by their score at the leaderboard page
     * @param highScore  The users past highscore
     * @param currLevel  Their current level
     * @param origLives  The amount of lives originally set by the user
     */
    UserStats(int lives, int points, int multiplier, int highScore, int currLevel, int origLives) {
        this.lives = lives;
        this.points = points;
        this.multiplier = multiplier;
        this.highScore = highScore;
        this.origLives = origLives;
        this.currLevel = currLevel;
    }

    /**
     * Unpacks a Parcel and creates an instance of a UserStats
     *
     * @param in The Parcel that is passed through an Intent
     */
    private UserStats(Parcel in) {
        lives = in.readInt();
        points = in.readInt();
        multiplier = in.readInt();
        highScore = in.readInt();
        origLives = in.readInt();
        currLevel = in.readInt();
    }

    /**
     * Packs the User object into a Parcel that can be then sent through an Intent
     *
     * @param dest  the Parcel in which User data is going to be written to
     * @param flags additional information on sending User data
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lives);
        dest.writeInt(points);
        dest.writeInt(multiplier);
        dest.writeInt(highScore);
        dest.writeInt(origLives);
        dest.writeInt(currLevel);
    }

    /**
     * @return The contents of the parcel UserStats
     */
    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserStats> CREATOR = new Creator<UserStats>() {
        /**
         * Create a new instance of the UserStats, using data from Parcel written from .writeToParcel()
         *
         * @param in Parcel containing the User's data
         * @return an instance of User
         */
        @Override
        public UserStats createFromParcel(Parcel in) {
            return new UserStats(in);
        }

        /**
         * Creates a new array of the UserStats class
         *
         * @param size of the array
         * @return an array of the Parcelable class, with every entry initialized to null
         */
        @Override
        public UserStats[] newArray(int size) {
            return new UserStats[size];
        }
    };

    /**
     * @return The current number of lives for a user
     */
    int getLives() {
        return lives;
    }

    /**
     * @param lives set the users number of lives to this value
     */
    void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * @return The users current multiplier
     */
    int getMultiplier() {
        return multiplier;
    }

    /**
     * @param multiplier the users new multiplier
     */
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * @return The users current high score
     */
    int getHighScore() {
        return highScore;
    }

    /**
     * @param highScore set a new highscore for the user
     */
    void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * @return the amount of points a user has accumulated
     */
    int getPoints() {
        return points;
    }

    /**
     * @param points set the new amount of points for a user
     */
    void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return The original amount lives the user chose
     */
    int getOrigLives() {
        return origLives;
    }

    /**
     * @param origLives set a defualt amount of lives
     */
    void setOrigLives(int origLives) {
        this.origLives = origLives;
    }

    /**
     * @return the users current level
     */
    int getCurrLevel() {
        return currLevel;
    }

    /**
     * @param currLevel set the users current level
     */
    void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }

}
