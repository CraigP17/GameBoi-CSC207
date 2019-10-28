package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FlashWin extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_win);

        // Store the User to display their stats
        player = getIntent().getParcelableExtra("player");
    }

    public void toNext(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        // Send the user to the third game level
        intent.putExtra("user", player);
        startActivity(intent); //now intent has key value
    }
}
