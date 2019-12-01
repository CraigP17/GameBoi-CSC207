package com.example.gameboi.Games.RockPaperScissors;

import com.example.gameboi.Games.GameFacade;
import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

/**
 * Superclass for RPSCaclEasy and RPSCalcHard and any levels required for RPS game.
 * Subclasses must Implement all methods in this class except checker.
 * All backend classes for games in Gameboi extend from GameFacade.
 */
public abstract class RPSAbstract extends GameFacade {

    /**
     * Number of rounds won
     */
    static int winsRpS = 0;

    /**
     * Number of rounds lost
     */
    static int lossesRpS = 0;

    /**
     * Variable to say if hiddenFeature was found
     */
    static boolean notFoundhiddenFeature = true;

    /**
     * Constructor for object, must have a player stored in superclass
     */

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
     * Depending on difficulty, chooses a computers choice and determines if user won or lost.
     */
    abstract String[] RpSGamePlayed(String playerValue);


    /**
     * Returns array to RPSActivity determining which intent to start next depending on result and
     * number of rounds won or lost
     */
    String[] checker(String result, String userchoice, String compchoice) {

        String[] array;
        if (lossesRpS == 2) {
            lossesRpS = 0;
            winsRpS = 0;
            notFoundhiddenFeature = true;
            array = new String[]{userchoice, compchoice, "FlashLoss", result};
            winner = false;
        } else if (winsRpS == 3) {
            winsRpS = 0;
            lossesRpS = 0;
            notFoundhiddenFeature = true;
            array = new String[]{userchoice, compchoice, "FlashWin", result};
            winner = true;
        } else {
            array = new String[]{userchoice, compchoice, "Round", result};
            winner = false;
        }
        return array;
    }

    /**
     * Returns a boolean, true if game is over or false if there are remaining rounds to play.
     */
    @Override
    public boolean isGameOver() {
        return (winsRpS == 3 || lossesRpS == 2);
    }

}
