package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

public class RPSCalcHard extends RPSAbstract {
    private String[] arr = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    private String computerChoice;
    private String playerChoice;

    RPSCalcHard(User player) {
        super(player);
    }

    @Override
    HashMap buildMap() {
        HashMap<String, String[]> outcome = new HashMap<>();
        outcome.put("Rock", new String[] {"Scissors", "Lizard"});
        outcome.put("Paper", new String[] {"Spock", "Rock"});
        outcome.put("Scissors", new String[] {"Paper", "Lizard"});
        outcome.put("Lizard", new String[] {"Paper", "Spock"});
        outcome.put("Spock", new String[] {"Scissors", "Rock"});
        return outcome;
    }

    @Override
    String[] RpSGamePlayed(String playerValue) {

        playerChoice = playerValue;
        Random rand = new Random();
        int p = rand.nextInt(10);
        if (p < 3) {
            return randomAnswer(playerValue);
        } else {
            return winAnswer(playerValue);
        }
    }

    private String[] randomAnswer(String playerValue) {
        HashMap<String, String[]> outcome = new HashMap<>();

        Random rand = new Random();
        computerChoice = arr[rand.nextInt(arr.length)];
        for (String s : outcome.get(playerValue)) {
            if (s.equals(computerChoice)) {
                winsRpS++;
                return checker(playerValue, computerChoice);
            }
        }
        if (!playerValue.equals(computerChoice)) {
            lossesRpS++;
            return checker(playerValue, computerChoice);
        } else {
            return checker(playerValue, computerChoice);
        }
    }

    private String[] winAnswer(String playerValue) {
        HashMap<String, String[]> outcome = new HashMap<>();
        Random rand = new Random();
        winsRpS++;
        return checker(playerValue, outcome.get(playerValue)[rand.nextInt(2)]);
    }

    @Override
    public boolean checkHidden(){
        return (playerChoice.equals("Scissors") && computerChoice.equals("Rock"));

    }
}
