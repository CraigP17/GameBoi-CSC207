package com.example.gameboi;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Collections;

/*The following class is responsible for storing the user playing the FlashColors as well as the
* score during the game and the correct color pattern and user color patterns. This class acts as
* the back end to SimonGame.java*/
class FlashColors {

    private User player;
    private int localScore; //set to zero for now

    FlashColors(){
        this.localScore = 0;
    }

    ArrayList<Integer> generatePattern(){
        ArrayList<Integer> pattern = new ArrayList<>();
        pattern.add(Color.RED);
        pattern.add(Color.GREEN);
        pattern.add(Color.BLUE);
        pattern.add(Color.YELLOW);

        Collections.shuffle(pattern);

        return pattern;
    }

    int getLocalScore() {
        return localScore;
    }

    void setLocalScore(int localScore) {
        this.localScore += localScore;
    }

    public void setPlayer(User player) {
        this.player = player;
    }
}
