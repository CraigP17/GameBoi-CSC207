package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        player.loseALife();

        FileManager fman = new FileManager(this);
        fman.save(player);

        TextView lives = findViewById(R.id.textView19);
        lives.setText(String.valueOf(player.getLives()));

        TextView points = findViewById(R.id.textView21);
        points.setText(String.valueOf(player.getTotalPoints()));

        Button btn = findViewById(R.id.button13);
        if (player.getLives() > 0) {
            CharSequence txtBtn = "NEXT";
            btn.setText(txtBtn);
        } else {
            CharSequence txtBtn = "EXIT";
            btn.setText(txtBtn);
        }
    }

  /**
   * When a User is on the FlashLoss page after losing a level, if they have more lives, then they
   * can continue to the next level, else they are sent to the Leaderboard Activity
   */
  // Take them to the home page if they have no more lives
  public void exitGame(View view) {
        if (player.getLives() > 0) {
            player.incrementCurrLevel();

            if (player.getCurrLevel() == 1) {
                Intent intent = new Intent(this, SimonGame.class);
                intent.putExtra("player", player);
                startActivity(intent);
            } else if (player.getCurrLevel() == 2) {
                Intent intent = new Intent(this, RockPaperScissors.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        } else {
            if (player.getTotalPoints() > player.getHighScore()) {
                player.setHighScore(player.getTotalPoints());
            }
            Intent intent = new Intent(this, Leaderboard.class);
            startActivity(intent);
        }
    }
}
