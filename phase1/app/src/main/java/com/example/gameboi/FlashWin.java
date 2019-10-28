package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FlashWin extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_win);

        // Store the User to display their stats
        player = getIntent().getParcelableExtra("player");

        TextView gamesPlayed = findViewById(R.id.textView15);
        String games = player.getFCGamesPlayed() + " Games";
        gamesPlayed.setText(games);

        TextView numLives = findViewById(R.id.textView17);
        numLives.setText(String.valueOf(player.getLives()));

        TextView lvl2Score = findViewById(R.id.textView11);
        lvl2Score.setText(String.valueOf(player.getFCUserScore()));

        TextView totalPoint = findViewById(R.id.textView13);
        totalPoint.setText(String.valueOf(player.getTotalPoints()));
    }

    public void toNext(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        // Send the user to the third game level
        intent.putExtra("player", player);
        startActivity(intent); //now intent has key value
    }
}
