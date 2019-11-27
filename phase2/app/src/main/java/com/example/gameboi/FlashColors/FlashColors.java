package com.example.gameboi.FlashColors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;
import java.util.Collections;

/*The following class is responsible for storing the user playing the FlashColors as well as the
 * score during the game and the correct color pattern and user color patterns. This class acts as
 * the back end to SimonGame.java*/
class FlashColors {

    protected User player;
    private boolean isSubmitted = true; //starts as true to allow initial pattern
    ArrayList<Integer> correctPattern = new ArrayList<>();
    private ArrayList<Integer> userPattern;

    FlashColors(User player) {
        this.player = player;
    }

    ArrayList<Integer> generatePattern() {
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);
        //pattern.add(Color.BLACK);
        //pattern.add(Color.WHITE);

        Collections.shuffle(pattern);
        correctPattern = pattern;
        System.out.println(pattern);
        return pattern;
    }

    ArrayList<Integer> getCorrectPattern() {
        return correctPattern;
    }

    boolean isCorrect(ArrayList<Integer> userPatterns) {
        setUserPattern(userPatterns);
        return correctPattern.equals(userPattern);
    }


    private void setUserPattern(ArrayList<Integer> userPatterns) {
        this.userPattern = userPatterns;
    }

    boolean isSubmitted() {
        return isSubmitted;
    }

    void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    /*This method is responsible for grabbing the current score, increasing its value by 1 and
     * returning a new charsequence*/
    CharSequence getNewScore(CharSequence c) {
        CharSequence newScore;
        int score = Integer.parseInt(c.toString());
        score++;
        newScore = String.valueOf(score);
        //setScore(score); //store the score of the game for an user
        return newScore;
    }

    /*This method will return the local score for a user playing FlashColors*/
    void setScore(int score) {
        player.setPoints(score);
    }

    void setIcon(Activity activity){
        //Setting up the user icon
        ImageView icon = activity.findViewById(R.id.imageView1);
        int resID = activity.getResources().getIdentifier(player.getIcon(),
                "drawable", activity.getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
    }

    void setBackground(Activity activity){
        //Setting up the background Colour
        View flashColor = activity.findViewById(R.id.textView9); //finds random view
        View Root = flashColor.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
    }

    TextView setScoreText(Activity activity){
        //Here is the code needed to set the score up at startup:
        TextView scoreBoard = activity.findViewById(R.id.textView10);
        int prevscore = player.getPoints();
        scoreBoard.setText(String.valueOf(prevscore));

        return scoreBoard;
    }

    void setLives(Activity activity){
        //Display the Lives
        TextView dispLives = activity.findViewById(R.id.textView40);
        int userLives = player.getLives();
        dispLives.setText(String.valueOf(userLives));
    }

    void setMultiplier(Activity activity){
        //Display Multiplier
        TextView dispMulti = activity.findViewById(R.id.textView43);
        int userMulti = player.getMultiplier();
        dispMulti.setText(String.valueOf(userMulti));
    }
}
