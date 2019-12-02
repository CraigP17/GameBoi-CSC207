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
//    private FlashColors flash;
//    private User player;
//    ArrayList<Integer> pattern;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Call on FileManager
        //Set array/list Users
        users = f.getUsers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUserBtns();
        setBtnNames();
        /*ArrayList<User> u = f.getUsers();
        System.out.println(u.get(0).getBackgroundColor());
        System.out.println(u.get(1).getBackgroundColor());
        System.out.println(u.get(2).getBackgroundColor());*/

//        player = getIntent().getParcelableExtra("player");
//        TextView but = findViewById(R.id.textView29);
//        but.setText("Gameboi");
//        flash = new FlashColors(player);
//        pattern = flash.generatePattern();
//        ObjectAnimator colorAnim = ObjectAnimator.ofArgb(but, "backgroundColor",
//                pattern.get(0), pattern.get(1), pattern.get(2), pattern.get(3));
//        colorAnim.setDuration(4000);
//        colorAnim.setEvaluator(new ArgbEvaluator());
//        colorAnim.start();
    }

    private void setUserBtns() {
        user1Btn = findViewById(R.id.user1);
        user2Btn = findViewById(R.id.user2);
        user3Btn = findViewById(R.id.user3);
    }

    private void setBtnNames() {
        user1Btn.setText(btnName((users.get(0))));
        user2Btn.setText(btnName((users.get(1))));
        user3Btn.setText(btnName((users.get(2))));
    }

    private String btnName(User user) {
        if (user.getName() == null || user.getName().equals("null")) {
            return "New";
        } else {
            return user.getName();
        }
    }

    private void toUserSettings(User user) {
        Intent intent = new Intent(this, UserSetter.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toMathGame(User user) {
        Intent intent = new Intent(this, MathGameActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toSimonGame(User user) {
        Intent intent = new Intent(this, FlashColorsActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toRockPaperScissors(User user) {
        Intent intent = new Intent(this, RPSActivity.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toLeaderboard(User user) {
        Intent intent = new Intent(this, Leaderboard.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

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

    private void sendToNextScreen(User user) {
        if (hasName(user)) {
            sendToLevel(user);
            finish();
        } else {
            toUserSettings(user);
            finish();
        }
    }

    public void User1Btn(View view) {
        sendToNextScreen(users.get(0));
    }

    public void User2Btn(View view) {
        sendToNextScreen(users.get(1));
    }

    public void User3Btn(View view) {
        sendToNextScreen(users.get(2));
    }

    public void instructions(View view) {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
        finish();

    }

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
