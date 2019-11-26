package com.example.gameboi.ScorePages;

import java.sql.Array;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.TextView;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Leaderboard extends AppCompatActivity implements OnItemSelectedListener {

    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        FileManager file = new FileManager(this);

        users = file.getUsers();

        Spinner dropDownMenu = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.scoreboard_titles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(adapter);

        dropDownMenu.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    // when user selects score
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        selectedScore();
                        break;
                    // when user selects multiplier
                    case 1:
                        // Whatever you want to happen when the second item gets selected

                        break;
                    // when user selects lives
                    case 2:
                        // Whatever you want to happen when the third item gets selected
                        selectedLives();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void selectedScore(){

        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<User> topScorers = new ArrayList<>();
        ArrayList<User> tempUserslist = new ArrayList<>(users);

        // creating temporary highscore which will be over ridden by the actual highscore
        int highscore = -1;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User highScorer = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            }
        }

        // adding highest scoring user to top scorers list and removing the user from users list
        topScorers.add(highScorer);
        tempUserslist.remove(highScorer);

        // resetting highscore and highScorer to be over ridden
        highscore = -1;
        highScorer = new User();

        // for loop that determines the user in users list with second highest highscore
        for (User item: tempUserslist){
            if (item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            }
        }

        // Adding second highest scoring user topscorers list and removing user from users list
        topScorers.add(highScorer);
        tempUserslist.remove(highScorer);

        // Adding remaining user to topscorers list
        topScorers.add(tempUserslist.get(0));


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

    public void selectedMultiplier() {
//        // Creating a empty array list that will store all users from highest highscore to lowest
//        ArrayList<User> lives = new ArrayList<>();
//        ArrayList<User> tempUserslist = new ArrayList<>(users);
//
//        // creating temporary highscore which will be over ridden by the actual highscore
//        int mostMultiplier = -1;
//
//        // creating temporary highscorer which will be over ridden by the actual highscorer
//        User userMostmultiplier = new User();
//
//        // for loop that determines the user in users list with highest highscore
//        for (User item: tempUserslist){
//            if (item.getMultiplier() >= mostMultiplier) {
//                mostLives = item.getMultplier();
//                userMostmultiplier = item;
//            }
//        }



    }

    public void selectedLives() {

//        HashMap<Integer, User> lives = new HashMap<>();
//
//        System.out.println(users.size());
//
//        for (User u: users){
//            lives.put(u.getLives(), u);
//        }

        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<User> lives = new ArrayList<>();
        ArrayList<User> tempUserslist = new ArrayList<>(users);

        // creating temporary highscore which will be over ridden by the actual highscore
        int mostLives = -1;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userMostlives = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getLives() >= mostLives) {
                mostLives = item.getLives();
                userMostlives = item;
            }
        }

        // creating temporary highscore which will be over ridden by the actual highscore
        int leastLives = 0;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userLeastlives = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getLives() <= leastLives) {
                leastLives = item.getLives();
                userLeastlives= item;
            }
        }

        // creating temporary highscore which will be over ridden by the actual highscore
        int middleMost = 0;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userMiddlemost = new User();


        for (User item: tempUserslist) {
            if (item != userMostlives && item != userLeastlives) {
                userMiddlemost = item;
                middleMost = item.getLives();
            }
        }


        // Displaying topscorers in order in the textviews on leaderboard display
        TextView first = findViewById(R.id.textView31);
        first.setText(userMostlives.getName());
        TextView firstscore = findViewById(R.id.textView24);
        firstscore.setText(String.valueOf(mostLives));

        TextView second = findViewById(R.id.textView33);
        second.setText(userMiddlemost.getName());
        TextView secondscore = findViewById(R.id.textView25);
        secondscore.setText(String.valueOf(middleMost));

        TextView third = findViewById(R.id.textView34);
        third.setText(userLeastlives.getName());
        TextView thirdscore = findViewById(R.id.textView28);
        thirdscore.setText(String.valueOf(leastLives));
    }


}
