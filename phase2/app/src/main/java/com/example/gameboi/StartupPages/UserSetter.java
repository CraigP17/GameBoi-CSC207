package com.example.gameboi.StartupPages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
import android.widget.Button;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.R;
import com.example.gameboi.UserClasses.User;

import static android.graphics.Color.*;

public class UserSetter extends AppCompatActivity{

    //The user who is selecting their stats and customizations
    private User player;
    //The name to set for the player
    private String name;
    // A string representation for the icon they want to select. Will be used to show lives.
    private String icon;
    // The background color the player selects
    private int backgroundColor;
    // The number of lives that the player wants to play with
    private int numLives;
    // Displays the name the player selects
    private EditText nameInputField;
    // Btn for selecting boy icon
    private Button boyBtn;
    // Btn for selecting panada icon
    private Button pandaBtn;
    // Btn for selecting snake icon
    private Button snakeBtn;
    // Btns for selecting the preferred background color
    private Button whiteBtn;
    private Button greyBtn;
    private Button cyanBtn;
    // Btns for selecting the preferred number of lives the player wants to use
    private Button numLivesBtn1;
    private Button numLivesBtn2;
    private Button numLivesBtn3;
    // Btns for selecting the player's preferred difficulty
    private Button normalBtn;
    private Button hardBtn;
    // String for the difficulty that the player selected
    private String difficulty;

    /**
     * Sets player to the one sent to the activity and sets up the display.
     *
     * @param savedInstanceState the savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setter);
        player = getIntent().getParcelableExtra("player");
        setupUI();
    }

    /**
     * Sets up all the Btn and textview ids. Sets all btn colors to light grey.
     */
    private void setupUI() {
        nameInputField = findViewById(R.id.userName);
        boyBtn = findViewById(R.id.boyBtn);
        pandaBtn = findViewById(R.id.pandaBtn);
        snakeBtn = findViewById(R.id.snakeBtn);
        setBtnClr(boyBtn, LTGRAY, pandaBtn, LTGRAY, snakeBtn, LTGRAY);
        whiteBtn = findViewById(R.id.whiteBtn);
        greyBtn = findViewById(R.id.greyBtn);
        cyanBtn = findViewById(R.id.cyanBtn);
        setBtnClr(whiteBtn, LTGRAY, greyBtn, LTGRAY, cyanBtn, LTGRAY);
        numLivesBtn1 = findViewById(R.id.numLivesBtn1);
        numLivesBtn2 = findViewById(R.id.numLivesBtn2);
        numLivesBtn3 = findViewById(R.id.numLivesBtn3);
        setBtnClr(numLivesBtn1, LTGRAY, numLivesBtn2, LTGRAY, numLivesBtn3, LTGRAY);
        normalBtn = findViewById(R.id.normalBtn);
        hardBtn = findViewById(R.id.hardBtn);
        setBtnClr(normalBtn, LTGRAY, hardBtn, LTGRAY);
    }

    /**
     * Checks to make sure the user's input for the name is less than or equal to 6 characters and
     * greater than or equal to 1. Shows a toast informing the user of the restriction if they try
     * to enter a name too long or too short.
     *
     * @param view the current view
     */
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

    /**
     * Creates a random user name for the player.
     *
     * @param view the current view
     */
    public void randomUserName(View view) {
        String[] randomNames = {"2c00l", "H@xx0r", "Player", "a_name"};
        Random rand = new Random();
        int index = rand.nextInt(4);
        nameInputField.setText(randomNames[index]);
        name = randomNames[index];
    }

    /**
     * Sets colors for 3 buttons.
     *
     * @param btn1 a button
     * @param color1 color for the first button
     * @param btn2 a button
     * @param color2 color for second button
     * @param btn3 a button
     * @param color3 color for third button
     */
    private void setBtnClr(Button btn1, int color1,
                           Button btn2, int color2,
                           Button btn3, int color3) {
        btn1.setBackgroundColor(color1);
        btn2.setBackgroundColor(color2);
        btn3.setBackgroundColor(color3);
    }

    /**
     * Sets colors for 2 buttons.
     *
     * @param btn1 a button
     * @param color1 color for first button
     * @param btn2 a button
     * @param color2 color for second button
     */
    private void setBtnClr(Button btn1, int color1,
                           Button btn2, int color2) {
        btn1.setBackgroundColor(color1);
        btn2.setBackgroundColor(color2);
    }

    /**
     *  Sets icon to the string for the boy png. Set the color for the boy btn to dark grey and the
     *  other icon buttons to light grey
     *
     * @param view the current view
     */
    public void boyBTN(View view) {
        icon = "userlogo";
        setBtnClr(boyBtn, DKGRAY, pandaBtn, LTGRAY, snakeBtn, LTGRAY);
    }

