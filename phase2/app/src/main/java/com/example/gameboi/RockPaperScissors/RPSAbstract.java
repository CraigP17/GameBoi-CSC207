package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.MathGame.GameFacade;
import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

public abstract class RPSAbstract extends GameFacade {

    static int winsRpS = 0;
    static int lossesRpS = 0;
    static boolean notFoundhiddenFeature = true;

    RPSAbstract(User player) {

        super(player);
        score = winsRpS + player.getPoints();
    }

    abstract HashMap buildMap();

    abstract String[] RpSGamePlayed(String playerValue);

    String[] checker(String userchoice, String compchoice) {

        String[] array;
        if (lossesRpS == 2) {
            lossesRpS = 0;
            winsRpS = 0;
            notFoundhiddenFeature = true;
            array = new String[] {userchoice, compchoice, "FlashLoss"};

        } else if (winsRpS == 3) {
            winsRpS = 0;
            lossesRpS = 0;
            notFoundhiddenFeature = true;
            array = new String[] {userchoice, compchoice, "FlashWin"};
            winner = true;
        } else {
            array = new String[] {userchoice, compchoice, "Round"};
        }
        return array;
    }

    @Override
    public boolean isGameOver() {
        return (winsRpS == 3 || lossesRpS == 2);
    }

}
