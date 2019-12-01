package com.example.gameboi.ScorePages;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import android.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.R;
import com.example.gameboi.StartupPages.MainActivity;
import com.example.gameboi.UserClasses.User;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Leaderboard extends AppCompatActivity implements OnItemSelectedListener {

    FileManager file = new FileManager(this);
    User player;
    LeaderBoardBE leaderBoardBE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = getIntent().getParcelableExtra("player");
        setContentView(R.layout.activity_leaderboard);

        // Updating the users highscores
        updateHighscore();

        // Initializing the leaderboard backend class that performs all calculations
        leaderBoardBE = new LeaderBoardBE(file);


        //Creating a drop down menu that allows users to see players ranked based on different criteria
        Spinner dropDownMenu = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.scoreboard_titles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(adapter);

        //Setting up the onClicklistener to display values based on what user clicked
        dropDownMenu.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Leaderboard.this.onItemSelected(adapterView, view, i, l);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Leaderboard.this.onNothingSelected(adapterView);

            }
        });

    }

    //onItemselected needed outside onCreate inorder for interface to recognize that it has been created
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        switch (pos) {
            // when user selects highscore
            case 0:
                selectedHighscore();
                break;
            // when user selects score
            case 1:
                selectedScore();
                break;
            // when user selects multiplier
            case 2:
                selectedMultiplier();
                break;
            // when user selects lives
            case 3:
                selectedLives();
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    // Obtains ordered values list from backend to display on leaderboard
    public void selectedHighscore() {
        ArrayList<Pair> highScores = leaderBoardBE.orderedHighscorelist;
        displayTextviews(highScores);
    }

    public void selectedMultiplier() {
        ArrayList<Pair> multiplier = leaderBoardBE.orderedMultiplierlist;
        displayTextviews(multiplier);
    }

    public void selectedLives() {
        ArrayList<Pair> lives = leaderBoardBE.orderedLiveslist;
        displayTextviews(lives);
    }

    public void selectedScore() {
        ArrayList<Pair> scores = leaderBoardBE.orderedScorelist;
        displayTextviews(scores);

    }


    // Calls textviews and displays score based on what list is passed in
    public void displayTextviews(ArrayList<Pair> listTodisplay) {
        // Displaying topscorers in order in the textviews on leaderboard display

        TextView first = findViewById(R.id.textView31);
        first.setText(((User) listTodisplay.get(0).first).getName());
        TextView firstscore = findViewById(R.id.textView24);
        firstscore.setText(String.valueOf((int) listTodisplay.get(0).second));

        TextView second = findViewById(R.id.textView33);
        second.setText(((User) listTodisplay.get(1).first).getName());
        TextView secondscore = findViewById(R.id.textView25);
        secondscore.setText(String.valueOf((int) listTodisplay.get(1).second));

        TextView third = findViewById(R.id.textView34);
        third.setText(((User) listTodisplay.get(2).first).getName());
        TextView thirdscore = findViewById(R.id.textView28);
        thirdscore.setText(String.valueOf((int) listTodisplay.get(2).second));
    }

    //Method to update the Highscore of the user
    public void updateHighscore() {

        int newPoints = player.getPoints() * player.getMultiplier();

        // Set high score of the User if they have beat their high score
        if (newPoints > player.getHighScore()) {
            player.setHighScore(newPoints);
        }

        player.setPoints(newPoints);
        file.save(player);
    }

    // If play again button is pressed, users points are cleared and other values are reset
    public void playAgain(View view) {
        player.setPoints(0);
        player.setMultiplier(1);
        player.setLives(player.getOrigLives());
        player.setCurrLevel(0);
        file.save(player);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
