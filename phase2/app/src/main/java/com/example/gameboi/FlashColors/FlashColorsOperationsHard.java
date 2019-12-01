package com.example.gameboi.FlashColors;

import android.graphics.Color;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class extends FlashColorsOperations and is responsible for operating the game when mode Hard
 * is chosen.
 */
class FlashColorsOperationsHard extends FlashColorsOperations {

    /**Constructs a game in hard mode, setting the special feature to a new operating
     * @param player The player of the game
     */
    FlashColorsOperationsHard(User player) {
        super(player);
        this.special = new ArrayList<>(Arrays.asList(Color.BLUE,Color.WHITE,Color.RED,
                Color.GREEN,Color.YELLOW,Color.BLACK));
    }

    /**
     * @return a list of colors which the user must try to match
     */
    @Override
    ArrayList<Integer> generatePattern(){
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);
        pattern.add(Color.BLACK);
        pattern.add(Color.WHITE);

        Collections.shuffle(pattern);
        correctPattern = pattern;
        System.out.println(pattern);
        System.out.println("IM ON HARD GENERATE");
        return pattern;
    }

    /**
     * @return sends a color pattern to FlashColorsActivity to be displayed
     */
    ArrayList<Integer> DisplayColors(){
        ArrayList<Integer> pattern;
        if(isSubmitted){
            setSubmitted(false);
            pattern = generatePattern();
            return pattern;
        }
        pattern = getCorrectPattern();
        System.out.println("IM ON NORMAL GENERATE");
        return pattern;
    }

    /**
     * @return true if the user's inputted pattern is the same as the hidden feature
     */
    @Override
    boolean checkHidden() {
        return userPattern.equals(special);
    }
}
