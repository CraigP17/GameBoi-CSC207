package com.example.gameboi.BonusSpinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.R;

import java.util.Random;

public class BonusSpinner extends AppCompatActivity {

    // The degree is what the spinner lands on
    private int degree = 0;

    // Dedicated class for calculating sections of what the wheel lands on
    private SpinnerCalc spinnerCalc = new SpinnerCalc();

    // Instance of random, to randomly spin the wheel
    private final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_spinner);
    }

    /**
     * Spins the wheel and calculates which section of the wheel it was landed on
     * @param v View
     */
    public void spin(View v) {
        // The degree that the spinner was on
        int degreeOld = degree % 360;

        // Calculate the random angle that the spinner wheel should rotate and land on
        // Add 720 to allow the spinner to spin at least twice before landing
        degree = RANDOM.nextInt(360) + 720;

        // Rotate animations
        RotateAnimation rotateAnim = new RotateAnimation(degreeOld, degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(3600);
        rotateAnim.setFillAfter(true);
        rotateAnim.setInterpolator(new DecelerateInterpolator());

        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // we empty the result text view when the animation start
                TextView multiplier = findViewById(R.id.multi);
                multiplier.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Display the correct sector pointed by the triangle at the end of the rotate animation
                TextView multiplier = findViewById(R.id.multi);
                multiplier.setText(spinnerCalc.getWheelSection(360 - (degree % 360)));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ImageView spinner = findViewById(R.id.Spinner);
        spinner.startAnimation(rotateAnim);
    }


    /**
     * Takes the user to the next level or to the final leaderrboard if they have completed the game
     */
    public void nextGame(View view) {

    }


}
