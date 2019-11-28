package com.example.gameboi.FlashColors;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

class FlashDisplay {

    private Activity activity;
    private User player;

    FlashDisplay(Activity activity, User player){
        this.activity = activity;
        this.player = player;
    }

    void setIcon(){
        //Setting up the user icon
        ImageView icon = activity.findViewById(R.id.imageView1);
        int resID = this.activity.getResources().getIdentifier(player.getIcon(),
                "drawable", activity.getPackageName()); // this line of code grabs the resID based on user name
        icon.setImageResource(resID);
    }

    void setBackground(){
        //Setting up the background Colour
        View flashColor = this.activity.findViewById(R.id.textView9); //finds random view
        View Root = flashColor.getRootView(); //finds the root view
        Root.setBackgroundColor(player.getBackgroundColor()); //set background color
    }

    TextView setScoreText(){
        //Here is the code needed to set the score up at startup:
        TextView scoreBoard = this.activity.findViewById(R.id.textView10);
        int prevscore = player.getPoints();
        scoreBoard.setText(String.valueOf(prevscore));

        return scoreBoard;
    }

    void setLives(){
        //Display the Lives
        TextView dispLives = this.activity.findViewById(R.id.textView40);
        int userLives = player.getLives();
        dispLives.setText(String.valueOf(userLives));
    }

    void setMultiplier(){
        //Display Multiplier
        TextView dispMulti = this.activity.findViewById(R.id.textView43);
        int userMulti = player.getMultiplier();
        dispMulti.setText(String.valueOf(userMulti));
    }
}
