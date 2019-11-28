package com.example.gameboi.MathGame;

import android.app.Activity;
import android.widget.TextView;

import com.example.gameboi.R;

import androidx.appcompat.app.AppCompatActivity;

class MathGameDisplay extends GameDisplay {
    private TextView responseView;
    private TextView equationDisplay;

    MathGameDisplay(MathGame activity){
        super();
        this.activity = activity;
        scoreboard = activity.getScoreboard();
        multiplier = activity.getMultiplier();
        responseView = activity.getResponseView();
        equationDisplay = activity.getEquationDisplay();
        lifeOne = activity.getLifeOne();
        lifeTwo = activity.getLifeTwo();
        lifeThree = activity.getLifeThree();
//        scoreboard = activity.findViewById(R.id.mathGameScore);
//        lifeOne = activity.findViewById(R.id.lifeOne);
//        lifeTwo = activity.findViewById(R.id.lifeTwo);
//        lifeThree = activity.findViewById(R.id.lifeThree);
//        multiplier = activity.findViewById(R.id.multiplier);
//        responseView = activity.findViewById(R.id.responseView);
//        equationDisplay = activity.findViewById(R.id.equationDisplay);
    }

    void updateResponse(int response) {responseView.setText(response);}

    void updateEquation(String equation) {equationDisplay.setText(equation);}

}
