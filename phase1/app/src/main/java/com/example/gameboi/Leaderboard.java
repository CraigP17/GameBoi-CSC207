package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        FileManager file = new FileManager(this);
        ArrayList<User> users = file.getUsers();


        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<User> topScorers = new ArrayList<>();

        // creating temporary highscore which will be over ridden by the actual highscore
        int highscore = -1;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User highScorer = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: users){
            if (item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            }
        }

        // adding highest scoring user to top scorers list and removing the user from users list
        topScorers.add(highScorer);
        users.remove(highScorer);

        // resetting highscore and highScorer to be over ridden
        highscore = -1;
        highScorer = new User();

        // for loop that determines the user in users list with second highest highscore
        for (User item: users){
            if (item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            }
        }

        // Adding second highest scoring user topscorers list and removing user from users list
        topScorers.add(highScorer);
        users.remove(highScorer);

        // Adding remaining user to topscorers list
        topScorers.add(users.get(0));
        System.out.println(topScorers);

        // Displaying topscorers in order in the textviews on leaderboard display
        TextView first = findViewById(R.id.textView31);
        first.setText(topScorers.get(0).getName());
        TextView firstscore = findViewById(R.id.textView24);
        firstscore.setText(String.valueOf(topScorers.get(0).getHighScore()));

        TextView second = findViewById(R.id.textView33);
        second.setText((topScorers.get(1).getName()));
        TextView secondscore = findViewById(R.id.textView25);
        secondscore.setText(String.valueOf(topScorers.get(1).getHighScore()));

        TextView third = findViewById(R.id.textView34);
        third.setText(topScorers.get(2).getName());
        TextView thirdscore = findViewById(R.id.textView28);
        thirdscore.setText(String.valueOf(topScorers.get(2).getHighScore()));
    }


}
