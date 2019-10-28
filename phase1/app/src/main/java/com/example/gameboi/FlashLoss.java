package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FlashLoss extends AppCompatActivity {

    private User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_loss);

        // Unpack and store the User stats to be displayed
        player = getIntent().getParcelableExtra("player");
    }

    // Take them to the home page if they have no more lives
    public void exitGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
