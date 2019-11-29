package com.example.gameboi.UserClasses;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    /*This class is responsible for storing the user data for a game.
     * It stores the users username, points, lives and customization preferences*/

    /**
     * This object is responsible for storing and manipulating the Users statistics
     */
    private UserStats stats;

    /**
     * This object is responsible for storing and manipulating user customizations
     */
    private UserCustom custom;

    /**
     * Constructs a new User
     *
     * @param name             the User's name
     * @param lives            the number of lives they have
     * @param points           number of points after completing level 1
     * @param backgroundColor  the colour of the background in the games
     * @param icon             the User's selected icon
     * @param currLevel        the User's current level,
     * @param highScore        the User's high score after completing the game
     * @param difficulty       the User's game difficulty either Normal OR Hard
     */
    public User(String name, int lives, int points,
                int backgroundColor, String icon, int currLevel, int highScore, int origLives,
                String difficulty) {

        this.custom = new UserCustom(name,backgroundColor,icon,difficulty);
        //multiplier preset to 0 for now
        this.stats = new UserStats(lives,points,0,highScore,currLevel,origLives);
    }

    public User() {
        // Creates an instance of user that is empty, does nothing
    }

    /**
     * Unpacks a Parcel and creates an instance of a User
     *
     * @param in The Parcel that is passed through an Intent
     */
    protected User(Parcel in) {
        stats = in.readParcelable(UserStats.class.getClassLoader());
        custom = in.readParcelable(UserCustom.class.getClassLoader());
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
        parcel.writeParcelable(stats,i);
        parcel.writeParcelable(custom,i);
    }

    @Override
    public String toString() {
        return custom.getName() + "," + stats.getLives() + "," + stats.getPoints() + "," +
                custom.getBackgroundColor() + "," + custom.getIcon() + ","
                + stats.getCurrLevel() + "," + stats.getHighScore() + "," + stats.getOrigLives()
                + "," + stats.getMultiplier() + "," + custom.getDifficulty();
    }

    /**
     * Subtracts a life from the number of lives the User has, after they lose a level
     */
    public void loseALife() {
        stats.setLives(stats.getLives()-1);
    }

    /**
     * @return the number of lives the User has
     */
    public int getLives() {
        return stats.getLives();
    }

    /**
     * Sets the number of lives the User has
     */
    public void setLives(int num) {
        stats.setLives(num);
    }

    /**
     * Sets the User's customized backgroundColor
     */
    public void setBackgroundColor(int color) {
        custom.setBackgroundColor(color);
    }

    /**
     * @return the User's customized backgroundColor
     */
    public int getBackgroundColor() {
        return custom.getBackgroundColor();
    }

    /**
     * @return the User's name
     */
    public String getName() {
        return custom.getName();
    }

    /**
     * Sets the User's name
     */
    public void setName(String name) {
        custom.setName(name);
    }

    /**
     * @return The User's currLevel
     */
    public void setCurrLevel(int level) {
        stats.setCurrLevel(level);
    }

    /**
     * @return The User's currLevel
     */
    public int getCurrLevel() {
        return stats.getCurrLevel();
    }

    /**
     * Increase the User's current level by 1
     */
    public void incrementCurrLevel() {
        stats.setCurrLevel(stats.getCurrLevel()+1);
    }

    /**
     * @return The User's highScore
     */
    public int getHighScore() {
        return stats.getHighScore();
    }

    /**
     * Sets the User's high score
     *
     * @param highScore The high score of the user playing the games
     */
    public void setHighScore(int highScore) {
        stats.setHighScore(highScore);
    }

    /**
     * @return String value that represents logo file name
     */
    public String getIcon() {
        return custom.getIcon();
    }

    /**
     * @param newIcon The new logo's name
     */
    public void setIcon(String newIcon) {
        custom.setIcon(newIcon);
    }

    /**
     * @return The current amount of points a user has accumulated
     */
    public int getPoints(){
        return stats.getPoints();
    }

    /**
     * @param num the amount of points that the User has earned
     */
    public void setPoints(int num){
        stats.setPoints(num);
    }

    /**
     * @return The number of lives the user has originally chosen to have
     */
    public int getOrigLives() {
        return stats.getOrigLives();
    }

    /**
     * @param origLives the value to set the number of lives that the user begins with
     */
    public void setOrigLives(int origLives) {
        stats.setOrigLives(origLives);
    }

    /**
     * @return The users current multiplier
     */
    public int getMultiplier() {
        return stats.getMultiplier();
    }

    /**
     * @param multiplier the users new multiplier
     */
    public void setMultiplier(int multiplier) {
        stats.setMultiplier(multiplier);
    }

    /**
     * @return the User's chosen game difficulty
     */
    public String getDifficulty() { return custom.getDifficulty(); }

    /**
     * @param difficulty the User's new difficulty
     */
    public void setDifficulty(String difficulty) { custom.setDifficulty(difficulty); }

    //TODO: replace this method once difficulties have been implemented!
    public boolean isHard(){return false;}

}
