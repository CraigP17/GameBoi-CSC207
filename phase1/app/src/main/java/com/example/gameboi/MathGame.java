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
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button clear;
    private Button enter;
    private TextView responseView;
    private TextView equationDisplay;
    private TextView mathGameScore;
    private String equation;
    private int answer = 0;
    private int score = 0;
    Random rand = new Random();
    String[] operators = {" + ", " - ", " // ", " * "};

    private void generateEquation() {
        int num1 = rand.nextInt(25) + 1;
        int num2 = rand.nextInt(10) + 1;

        int op = rand.nextInt(4);
        equation = String.valueOf(num1) + operators[op] + String.valueOf(num2);
        equationDisplay.setText(equation);

        if (op == 0) {answer = num1 + num2;}
        else if (op == 1) {answer = num1 - num2;}
        else if (op == 2) {answer = num1 / num2;}
        else {answer = num1 * num2;}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        setupMathGameUI();
        generateEquation();
    }

    private void setupMathGameUI(){

        responseView = (TextView) findViewById(R.id.responseView);
        equationDisplay = (TextView) findViewById(R.id.equationDisplay);
        mathGameScore = (TextView) findViewById(R.id.mathGameScore);

        zero = (Button) findViewById(R.id.btn0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(0);
                    updateResponseView();
                }
            }
        });

        one = (Button) findViewById(R.id.btn1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(1);
                    updateResponseView();
                }
            }
        });

        two = (Button) findViewById(R.id.btn2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(2);
                    updateResponseView();
                }
            }
        });

        three = (Button) findViewById(R.id.btn3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(3);
                    updateResponseView();
                }
            }
        });

        four = (Button) findViewById(R.id.btn4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(4);
                    updateResponseView();
                }
            }
        });

        five = (Button) findViewById(R.id.btn5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(5);
                    updateResponseView();
                }
            }
        });

        six = (Button) findViewById(R.id.btn6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(6);
                    updateResponseView();
                }
            }
        });

        seven = (Button) findViewById(R.id.btn7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(7);
                    updateResponseView();
                }
            }
        });

        eight = (Button) findViewById(R.id.btn8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(8);
                    updateResponseView();
                }
            }
        });

        nine = (Button) findViewById(R.id.btn9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response < 100000) {
                    updateResponse(9);
                    updateResponseView();
                }
            }
        });

        clear = (Button) findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = 0;
                updateResponseView();
            }
        });

        enter = (Button) findViewById(R.id.btnEnter);
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

    private void updateResponse(int num) {
        response = response * 10 + num;
    }

    private void updateResponseView() {
        responseView.setText(String.valueOf(response));
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
}

