package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class UserSetter extends AppCompatActivity{

    private String name;
    private String icon;
    private int backgroundColor;
    private int numLives;
    private EditText nameInputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setter);
        nameInputField = findViewById(R.id.userName);
    }

    public void checkNameInput(View view){
        String username = nameInputField.getText().toString();
        if (username.length() <= 6 && username.length() >= 1) {
            name = username;
        }
        else {
            Toast nameTooLong = Toast.makeText(getApplicationContext(),
                    "Usernames must be less than 7 characters and more than 0",
                    Toast.LENGTH_SHORT);
            nameTooLong.show();
        }
    }

    public void randomUserName(View view) {
        String[] randomNames = {"2c00l", "H@xx0r", "Player", "a_name"};
        Random rand = new Random();
        int index = rand.nextInt(4);
        nameInputField.setText(randomNames[index]);
        name = randomNames[index];
    }

    public void boyBTN(View view) {icon = "userlogo";}
    public void girlBTN(View view) {icon = "girl";}
    public void snakeBTN(View view) {icon = "snake";}
    public void whiteBtn(View view) {backgroundColor = Color.WHITE;}
    public void greyBtn(View view) {backgroundColor = Color.GRAY;}
    public void cyanBtn(View view) {backgroundColor = Color.CYAN;}
    public void oneLife(View view) {numLives = 1;}
    public void twoLives(View view) {numLives = 2;}
    public void threeLives(View view) {numLives = 3;}

    public void submitCustomizations(View view){
        if (name != null && icon != null && backgroundColor != 0 && numLives != 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //Want to save changes made to this user...
        }
    }
}
