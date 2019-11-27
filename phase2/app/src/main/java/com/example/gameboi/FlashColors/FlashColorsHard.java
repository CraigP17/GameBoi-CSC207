package com.example.gameboi.FlashColors;

import android.graphics.Color;

import com.example.gameboi.UserClasses.User;

import java.util.ArrayList;
import java.util.Collections;

public class FlashColorsHard extends FlashColors {

    FlashColorsHard(User player) {
        super(player);
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
        return pattern;
    }
}
