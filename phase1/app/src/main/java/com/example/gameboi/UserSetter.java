package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class UserSetter extends AppCompatActivity{

    private String name;
    private String icon;
    private Color BackgroundColor;
    private int numLives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setter);
    }
}
