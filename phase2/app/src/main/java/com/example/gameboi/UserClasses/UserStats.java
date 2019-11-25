package com.example.gameboi.UserClasses;

import android.os.Parcel;
import android.os.Parcelable;

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

    UserStats(int lives, int points, int multiplier, int highScore, int origLives){
        this.lives = lives;
        this.points = points;
        this.multiplier = multiplier;
        this.highScore = highScore;
        this.origLives = origLives;
    }

    protected UserStats(Parcel in) {
        lives = in.readInt();
        points = in.readInt();
        multiplier = in.readInt();
        highScore = in.readInt();
        origLives = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lives);
        dest.writeInt(points);
        dest.writeInt(multiplier);
        dest.writeInt(highScore);
        dest.writeInt(origLives);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserStats> CREATOR = new Creator<UserStats>() {
        @Override
        public UserStats createFromParcel(Parcel in) {
            return new UserStats(in);
        }

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
}
