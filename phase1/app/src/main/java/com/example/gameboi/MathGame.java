package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

// Um so... this code is really bad. I'm not this awful at CS, I promise. I just wrote
// this up quickly.
//
//
// Also there's a low chance rn that the answer will be a negative number which is impossible to
// input given the current layout.

public class MathGame extends AppCompatActivity {

    private int response = 0;
    private TextView responseView;
    private TextView equationDisplay;
    private TextView mathGameScore;
    private int answer = 0;
    private int score = 0;
    Random rand = new Random();
    String[] operators = {" + ", " - ", " // ", " * "};

    private void updateResponse(int num) {
        response = response * 10 + num;
    }

    private void updateResponseView() {
        responseView.setText(String.valueOf(response));
    }

    private void generateEquation() {
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

        Button zero = findViewById(R.id.btn0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(0);
            }
        });

        Button one = findViewById(R.id.btn1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(1);
            }
        });

        Button two = findViewById(R.id.btn2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(2);
            }
        });

        Button three = findViewById(R.id.btn3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(3);
            }
        });

        Button four = findViewById(R.id.btn4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(4);
            }
        });

        Button five = findViewById(R.id.btn5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(5);
            }
        });

        Button six = findViewById(R.id.btn6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(6);
            }
        });

        Button seven = findViewById(R.id.btn7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(7);
            }
        });

        Button eight = findViewById(R.id.btn8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(8);
            }
        });

        Button nine = findViewById(R.id.btn9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumButton(9);
            }
        });

        Button clear = findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = 0;
                updateResponseView();
            }
        });

        Button enter = findViewById(R.id.btnEnter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == response) {
                    score += 1;
                }
                mathGameScore.setText("SCORE: " + String.valueOf(score));
                generateEquation();
                response = 0;
                updateResponseView();
            }
        });

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

