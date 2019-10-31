package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        /*ArrayList<User> u = f.getUsers();
        System.out.println(u.get(0).getBackgroundColor());
        System.out.println(u.get(1).getBackgroundColor());
        System.out.println(u.get(2).getBackgroundColor());*/
    }

    private void setUserBtns() {
        user1Btn = (Button) findViewById(R.id.user1);
        user2Btn = (Button) findViewById(R.id.user2);
        user3Btn = (Button) findViewById(R.id.user3);
    }

    private void setBtnNames(){
        user1Btn.setText(btnName((users.get(0))));
        user2Btn.setText(btnName((users.get(1))));
        user3Btn.setText(btnName((users.get(2))));
    }

    private String btnName(User user){
        if (user.getName() == null) {return "New";}
        else {return user.getName();}
    }

    private void toUserSettings(View view, User user) {
        Intent intent = new Intent(this, UserSetter.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toMathGame(View view, User user) {
        Intent intent = new Intent(this, MathGame.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toSimonGame(View view, User user) {
        Intent intent = new Intent(this, SimonGame.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void toRockPaperScissors(View view, User user){
        Intent intent = new Intent(this, RockPaperScissors.class);
        intent.putExtra("player", user);
        startActivity(intent);
    }

    private void sendToLevel(View view, User user) {
        if (user.getCurrLevel() == 0) { toMathGame(view,user);}
        else if (user.getCurrLevel() == 1) { toSimonGame(view,user);}
        else if (user.getCurrLevel() == 2) { toRockPaperScissors(view,user);}
    }

    private void sendToNextScreen(View view, User user){
        if (hasName(user)) {
            sendToLevel(view, user);
        }
        else {
            toUserSettings(view, user);
        }
    }

    public void User1Btn(View view) {
        sendToNextScreen(view, users.get(0));
    }

    public void User2Btn(View view) {
        sendToNextScreen(view, users.get(1));
    }

    public void User3Btn(View view) {
        sendToNextScreen(view, users.get(2));
    }

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
