package com.example.gameboi;

import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

class User implements Parcelable {
/*This class is responsible for storing the user data for a game.
* It stores the users username, points, lives and customization preferences*/

    private String name;

    private int lives;

    private int levelOnePoints;

    private int levelTwoPoints;

    private int levelThreePoints;

    //List stores only 2 values, [#games played, lost]
    private int[] FlashColors = new int[2];

    private Paint backgroundColor = new Paint();

    private String icon; //string icon

    private int currLevel;

    User(String name, int lives, int levelOnePoints, int levelTwoPoints, int levelThreePoints,
         Paint backgroundColor, String icon, int currLevel){
        this.name = name;
        this.lives = lives;
        this.levelOnePoints = levelOnePoints;
        this.levelTwoPoints = levelTwoPoints;
        this.levelThreePoints = levelThreePoints;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
        this.currLevel = currLevel;

    }

    // Unpacks a Parcel and creates a User that can be stored
    protected User(Parcel in) {
        name = in.readString();
        lives = in.readInt();
        levelOnePoints = in.readInt();
        levelTwoPoints = in.readInt();
        levelThreePoints = in.readInt();
        FlashColors = in.createIntArray();
        icon = in.readString();
        currLevel = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(lives);
        parcel.writeInt(levelOnePoints);
        parcel.writeInt(levelTwoPoints);
        parcel.writeInt(levelThreePoints);
        parcel.writeIntArray(FlashColors);
        parcel.writeString(icon);
        parcel.writeInt(currLevel);
    }

    void loseALife() {
        lives--;
    }

    int getLives() {
        return lives;
    }

    String getName() { return name; }

    /*The following method will get the number of games played within the FlashColors game*/
    int getFCGamesPlayed(){
        return this.FlashColors[0];
    }

    /*The following method will get the number of games that were lost within FLashColors*/
    int getFCGamesLost(){
        return this.FlashColors[1];
    }
}
