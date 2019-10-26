package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FlashWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_win);
    }

    public void toNext(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        startActivity(intent); //now intent has key value
    }
}
