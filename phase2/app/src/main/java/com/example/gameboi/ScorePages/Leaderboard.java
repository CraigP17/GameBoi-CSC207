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

    ArrayList<User> users;
    FileManager file = new FileManager(this);
    User player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = getIntent().getParcelableExtra("player");

        setContentView(R.layout.activity_leaderboard);
        FileManager file = new FileManager(this);

        users = file.getUsers();

        int newPoints = player.getPoints() * player.getMultiplier();

        // Set high score of the User if they have beat their high score
        if (newPoints > player.getHighScore()) {
            player.setHighScore(newPoints);
        }

        player.setPoints(newPoints);
        file.save(player);


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
                        selectedHighscore(false);
                        break;
                    // when user selects multiplier
                    case 1:
                        // Whatever you want to happen when the third item gets selected
                        selectedScore();
                        break;

                    case 2:
                        // Whatever you want to happen when the second item gets selected
                        selectedMultiplier();
                        break;
                    // when user selects lives
                    case 3:
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

    public void selectedScore() {
        selectedHighscore(true);

    }

    public void selectedHighscore(Boolean score){

        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<Integer> topScores = new ArrayList<>();
        ArrayList<User> tempUserslist = new ArrayList<>(users);
        ArrayList<User> orderedUserslist = new ArrayList<>();

        // creating temporary highscore which will be over ridden by the actual highscore
        int highscore = -1;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User highScorer = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (!score && item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            } else if(score && item.getPoints() >= highscore) {
                highscore = item.getPoints();
                highScorer = item;
            }
        }

        // adding highest scoring user to top scorers list and removing the user from users list
        topScores.add(highscore);
        tempUserslist.remove(highScorer);
        orderedUserslist.add(highScorer);

        // resetting highscore and highScorer to be over ridden
        highscore = -1;
        highScorer = new User();

        // for loop that determines the user in users list with second highest highscore
        for (User item: tempUserslist){
            if (!score && item.getHighScore() >= highscore) {
                highscore = item.getHighScore();
                highScorer = item;
            } else if (score && item.getPoints() >= highscore) {
                highscore = item.getPoints();
                highScorer = item;
            }
        }

        // Adding second highest scoring user topscorers list and removing user from users list
        topScores.add(highscore);
        tempUserslist.remove(highScorer);
        orderedUserslist.add(highScorer);

        // Adding remaining user to topscorers list
        if (!score) {
            topScores.add(tempUserslist.get(0).getHighScore());
        } else {
            topScores.add(tempUserslist.get(0).getPoints());
        }

        orderedUserslist.add(tempUserslist.get(0));

        callTextviews(orderedUserslist, topScores);

//        // Displaying topscorers in order in the textviews on leaderboard display
//        TextView first = findViewById(R.id.textView31);
//        first.setText(topScorers.get(0).getName());
//        TextView firstscore = findViewById(R.id.textView24);
//        firstscore.setText(String.valueOf(topScorers.get(0).getHighScore()));
//
//        TextView second = findViewById(R.id.textView33);
//        second.setText((topScorers.get(1).getName()));
//        TextView secondscore = findViewById(R.id.textView25);
//        secondscore.setText(String.valueOf(topScorers.get(1).getHighScore()));
//
//        TextView third = findViewById(R.id.textView34);
//        third.setText(topScorers.get(2).getName());
//        TextView thirdscore = findViewById(R.id.textView28);
//        thirdscore.setText(String.valueOf(topScorers.get(2).getHighScore()));

    }

    public void selectedMultiplier() {
        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<User> tempUserslist = new ArrayList<>(users);
        ArrayList<User> orderedUserlist = new ArrayList<>();
        ArrayList<Integer> multipliersList = new ArrayList<>();

        // creating temporary highscore which will be over ridden by the actual highscore
        int mostMultiplier = -1;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userMostmultiplier = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getMultiplier() >= mostMultiplier) {
                mostMultiplier = item.getMultiplier();
                userMostmultiplier = item;
            }
        }

        tempUserslist.remove(userMostmultiplier);

        // creating temporary highscore which will be over ridden by the actual highscore
        int leastMultiplier = 100;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userLeastmultiplier = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getMultiplier() <= leastMultiplier) {
                leastMultiplier = item.getMultiplier();
                userLeastmultiplier = item;
            }
        }

        tempUserslist.remove(userLeastmultiplier);

        // creating temporary highscore which will be over ridden by the actual highscore
        int middleMost = tempUserslist.get(0).getMultiplier();

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userMiddlemost = tempUserslist.get(0);

        orderedUserlist.add(userMostmultiplier);
        orderedUserlist.add(userMiddlemost);
        orderedUserlist.add(userLeastmultiplier);

        multipliersList.add(mostMultiplier);
        multipliersList.add(middleMost);
        multipliersList.add(leastMultiplier);

        callTextviews(orderedUserlist, multipliersList);

