package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private User[] users;
    private Button user1Btn;
    private Button user2Btn;
    private Button user3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Call on FileManager
        //Set array/list Users
        User user1 = new User("sarrah", 2, 10, 20, 30, Color.GRAY, "girl", 2, 1);
        User user2 = new User(null, 0, 0, 0, 0, 0, null, 0, 0);
        User user3 = new User(null, 0, 0, 0, 0, 0, null, 0, 0);
        users = new User[]{user1, user2, user3};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUserBtns();
        setBtnNames();
    }

    private void setUserBtns() {
        user1Btn = findViewById(R.id.user1);
        user2Btn = findViewById(R.id.user2);
        user3Btn = findViewById(R.id.user3);
    }

    private void setBtnNames(){
        user1Btn.setText(btnName((users[0])));
        user2Btn.setText(btnName((users[1])));
        user3Btn.setText(btnName((users[2])));
    }

    private String btnName(User user){
        if (user.getName() == null) {return "New";}
        else {return user.getName();}
    }

    private void toUserSettings() {
        Intent intent = new Intent(this, UserSetter.class);
        startActivity(intent);
    }

    private void toMathGame() {
        Intent intent = new Intent(this, MathGame.class);
        startActivity(intent);
    }

    private void toSimonGame() {
        Intent intent = new Intent(this, SimonGame.class);
        startActivity(intent);
    }

    private void toRockPaperScissors(){
        Intent intent = new Intent(this, RockPaperScissors.class);
        startActivity(intent);
    }

    private void sendToLevel(User user) {
        if (user.getCurrLevel() == 1) { toMathGame();}
        else if (user.getCurrLevel() == 2) { toSimonGame();}
        else if (user.getCurrLevel() == 3) { toRockPaperScissors();}
        // Redundant else if statement but it makes it clear what's going on doesn't really impact
        // performance
    }

    private void sendToNextScreen(User user){
        if (hasName(user)) {
            sendToLevel(user);
        }
        else {
            toUserSettings();
        }
    }

    public void User1Btn(View view) { sendToNextScreen(users[0]); }
    public void User2Btn(View view) { sendToNextScreen(users[1]); }
    public void User3Btn(View view) { sendToNextScreen(users[2]); }

    private boolean hasName(User user){
        return user.getName() != null;
    }

    /** Called when the user taps the Send button */
    public void toNext(View view) {
        //says to switch from this activity to the next one
        Intent intent = new Intent(this, MathGame.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        startActivity(intent); //now intent has key value
        //goes to MathGame.class
    }
}
