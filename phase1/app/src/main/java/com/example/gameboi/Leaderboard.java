package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Leaderboard extends AppCompatActivity {

    LeaderBoardBE lb = new LeaderBoardBE();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }


}
