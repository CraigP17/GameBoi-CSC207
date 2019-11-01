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

        FileManager fman = new FileManager(this);
        fman.save(player);

        TextView numLives = findViewById(R.id.textView17);
        numLives.setText(String.valueOf(player.getLives()));

        TextView lvl1Score = findViewById(R.id.textView11);
        lvl1Score.setText(String.valueOf(player.getLevelOnePoints()));

        TextView lvl2Score = findViewById(R.id.textView31);
        lvl2Score.setText(String.valueOf(player.getFCUserScore()));

        TextView lvl3Score = findViewById(R.id.textView33);
        lvl3Score.setText(String.valueOf(player.getLevelThreePoints()));

        TextView totalPoint = findViewById(R.id.textView13);
        totalPoint.setText(String.valueOf(player.getTotalPoints()));
    }

  /**
   * Take the User to the next level, or to the leader board when they have finish all three levels
   */
  public void toNext(View view) {
        player.incrementCurrLevel();
        if (player.getCurrLevel() == 1) {
            Intent intent = new Intent(this, SimonGame.class);
            intent.putExtra("player", player);
            startActivity(intent);
        } else if (player.getCurrLevel() == 2) {
            Intent intent = new Intent(this, RockPaperScissors.class);
            intent.putExtra("player", player);
            startActivity(intent);
        } else {
            if (player.getTotalPoints() > player.getHighScore()) {
                player.setHighScore(player.getTotalPoints());
            }
            Intent intent = new Intent(this, Leaderboard.class);
            startActivity(intent);
        }
    }
}
