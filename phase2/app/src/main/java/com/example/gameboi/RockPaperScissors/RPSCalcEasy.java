package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

public class RPSCalcEasy extends RPSabstract {

    private String[] arr = new String[] {"Rock", "Paper", "Scissors"};
    private static int winsRpS = 0;
    private static int lossesRpS = 0;
    public User player;

    RPSCalcEasy(User player) {
        super();
        this.player = player;
    }

    public HashMap buildMap() {
        HashMap<String, String> winnersRpS = new HashMap<>();
        winnersRpS.put("Rock", "Scissors");
        winnersRpS.put("Scissors", "Paper");
        winnersRpS.put("Paper", "Rock");
        return winnersRpS;
    }

    public String[] RpSGamePlayed(String playerValue) {
        HashMap<String, String> winnersRpS = buildMap();

        Random rand = new Random();
        //if this button is for rock
        String computerchoice = arr[rand.nextInt(arr.length)];
        if (winnersRpS.get(playerValue).equals(computerchoice)) {
            //user wins, add to wins
            winsRpS += 1;
            return checker(playerValue, computerchoice);
        } else if (computerchoice.equals(playerValue)) {
            //to take into account number of games played
            return checker(playerValue, computerchoice);
        } else  {
            //comp wins, add to losses
            lossesRpS += 1;
            return checker(playerValue, computerchoice);
        }

    }

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
            winsRpS = 0;
            lossesRpS = 0;
            array = new String[] {userchoice, compchoice, "FlashWin"};
        } else {
            array = new String[] {userchoice, compchoice, "Round"};
            }
        return array;
    }

//    public int getWins() {
//        return winsRpS;
//    }
}
