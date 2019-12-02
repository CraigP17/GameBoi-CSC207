package com.example.gameboi.StartupPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.Games.FlashColors.FlashColorsActivity;
import com.example.gameboi.Games.MathGame.MathGameActivity;
import com.example.gameboi.R;
import com.example.gameboi.Games.RockPaperScissors.RPSActivity;
import com.example.gameboi.ScorePages.Leaderboard;
import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button user1Btn;
    private Button user2Btn;
    private Button user3Btn;
    FileManager f = new FileManager(this);
    ArrayList<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Call on FileManager
        //Set array/list Users
        users = f.getUsers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUserBtns();
        setBtnNames();
    }

    /**
     * Setting up the buttons on the main activity
     */
    private void setUserBtns() {
        user1Btn = findViewById(R.id.user1);
        user2Btn = findViewById(R.id.user2);
        user3Btn = findViewById(R.id.user3);
    }

    /**
     * Set names based on what is in the locally saved file
     */
    private void setBtnNames() {
        user1Btn.setText(btnName((users.get(0))));
        user2Btn.setText(btnName((users.get(1))));
        user3Btn.setText(btnName((users.get(2))));
    }

    /**
     * @param user The user assigned to the button
     * @return A string representation of the user/New if the user doesnt exist yet
     */
    private String btnName(User user) {
        if (user.getName() == null || user.getName().equals("null")) {
            return "New";
        } else {
            return user.getName();
        }
    }

    /**Takes the user to the setup page
     * @param user the empty user that will be set up
     */
    private void toUserSettings(User user) {
        Intent intent = new Intent(this, UserSetter.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    /**
     * @param user The user that has been selected to start the game and is at currLevel = 0.
     */
    private void toMathGame(User user) {
        Intent intent = new Intent(this, MathGameActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    /**
     * @param user The user that has been selected to start the game and is at currLevel = 1.
     */
    private void toSimonGame(User user) {
        Intent intent = new Intent(this, FlashColorsActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    /**
     * @param user The user that has been selected to start and is at currLevel = 2
     */
    private void toRockPaperScissors(User user) {
        Intent intent = new Intent(this, RPSActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    /**
     * @param user User that was selected and left off at the leaderboard
     */
    private void toLeaderboard(User user) {
        Intent intent = new Intent(this, Leaderboard.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    /**Method determines which level to send the user too
     * @param user The user selected
     */
    private void sendToLevel(User user) {
        if (user.getCurrLevel() == 0) {
            toMathGame(user);
        } else if (user.getCurrLevel() == 1) {
            toSimonGame(user);
        } else if (user.getCurrLevel() == 2) {
            toRockPaperScissors(user);
        } else if (user.getCurrLevel() == 3) {
            toLeaderboard(user);
        }
    }

    /**Determine where to send user
     * @param user The user selected
     */
    private void sendToNextScreen(User user) {
        if (hasName(user)) {
            sendToLevel(user);
            finish();
        } else {
            toUserSettings(user);
            finish();
        }
    }

    /**
     * @param view The MainActivity View
     */
    public void User1Btn(View view) {
        sendToNextScreen(users.get(0));
    }

    /**
     * @param view The MainActivity View
     */
    public void User2Btn(View view) {
        sendToNextScreen(users.get(1));
    }

    /**
     * @param view The MainActivity View
     */
    public void User3Btn(View view) {
        sendToNextScreen(users.get(2));
    }

    /**Takes user to instruction page to learn about game
     * @param view The MainActivity View
     */
    public void instructions(View view) {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
        finish();

    }

    /**
     * @param user The 1/3 users selected
     * @return whether or not the user is empty or defined
     */
    private boolean hasName(User user) {
        return (user.getName() != null) && !(user.getName().equals("null"));
    }

    /**
     * This method is responsible for erasing all the users currently registered with the game
     *
     * @param view The current view for MainActivity
     */
    public void EraseUsers(View view) {

        f.erase();

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
    }
}
