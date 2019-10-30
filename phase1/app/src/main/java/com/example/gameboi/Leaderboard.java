package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Leaderboard extends AppCompatActivity {

    User u1 = new User("sarrah", 2, 0, 0, 0, 40, "idk", 0, 5);
    User u2 = new User("anjali", 2, 0, 0, 0, 40, "idk", 0, 3);
    User u3 = new User("jacob", 2, 0, 0, 0, 40, "idk", 1, 1);
    User[] order = new User[] {u1, u2, u3};

    LeaderBoardBE lb = new LeaderBoardBE();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
//        String winner = u1.getName() + u1.getHighScore()
    }


}
