package com.example.gameboi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class RockPaperScissors extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.gameboi.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
    }

    public void RpSGamePlayed(View view) {
        HashMap winnersRpS = new HashMap();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");

//        String ourValue = winnersRpS.keySet().random();


        Intent intent = new Intent(this, RpSWonRoundDisplay.class);
//        String message = "You have won this round!";
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
}
