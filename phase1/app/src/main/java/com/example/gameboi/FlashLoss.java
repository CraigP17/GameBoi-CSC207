package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FlashLoss extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_loss);

        // Unpack and store the User stats to be displayed
        player = getIntent().getParcelableExtra("player");

        // Subtract a life from the user
        // User player is passed in through intent from SimonGame
        assert player != null;
        player.loseALife();

        TextView lives = findViewById(R.id.textView19);
        lives.setText(String.valueOf(player.getLives()));

        TextView points = findViewById(R.id.textView21);
        points.setText(String.valueOf(player.getFCUserScore()));
    }

    // Take them to the home page if they have no more lives
    public void exitGame(View view) {
        if (player.getLives() >= 1) {
            Intent intent = new Intent(this, RockPaperScissors.class);
            intent.putExtra("player", player);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
