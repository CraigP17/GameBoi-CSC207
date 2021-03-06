package com.example.gameboi.UserClasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class is responsible for keeping track of the users customizations
 */
class UserCustom implements Parcelable {

    /**
     * The User's name
     */
    private String name;

    /**
     * The User's background screen colour
     */
    private int backgroundColor;

    /**
     * The User's chosen avatar icon
     */
    private String icon; //string icon

    /**
     * The User's chosen game difficulty
     */
    private String difficulty;

    /**
     * @param name            The name of the user
     * @param backgroundColor The users chosen background color
     * @param icon            The users chosen icon
     * @param difficulty      The chosen difficulty
     */
    UserCustom(String name, int backgroundColor, String icon, String difficulty) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
        this.difficulty = difficulty;
    }

    /**
     * Unpacks a Parcel and creates an instance of a UserCustom
     *
     * @param in The Parcel that is passed through an Intent
     */
    private UserCustom(Parcel in) {
        name = in.readString();
        backgroundColor = in.readInt();
        icon = in.readString();
        difficulty = in.readString();
    }

    public static final Creator<UserCustom> CREATOR = new Creator<UserCustom>() {
        /**
         * Create a new instance of the UserCustom, using data from Parcel written from .writeToParcel()
         *
         * @param in Parcel containing the User's data
         * @return an instance of User
         */
        @Override
        public UserCustom createFromParcel(Parcel in) {
            return new UserCustom(in);
        }

        /**
         * Creates a new array of the UserCustom class
         *
         * @param size of the array
         * @return an array of the Parcelable class, with every entry initialized to null
         */
        @Override
        public UserCustom[] newArray(int size) {
            return new UserCustom[size];
        }
    };

    /**
     * @return A description of the contents in this parcel
     */
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
        parcel.writeInt(backgroundColor);
        parcel.writeString(icon);
        parcel.writeString(difficulty);
    }

    /**
     * @return The users set name
     */
    String getName() {
        return name;
    }

    /**
     * @param name set the User objects name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * @return get the background color
     */
    int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor set a new background color
     */
    void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the users icon
     */
    String getIcon() {
        return icon;
    }

    /**
     * @param icon a new user icon
     */
    void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Returns the User's difficulty of the game
     *
     * @return the User's game difficulty
     */
    String getDifficulty() {
        return this.difficulty;
    }

    /**
     * Sets the User's game difficulty
     *
     * @param difficulty the difficulty of the game
     */
    void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