//        // Displaying topscorers in order in the textviews on leaderboard display
//        TextView first = findViewById(R.id.textView31);
//        first.setText(userMostmultiplier.getName());
//        TextView firstscore = findViewById(R.id.textView24);
//        firstscore.setText(String.valueOf(mostMultiplier));
//
//        TextView second = findViewById(R.id.textView33);
//        second.setText(userMiddlemost.getName());
//        TextView secondscore = findViewById(R.id.textView25);
//        secondscore.setText(String.valueOf(middleMost));
//
//        TextView third = findViewById(R.id.textView34);
//        third.setText(userLeastmultiplier.getName());
//        TextView thirdscore = findViewById(R.id.textView28);
//        thirdscore.setText(String.valueOf(leastMultiplier));


    }

    public void selectedLives() {


        // Creating a empty array list that will store all users from highest highscore to lowest
        ArrayList<Integer> lives = new ArrayList<>();
        ArrayList<User> tempUserslist = new ArrayList<>(users);
        ArrayList<User> orderedUserslist = new ArrayList<>();

        // creating temporary highscore which will be over ridden by the actual highscore
        int mostLives = 0;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userMostlives = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getLives() >= mostLives) {
                mostLives = item.getLives();
                userMostlives = item;
            }
        }

        tempUserslist.remove(userMostlives);

        // creating temporary highscore which will be over ridden by the actual highscore
        int leastLives = 3;

        // creating temporary highscorer which will be over ridden by the actual highscorer
        User userLeastlives = new User();

        // for loop that determines the user in users list with highest highscore
        for (User item: tempUserslist){
            if (item.getLives() <= leastLives) {
                leastLives = item.getLives();
                userLeastlives= item;
            }
        }

        tempUserslist.remove(userLeastlives);

//        // creating temporary highscore which will be over ridden by the actual highscore
//        int middleMost = 0;
//
//        // creating temporary highscorer which will be over ridden by the actual highscorer
//        User userMiddlemost = new User();


//        for (User item: tempUserslist) {
//            if (item != userMostlives && item != userLeastlives) {
//                userMiddlemost = item;
//                middleMost = item.getLives();
//            }
//        }

        lives.add(mostLives);
        lives.add(tempUserslist.get(0).getLives());
        lives.add(leastLives);

        orderedUserslist.add(userMostlives);
        orderedUserslist.add(tempUserslist.get(0));
        orderedUserslist.add(userLeastlives);

        callTextviews(orderedUserslist, lives);

//        // Displaying topscorers in order in the textviews on leaderboard display
//        TextView first = findViewById(R.id.textView31);
//        first.setText(userMostlives.getName());
//        TextView firstscore = findViewById(R.id.textView24);
//        firstscore.setText(String.valueOf(mostLives));
//
//        TextView second = findViewById(R.id.textView33);
//        second.setText(userMiddlemost.getName());
//        TextView secondscore = findViewById(R.id.textView25);
//        secondscore.setText(String.valueOf(middleMost));
//
//        TextView third = findViewById(R.id.textView34);
//        third.setText(userLeastlives.getName());
//        TextView thirdscore = findViewById(R.id.textView28);
//        thirdscore.setText(String.valueOf(leastLives));
    }

    private void callTextviews(ArrayList<User> userList, ArrayList valuesList) {

        ArrayList<Integer> numberedList = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<User> tempUserslist = new ArrayList<>(userList);


        HashMap<Integer, Pair<Integer, Integer>> textViewIds = new HashMap<Integer, Pair<Integer, Integer>>();

        Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(R.id.textView31, R.id.textView24);
        Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(R.id.textView33, R.id.textView25);
        Pair<Integer, Integer> pair3 = new Pair<Integer, Integer>(R.id.textView34, R.id.textView28);

        textViewIds.put(1, pair1);
        textViewIds.put(2, pair2);
        textViewIds.put(3, pair3);

//        // Displaying topscorers in order in the textviews on leaderboard display
//        TextView first = findViewById(R.id.textView31);
//        first.setText(userList.get(0).getName());
//        TextView firstscore = findViewById(R.id.textView24);
//        firstscore.setText(String.valueOf(valuesList.get(0)));
//
//        TextView second = findViewById(R.id.textView33);
//        second.setText(userList.get(1).getName());
//        TextView secondscore = findViewById(R.id.textView25);
//        secondscore.setText(String.valueOf(valuesList.get(1)));
//
//        TextView third = findViewById(R.id.textView34);
//        third.setText(userList.get(2).getName());
//        TextView thirdscore = findViewById(R.id.textView28);
//        thirdscore.setText(String.valueOf(valuesList.get(2)));


        for (User user: tempUserslist) {
            if (user.getName() != null) {
                TextView first = findViewById(textViewIds.get(numberedList.get(0)).first);
                first.setText(userList.get(0).getName());
                TextView firstscore = findViewById(textViewIds.get(numberedList.get(0)).second);
                firstscore.setText(String.valueOf(valuesList.get(0)));

                textViewIds.remove(textViewIds.get(numberedList.get(0)));
                userList.remove(0);
                valuesList.remove(0);
                numberedList.remove(0);
            }
        }


        for (int i: numberedList) {
            TextView third = findViewById(textViewIds.get(numberedList.get(i)).first);
            third.setText("      ");
            TextView thirdscore = findViewById(textViewIds.get(numberedList.get(i)).second);
            thirdscore.setText("        ");
        }

    }
    public void playAgain(View view) {
//        User player = getIntent().getParcelableExtra("player");
        player.setPoints(0);
        player.setMultiplier(1);
        player.setLives(player.getOrigLives());
        player.setCurrLevel(0);
        file.save(player);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
