package com.example.gameboi.Games.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

/**
 * Calculator for RPS game for difficulty easy
 */
public class RPSCalcEasy extends RPSAbstract {

    /**
     * Possibilites of choices in this difficulty
     */
    private String[] arr = new String[]{"Rock", "Paper", "Scissors"};

    /**
     * Stores computers pick for the round
     */
    public String computerChoice;

    /**
     * Stores players pick for the round
     */
    public String playerChoice;

    RPSCalcEasy(User player) {
        super(player);
    }

    /**
     * Builds map for easy only using rock paper and scissors
     */
    public HashMap buildMap() {
        HashMap<String, String> winnersRpS = new HashMap<>();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");
        return winnersRpS;
    }

    /**
     * Using player value, determines computer value calls checker to return which intent to start
     * next.
     */
    public String[] RpSGamePlayed(String playerValue) {
        HashMap<String, String> winnersRpS = buildMap();

        Random rand = new Random();
        //choose random computer choice from arr
        computerChoice = arr[rand.nextInt(arr.length)];
        playerChoice = playerValue;

        if (playerChoice.equals("Scissors") && computerChoice.equals("Rock")){
            notFoundhiddenFeature = false;
        }

        if (winnersRpS.get(playerValue).equals(computerChoice)) {
            //user wins, add to wins
            winsRpS += 1;
            incrementScore(); //increments different score in superclass
            return checker("Won", playerValue, computerChoice);
        } else if (computerChoice.equals(playerValue)) {
            // tie game
            return checker("Tie", playerValue, computerChoice);
        } else {
            //comp wins, add to losses
            lossesRpS += 1;
            return checker("Loss", playerValue, computerChoice);
        }

    }

    @Override
    public boolean checkHidden() {
        if (playerChoice.equals("Scissors") && computerChoice.equals("Rock") && !notFoundhiddenFeature) {
            return true;
        } else {
            return false;
        }
    }

}
