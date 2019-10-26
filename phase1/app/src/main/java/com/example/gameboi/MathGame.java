package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MathGame extends AppCompatActivity {

    private int response = 0;
    private TextView responseView;
    private TextView equationDisplay;
    private TextView mathGameScore;
    private int answer = 0;
    private int score = 0;
    Random rand = new Random();

    private void updateResponse(int num) {response = response * 10 + num;}

    private void updateResponseView() {responseView.setText(String.valueOf(response));}

    private void generateEquation() {
        String[] operators = {" + ", " - ", " // ", " * "};
        int num1 = rand.nextInt(25) + 1;
        int num2 = rand.nextInt(10) + 1;

        int op = rand.nextInt(4);
        String equation = num1 + operators[op] + num2;
        equationDisplay.setText(equation);

        if (op == 0) {answer = num1 + num2;}
        else if (op == 1) {answer = num1 - num2;}
        else if (op == 2) {answer = num1 / num2;}
        else {answer = num1 * num2;}
    }

    private void clickNumButton(int num) {
        if (response < 100000) {
            updateResponse(num);
            updateResponseView();
        }
    }

    private void setupMathGameUI(){
        responseView = findViewById(R.id.responseView);
        equationDisplay = findViewById(R.id.equationDisplay);
        mathGameScore = findViewById(R.id.mathGameScore);
    }

    public void pressZero(View view) {clickNumButton(0);}
    public void pressOne(View view) {clickNumButton(1);}
    public void pressTwo(View view) {clickNumButton(2);}
    public void pressThree(View view) {clickNumButton(3);}
    public void pressFour(View view) {clickNumButton(4);}
    public void pressFive(View view) {clickNumButton(5);}
    public void pressSix(View view) {clickNumButton(6);}
    public void pressSeven(View view) {clickNumButton(7);}
    public void pressEight(View view) {clickNumButton(8);}
    public void pressNine(View view) {clickNumButton(9);}
    public void pressClear(View view) {
        response = 0;
        updateResponseView();
    }
    public void pressEnter(View view) {
        if (answer == response) {
            score += 1;
        }
        String currScore = "SCORE: " + score;
        mathGameScore.setText(currScore);
        generateEquation();
        response = 0;
        updateResponseView();
    }

    public void toNext(View view) {
        //says to switch from this activity to the next one
        Intent intent = new Intent(this, SimonGame.class);
        //EditText editText = (EditText) findViewById(R.id.editText); //look up the id for text user inputted
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message); //create key value pair
        startActivity(intent); //now intent has key value
        //goes to MathGame.class
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        setupMathGameUI();
        generateEquation();
    }
}