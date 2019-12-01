package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.MathGame.GameFacade;
import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

public abstract class RPSAbstract extends GameFacade {
    /**
     * Superclass for RPSCaclEasy and RPSCalcHard and any levels required for RPS game.
     * Subclasses must Implement all methods in this class except checker.
     * All backend classes for games in Gameboi extend from GameFacade.
     */

    static int winsRpS = 0;
    static int lossesRpS = 0;


    /**
     * Constructor for object, must have a player stored in superclass
     */
    RPSAbstract(User player) {
        super(player);
        score = winsRpS + player.getPoints();
    }

    /**
     * Builds a hashmap depending on possibilities for user choices in this difficulty, values are
     * computer choice possibilites which will cause user to win the round.
     */
    abstract HashMap buildMap();


    /**
     * Depending on difficulty,
     */
    abstract String[] RpSGamePlayed(String playerValue);

    String[] checker(String result, String userchoice, String compchoice) {

        if (userchoice.equals("Scissors") && compchoice.equals("Rock")) {
            setFoundHiddenFeature();
        }

        String[] array;
        if (lossesRpS == 2) {
            lossesRpS = 0;
            winsRpS = 0;

            array = new String[] {userchoice, compchoice, "FlashLoss", result};
            winner = false;
        } else if (winsRpS == 3) {
            winsRpS = 0;
            lossesRpS = 0;
            array = new String[] {userchoice, compchoice, "FlashWin", result};
            winner = true;
        } else {
            array = new String[] {userchoice, compchoice, "Round", result};
            winner = false;
        }
        return array;
    }

    @Override
    public boolean isGameOver() {
        return (winsRpS == 3 || lossesRpS == 2);
    }

    @Override
    public boolean checkHidden() {
        if (getFoundHiddenFeature()) {
            return true;
        } else {
            return false;
        }

    }

}
