package com.example.gameboi.RockPaperScissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gameboi.ScorePages.Leaderboard;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

public class RpsFinalLostDisplay extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps_final_lost_display);
        player = getIntent().getParcelableExtra("player");
    }

    public void continueGame(View view) {
        Intent intent = new Intent(this, Leaderboard.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
