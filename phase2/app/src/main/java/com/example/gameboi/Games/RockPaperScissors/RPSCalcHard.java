package com.example.gameboi.Games.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

/**
 * Calculator for RPS game for difficulty hard
 */
class RPSCalcHard extends RPSAbstract {
    /**
     * Possibilites of choices in this difficulty
     */
    private String[] arr = new String[]{"Rock", "Paper", "Scissors", "Lizard", "Spock"};

    /**
     * Stores computers pick for the round
     */
    public String computerChoice;

    /**
     * Stores players pick for the round
     */
    public String playerChoice;

    RPSCalcHard(User player) {
        super(player);
    }

    /**
     * Builds map for easy using rock paper scissors lizard and spock
     */
    @Override
    HashMap buildMap() {
        HashMap<String, String[]> outcome = new HashMap<>();
        outcome.put("Rock", new String[]{"Scissors", "Lizard"});
        outcome.put("Paper", new String[]{"Spock", "Rock"});
        outcome.put("Scissors", new String[]{"Paper", "Lizard"});
        outcome.put("Lizard", new String[]{"Paper", "Spock"});
        outcome.put("Spock", new String[]{"Scissors", "Rock"});
        return outcome;
    }

    /**
     * Using player value, determines computer value calls checker to return which intent to start
     * next.
     */
    @Override
    String[] RpSGamePlayed(String playerValue) {

        Random rand = new Random();
        int p = rand.nextInt(10);
        if (p < 3) {
            //possibility of winning is random, not chosen often
            return randomAnswer(playerValue);
        } else {
            //computer always wins
            return winAnswer(playerValue);
        }
    }


    private String[] randomAnswer(String playerValue) {
        HashMap<String, String[]> outcome = buildMap();

        Random rand = new Random();
        computerChoice = arr[rand.nextInt(arr.length)];

        playerChoice = playerValue;

        if (playerChoice.equals("Scissors") && computerChoice.equals("Lizard")){
            notFoundhiddenFeature = false;
        }

        for (String s : outcome.get(playerValue)) {
            if (s.equals(computerChoice)) {
                winsRpS++;
                return checker("Won", playerValue, computerChoice);
            }
        }
        if (!playerValue.equals(computerChoice)) {
            lossesRpS++;
            return checker("Loss", playerValue, computerChoice);
        } else {
            return checker("Tie", playerValue, computerChoice);
        }
    }

    private String[] winAnswer(String playerValue) {
        HashMap<String, String[]> outcome = buildMap();
        Random rand = new Random();
        winsRpS++;
        playerChoice = playerValue;
        computerChoice = outcome.get(playerValue)[rand.nextInt(2)];

        if (playerChoice.equals("Scissors") && computerChoice.equals("Lizard")){
            notFoundhiddenFeature = false;
        }

        lossesRpS++;
        return checker("Loss", playerValue, computerChoice);
    }

    @Override
    public boolean checkHidden() {
        if (playerChoice.equals("Scissors") && computerChoice.equals("Lizard") && !notFoundhiddenFeature) {
            return true;
        } else {
            return false;
        }
    }

}
