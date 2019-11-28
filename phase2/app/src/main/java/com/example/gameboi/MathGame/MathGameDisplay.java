package com.example.gameboi.MathGame;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.R;

import androidx.appcompat.app.AppCompatActivity;

class MathGameDisplay extends GameDisplay {
    private TextView responseView;
    private TextView equationDisplay;

    MathGameDisplay(TextView scoreboard, TextView multiplier, ImageView lifeOne,
                    ImageView lifeTwo, ImageView lifeThree, TextView responseView,
                    TextView equationDisplay){
        super();
        this.scoreboard = scoreboard;
        this.multiplier = multiplier;
        this.lifeOne = lifeOne;
        this.lifeTwo = lifeTwo;
        this.lifeThree = lifeThree;
        this.responseView = responseView;
        this.equationDisplay = equationDisplay;
//        scoreboard = activity.findViewById(R.id.mathGameScore);
//        lifeOne = activity.findViewById(R.id.lifeOne);
//        lifeTwo = activity.findViewById(R.id.lifeTwo);
//        lifeThree = activity.findViewById(R.id.lifeThree);
//        multiplier = activity.findViewById(R.id.multiplier);
//        responseView = activity.findViewById(R.id.responseView);
//        equationDisplay = activity.findViewById(R.id.equationDisplay);
    }

    void updateResponse(int response) {responseView.setText(String.valueOf(response));}

    void updateEquation(String equation) {equationDisplay.setText(equation);}

}
