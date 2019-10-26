package com.example.gameboi;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;

class FlashColors {

    private User player;

    FlashColors(User player){
        this.player = player;
    }

    private ArrayList<Integer> generatePattern(){
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);

        Collections.shuffle(pattern);

        return pattern;
    }
}
