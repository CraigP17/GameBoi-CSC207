package com.example.gameboi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
/*
The MathGame class.

Asks the user a series of questions arithmetic questions.
 */
public class MathGame extends AppCompatActivity {

    // int representation of user's response.
    private int response = 0;
    //The response displayed for the user in a TextView.
    private TextView responseView;
    //Displays the Current math question.
    private TextView equationDisplay;
    //Displays the number of questions the user has answered correctly.
    private TextView mathGameScore;
    //int representation of the user's answer.
    private int answer = 0;
    //The number of questions the player got wrong
    private int numLosses = 0;
    //int representation of the number of questions the user has answered correctly.
    private int score = 0;
    User player = new User("moogah", 2, 0, 0 ,0,
            Color.GRAY, "fds", 0, 0);
    Random rand = new Random();

    private void updateResponse(int num) {response = response * 10 + num;}

    private void updateResponseView() {responseView.setText(String.valueOf(response));}

    private void isGameOver(){
        if (numLosses > 2) {
            player.loseALife();
            Intent intent = new Intent(this, SimonGame.class);
            intent.putExtra("user", player);
            startActivity(intent);
            finish();
        }
    }

    //Generates an arithmetic question for the player
    private void generateEquation() {
        String[] operators = {" + ", " - ", " // ", " * "};
        int num1 = rand.nextInt(25) + 1;
        int num2 = rand.nextInt(10) + 1;

        //Randomly selects whether its an addition, subtraction, multiplication or division question
        int op = rand.nextInt(4);

        //Checks for which operation was selected from operators
        if (op == 0) {answer = num1 + num2;}
        else if (op == 1) {
            //In the case of subtraction, does not allow for the answer to be a negative number
            if (num1 < num2){
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            answer = num1 - num2;
        }
        else if (op == 2) {answer = num1 / num2;}
        else {answer = num1 * num2;}

        //Displays the equation for the user
        String equation = num1 + operators[op] + num2;
        equationDisplay.setText(equation);
    }

    // Method takes the number of the button pressed and updates the response and responseView
    // The player response cannot exceed 1000000
    private void clickNumButton(int num) {
        if (response < 100000) {
            updateResponse(num);
            updateResponseView();
        }
    }

    //Sets up the displays for the player's input, the math question and current score.
    private void setupMathGameUI(){
        responseView = findViewById(R.id.responseView);
        equationDisplay = findViewById(R.id.equationDisplay);
        mathGameScore = findViewById(R.id.mathGameScore);
    }

    // Methods for the calculator buttons
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

    //Resets response to Zero and updates the responseView
    public void pressClear(View view) {
        response = 0;
        updateResponseView();
    }

    // Checks if the response is correct and adds 1 to score if it is. Updates score, resets
    // response and generates a new equation for the player
    public void pressEnter(View view) {
        if (answer == response) {score += 1;}
        else {
            numLosses += 1;
            isGameOver();
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
        // Send the user to the second game level
        intent.putExtra("user", player);
        startActivity(intent); //now intent has key value
        //goes to MathGame.class
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        setupMathGameUI();
        ImageView icon = findViewById(R.id.avatarIcon);
        icon.setImageResource(R.drawable.userlogo);
        getWindow().getDecorView().setBackgroundColor(player.getBackgroundColor());
        generateEquation();
    }
}