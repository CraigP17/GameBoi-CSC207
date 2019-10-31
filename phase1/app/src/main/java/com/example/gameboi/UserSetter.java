package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
import android.widget.Button;

import static android.graphics.Color.*;

public class UserSetter extends AppCompatActivity{

    private String name;
    private String icon;
    private int backgroundColor;
    private int numLives;
    private EditText nameInputField;
    private Button boyBtn;
    private Button girlBtn;
    private Button snakeBtn;
    private Button whiteBtn;
    private Button greyBtn;
    private Button cyanBtn;
    private Button numLivesBtn1;
    private Button numLivesBtn2;
    private Button numLivesBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setter);
        nameInputField = findViewById(R.id.userName);
        boyBtn = findViewById(R.id.boyBtn);
        girlBtn = findViewById(R.id.girlBtn);
        snakeBtn = findViewById(R.id.snakeBtn);
        setIconBtnClr(LTGRAY, LTGRAY, LTGRAY);
        whiteBtn = findViewById(R.id.whiteBtn);
        greyBtn = findViewById(R.id.greyBtn);
        cyanBtn = findViewById(R.id.cyanBtn);
        setBGCBtnClr(LTGRAY, LTGRAY, LTGRAY);
        numLivesBtn1 = findViewById(R.id.numLivesBtn1);
        numLivesBtn2 = findViewById(R.id.numLivesBtn2);
        numLivesBtn3 = findViewById(R.id.numLivesBtn3);
        setLifeBtnClr(LTGRAY, LTGRAY, LTGRAY);
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

    private void setIconBtnClr(int color1, int color2, int color3){
        boyBtn.setBackgroundColor(color1);
        girlBtn.setBackgroundColor(color2);
        snakeBtn.setBackgroundColor(color3);
    }

    private void setBGCBtnClr(int color1, int color2, int color3){
        whiteBtn.setBackgroundColor(color1);
        greyBtn.setBackgroundColor(color2);
        cyanBtn.setBackgroundColor(color3);
    }

    private void setLifeBtnClr(int color1, int color2, int color3){
        numLivesBtn1.setBackgroundColor(color1);
        numLivesBtn2.setBackgroundColor(color2);
        numLivesBtn3.setBackgroundColor(color3);
    }

    public void boyBTN(View view) {
        icon = "userlogo";
        setIconBtnClr(DKGRAY, LTGRAY, LTGRAY);
    }
    public void girlBTN(View view) {
        icon = "girl";
        setIconBtnClr(LTGRAY, DKGRAY, LTGRAY);
    }

    public void snakeBTN(View view) {
        icon = "snake";
        setIconBtnClr(LTGRAY, LTGRAY, DKGRAY);
    }
    public void whiteBtn(View view) {
        backgroundColor = WHITE;
        setBGCBtnClr(DKGRAY, LTGRAY, LTGRAY);
    }
    public void greyBtn(View view) {
        backgroundColor = GRAY;
        setBGCBtnClr(LTGRAY, DKGRAY, LTGRAY);
    }
    public void cyanBtn(View view) {
        backgroundColor = CYAN;
        setBGCBtnClr(LTGRAY, LTGRAY, DKGRAY);
    }
    public void oneLife(View view) {
        numLives = 1;
        setLifeBtnClr(DKGRAY, LTGRAY, LTGRAY);
    }
    public void twoLives(View view) {
        numLives = 2;
        setLifeBtnClr(LTGRAY, DKGRAY, LTGRAY);
    }
    public void threeLives(View view) {
        numLives = 3;
        setLifeBtnClr(LTGRAY, LTGRAY, DKGRAY);
    }

    public void submitCustomizations(View view){
        checkNameInput(view);
        if (name != null && icon != null && backgroundColor != 0 && numLives != 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //Want to save changes made to this user...
        }
    }
}
