package com.example.gameboi;

import android.os.Parcel;
import android.os.Parcelable;

class User implements Parcelable {
    /*This class is responsible for storing the user data for a game.
     * It stores the users username, points, lives and customization preferences*/

    /**
     * The User's name
     */
    private String name;

    /**
     * The User's number of lives
     */
    private int lives;

    /**
     * The User's Level 1: MathGame Points
     */
    private int levelOnePoints;

    /**
     * The User's Level 2: FlashColor/Simon Points
     */
    private int levelTwoPoints;

    /**
     * The User's Level 3: RockPaperScissors Points
     */
    private int levelThreePoints;

    /**
     * The User's background screen colour
     */
    private int backgroundColor;

    /**
     * The User's chosen avatar icon
     */
    private String icon; //string icon

    /**
     * The User's current level
     */
    private int currLevel;

    /**
     * The User's high score after playing GameBoi
     */
    private int highScore;

    /**
     * Constructs a new User
     *
     * @param name             the User's name
     * @param lives            the number of lives they have
     * @param levelOnePoints   number of points after completing level 1
     * @param levelTwoPoints   number of points after completing level 2
     * @param levelThreePoints number of points after completing level 3
     * @param backgroundColor  the colour of the background in the games
     * @param icon             the User's selected icon
     * @param currLevel        the User's current level,
     * @param highScore        the User's high score after completing the game
     */
    User(String name, int lives, int levelOnePoints, int levelTwoPoints, int levelThreePoints,
         int backgroundColor, String icon, int currLevel, int highScore) {
        this.name = name;
        this.lives = lives;
        this.levelOnePoints = levelOnePoints;
        this.levelTwoPoints = levelTwoPoints;
        this.levelThreePoints = levelThreePoints;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
        this.currLevel = currLevel;
        this.highScore = highScore;
    }

    User() {
        // Creates an instance of user that is empty, does nothing
    }

    /**
     * Unpacks a Parcel and creates an instance of a User
     *
     * @param in The Parcel that is passed through an Intent
     */
    protected User(Parcel in) {
        name = in.readString();
        lives = in.readInt();
        levelOnePoints = in.readInt();
        levelTwoPoints = in.readInt();
        levelThreePoints = in.readInt();
        backgroundColor = in.readInt();
        icon = in.readString();
        currLevel = in.readInt();
        highScore = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        /**
         * Create a new instance of the User, using data from Parcel written from .writeToParcel()
         *
         * @param in Parcel containing the User's data
         * @return an instance of User
         */
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        /**
         * Creates a new array of the User class
         *
         * @param size of the array
         * @return an array of the Parcelable class, with every entry initialized to null
         */
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Packs the User object into a Parcel that can be then sent through an Intent
     *
     * @param parcel the Parcel in which User data is going to be written to
     * @param i      additional information on sending User data
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(lives);
        parcel.writeInt(levelOnePoints);
        parcel.writeInt(levelTwoPoints);
        parcel.writeInt(levelThreePoints);
        parcel.writeInt(backgroundColor);
        parcel.writeString(icon);
        parcel.writeInt(currLevel);
        parcel.writeInt(highScore);
    }

    @Override
    public String toString() {
        return name + "," + lives + "," + levelOnePoints + "," + levelTwoPoints + "," + levelThreePoints +
                "," + backgroundColor + "," + icon + "," + currLevel + "," + highScore;
    }

    /**
     * Substracts a life from the number of lives the User has, after they lose a level
     */
    void loseALife() {
        lives--;
    }

    /**
     * @return the number of lives the User has
     */
    int getLives() {
        return lives;
    }

    /**
     * Sets the number of lives the User has
     */
    void setLives(int num) {
        lives = num;
    }

    /**
     * Sets the User's customized backgroundColor
     */
    void setBackgroundColor( int color) { this.backgroundColor = color; }

    /**
     * @return the User's customized backgroundColor
     */
    int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @return the User's name
     */
    String getName() {
        return name;
    }

    /**
     * Sets the User's name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Get the number of LevelOne Math Game Points
     *
     * @return the User's levelOnePoints
     */
    int getLevelOnePoints() {
        return levelOnePoints;
    }


    int getLevelTwoPoints() {
        return levelTwoPoints;
    }

    /**
     * Set the User's LevelOne Math Game Points
     *
     * @param points The number of level 1 points
     */
    void setLevelOnePoints(int points) {
        levelOnePoints = points;
    }

    /**
     * Gets the number of points the User has after playing Level 2
     *
     * @return the User's levelTwoPoints
     */
    int getFCUserScore() {
        return levelTwoPoints;
    }

    /**
     * Sets the User's levelTwoPoints after playing FlashColors
     *
     * @param score the User's levelTwoPoints
     */
    void setFCUserScore(int score) {
        this.levelTwoPoints = score; // score increases here
    }

    /**
     * Get the Level Three RPS Points
     *
     * @return the User's levelThreePoints
     */
    int getLevelThreePoints() {
        return levelThreePoints;
    }

    void setLevelThreePoints(int points) {
        levelThreePoints = points;
    }

    /**
     * @return the total number of points across all levels
     */
    int getTotalPoints() {
        return levelOnePoints + levelTwoPoints + levelThreePoints;
    }

    /**
     * @return The User's currLevel
     */
    int getCurrLevel() {
        return currLevel;
    }

    /**
     * Increase the User's current level by 1
     */
    void incrementCurrLevel() {
        currLevel++;
    }

    /**
     * @return The User's highScore
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * Sets the User's high score
     *
     * @param highScore The high score of the user playing the games
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * @return String value that represents logo file name
     */
    String getIcon() {
        return this.icon;
    }

    /**
     * @param newIcon The new logo's name
     */
    void setIcon(String newIcon) {
        this.icon = newIcon;
    }
}
