//package com.example.gameboi.Games.MathGame;
//
//import android.app.Activity;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//abstract class GameDisplay {
//    TextView scoreboard;
//    TextView multiplier;
//    ImageView lifeOne;
//    ImageView lifeTwo;
//    ImageView lifeThree;
//    int icon;
//    Activity activity;
//
//    GameDisplay(Activity activity, String playerIcon) {
//        this.activity = activity;
//        icon = activity.getResources().getIdentifier(playerIcon,
//                "drawable", activity.getPackageName());
//    }
//
//    void updateScoreBoard(int score) {
//        String scoreToDisplay = "Score: " + score;
//        scoreboard.setText(scoreToDisplay);
//    }
//
//    void updateLivesIcon(){
//        lifeOne.setImageResource(icon);
//        lifeTwo.setImageResource(icon);
//        lifeThree.setImageResource(icon);
//    }
//
//    void updateBackgroundColor(int backgroundColor){
//        activity.getWindow().getDecorView().setBackgroundColor(backgroundColor);
//    }
//
//    void updateLives(int numLives) {
//        if (numLives <= 2) {lifeThree.setImageAlpha(0);}
//        if (numLives <= 1) {lifeTwo.setImageAlpha(0);}
//        if (numLives == 0) {lifeOne.setImageAlpha(0);}
//    }
//
//|   void updateMultiplier(int num) {
//        String multiplierToDisplay = "Multiplier: x" + num;
//        multiplier.setText(multiplierToDisplay);
//    }
//

//}
