package com.example.gameboi.ScorePages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.FlashColors.SimonGame;
import com.example.gameboi.R;
import com.example.gameboi.RockPaperScissors.RockPaperScissors;
import com.example.gameboi.UserClasses.User;

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
        // Finished the level, increase their level by 1
        player.incrementCurrLevel();

        // Set high score to new high score if they have beat their score
        if (player.getPoints() > player.getHighScore()) {
            player.setHighScore(player.getPoints());
        }

        FileManager fman = new FileManager(this);
        fman.save(player);

        TextView lives = findViewById(R.id.textView19);
        lives.setText(String.valueOf(player.getLives()));

        TextView points = findViewById(R.id.textView21);
        points.setText(String.valueOf(player.getPoints()));

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
  // Take them to the leader board if they have no more lives
  public void exitGame(View view) {
        if (player.getLives() == 0) {
            Intent intent = new Intent(this, Leaderboard.class);
            startActivity(intent);
        } else {
            if (player.getCurrLevel() == 1) {
                Intent intent = new Intent(this, SimonGame.class);
                intent.putExtra("player", player);
                startActivity(intent);
            } else if (player.getCurrLevel() == 2) {
                Intent intent = new Intent(this, RockPaperScissors.class);
                intent.putExtra("player", player);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, Leaderboard.class);
                startActivity(intent);
            }
        }
   }

}
