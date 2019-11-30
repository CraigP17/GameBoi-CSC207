package com.example.gameboi.FlashColors;

import android.graphics.Color;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class FlashColorsOperationsHard extends FlashColorsOperations {

    FlashColorsOperationsHard(User player) {
        super(player);
        this.special = new ArrayList<>(Arrays.asList(Color.BLUE,Color.WHITE,Color.RED,
                Color.GREEN,Color.YELLOW,Color.BLACK));
    }

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

    @Override
    boolean checkHidden() {
        return userPattern.equals(special);
    }
}
