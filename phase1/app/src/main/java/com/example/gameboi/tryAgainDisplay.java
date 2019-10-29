package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tryAgainDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_again_display);

        Intent intent = getIntent();
        String userChoiceDisplay = intent.getStringExtra("userchoice");
        String cChoiceDisplay = intent.getStringExtra("computerchoice");

        TextView uChoice = findViewById(R.id.textView28);
        TextView cChoice = findViewById(R.id.textView29);
//        System.out.println(userChoiceDisplay);
        uChoice.setText(userChoiceDisplay);
//        System.out.println(cChoiceDisplay);
        cChoice.setText(cChoiceDisplay);
    }

    public void continueGame(View view) {
        Intent intent = new Intent(this, RockPaperScissors.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        startActivity(intent); //now intent has key value
    }
}