    /**
     *  Sets icon to the string for the panda png. Set the color for the panda btn to dark grey and
     *  the other icon buttons to light grey
     *
     * @param view the current view
     */
    public void pandaBTN(View view) {
        icon = "panda";
        setBtnClr(boyBtn, LTGRAY, pandaBtn, DKGRAY, snakeBtn, LTGRAY);
    }

    /**
     *  Sets icon to the string for the snake png. Set the color for the snake btn to dark grey and
     *  the other icon buttons to light grey
     *
     * @param view the current view
     */
    public void snakeBTN(View view) {
        icon = "snake";
        setBtnClr(boyBtn, LTGRAY, pandaBtn, LTGRAY, snakeBtn, DKGRAY);
    }

    /**
     *  Sets background color to the white int. Set the color for the whiteBtn to dark grey and the
     *  other backgroundColor buttons to light grey
     *
     * @param view the current view
     */
    public void whiteBtn(View view) {
        backgroundColor = WHITE;
        setBtnClr(whiteBtn, DKGRAY, greyBtn, LTGRAY, cyanBtn, LTGRAY);
    }

    /**
     *  Sets background color to the grey int. Set the color for the greyBtn to dark grey and the
     *  other backgroundColor buttons to light grey
     *
     * @param view the current view
     */
    public void greyBtn(View view) {
        backgroundColor = GRAY;
        setBtnClr(whiteBtn, LTGRAY, greyBtn, DKGRAY, cyanBtn, LTGRAY);
    }

    /**
     *  Sets background color to the cyan int. Set the color for the cyanBtn to dark grey and the
     *  other backgroundColor buttons to light grey
     *
     * @param view the current view
     */
    public void cyanBtn(View view) {
        backgroundColor = CYAN;
        setBtnClr(whiteBtn, LTGRAY, greyBtn, LTGRAY, cyanBtn, DKGRAY);
    }

    /**
     *  Sets numLives to 1. Set the color for the numLivesBtn1 to dark grey and the
     *  other lives buttons to light grey
     *
     * @param view the current view
     */
    public void oneLife(View view) {
        numLives = 1;
        setBtnClr(numLivesBtn1, DKGRAY, numLivesBtn2, LTGRAY, numLivesBtn3, LTGRAY);
    }

    /**
     *  Sets numLives to 2. Set the color for the numLivesBtn2 to dark grey and the
     *  other lives buttons to light grey
     *
     * @param view the current view
     */
    public void twoLives(View view) {
        numLives = 2;
        setBtnClr(numLivesBtn1, LTGRAY, numLivesBtn2, DKGRAY, numLivesBtn3, LTGRAY);
    }

    /**
     *  Sets numLives to 3. Set the color for the numLivesBtn3 to dark grey and the
     *  other lives buttons to light grey
     *
     * @param view the current view
     */
    public void threeLives(View view) {
        numLives = 3;
        setBtnClr(numLivesBtn1, LTGRAY, numLivesBtn2, LTGRAY, numLivesBtn3, DKGRAY);
    }

    /**
     *  Sets difficulty to "Normal". Set the color for the normalBtn to dark grey and the
     *  other difficulty buttons to light grey
     *
     * @param view the current view
     */
    public void pressNormalBtn(View view) {
        difficulty = "Normal";
        setBtnClr(normalBtn, DKGRAY, hardBtn, LTGRAY);
    }

    /**
     *  Sets difficulty to "Hard". Set the color for the hardBtn to dark grey and the
     *  other difficulty buttons to light grey
     *
     * @param view the current view
     */
    public void pressHardBtn(View view) {
        difficulty = "Hard";
        setBtnClr(normalBtn, LTGRAY, hardBtn, DKGRAY);
    }

    /**
     * Sets all of the stats and customizations that the player chose
     */
    private void setPlayerStats() {
        player.setName(name);
        player.setIcon(icon);
        player.setLives(numLives);
        player.setOrigLives(numLives);
        player.setBackgroundColor(backgroundColor);
        player.setDifficulty(difficulty);
    }

    /**
     * Checks at that least one option from each category (name, icon, backgroundColor, numLives and
     * Difficulty) was selected by the player and that the name is valid. If they are, Sets that
     * stats for player and goes back to MainActivity screen.
     *
     * @param view the current view
     */
    public void submitCustomizations(View view){
        checkNameInput(view);
        if (name != null && icon != null && backgroundColor != 0 &&
                numLives != 0 && difficulty != null) {
            setPlayerStats();
            FileManager fm = new FileManager(this);
            fm.saveNewUser(player);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {}
}
