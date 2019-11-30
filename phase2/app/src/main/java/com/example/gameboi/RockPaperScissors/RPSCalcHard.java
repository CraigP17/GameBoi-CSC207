package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

public class RPSCalcHard extends RPSabstract {
    private String[] arr = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    private static int winsRpS = 0;
    private static int lossesRpS = 0;
    private User player;



    RPSCalcHard(User player) {
        super();
        this.player = player;
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
        String computerchoice = arr[rand.nextInt(arr.length)];
        for (String s : outcome.get(playerValue)) {
            if (s.equals(computerchoice)) {
                winsRpS++;
                return checker(playerValue, computerchoice);
            }
        }
        if (!playerValue.equals(computerchoice)) {
            lossesRpS++;
            return checker(playerValue, computerchoice);
        } else {
            return checker(playerValue, computerchoice);
        }
    }

    private String[] winAnswer(String playerValue) {
        HashMap<String, String[]> outcome = new HashMap<>();
        Random rand = new Random();
        winsRpS++;
        return checker(playerValue, outcome.get(playerValue)[rand.nextInt(2)]);
    }



    @Override
    String[] checker(String userchoice, String compchoice) {
        String[] array;
        if (lossesRpS == 2) {
            lossesRpS = 0;
            winsRpS = 0;
            if (this.player.getLives() == 1) {
                array = new String[] {userchoice, compchoice, "FlashLoss"};
            } else {
                array = new String[] {userchoice, compchoice, "FlashWin"};
            }
        } else if (winsRpS == 3) {
            lossesRpS = 0;
            winsRpS = 0;
            array = new String[] {userchoice, compchoice, "FlashWin"};
        } else {
            array = new String[] {userchoice, compchoice, "WonRound"};
        }
        return array;
    }

//    @Override
//    int getWins() {
//        return winsRpS;
//    }
}
