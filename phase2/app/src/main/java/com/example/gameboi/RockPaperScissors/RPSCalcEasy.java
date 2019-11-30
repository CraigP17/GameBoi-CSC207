package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

public class RPSCalcEasy extends RPSAbstract {

    private String[] arr = new String[] {"Rock", "Paper", "Scissors"};

    RPSCalcEasy(User player) {
        super(player);
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



//    public int getWins() {
//        return winsRpS;
//    }
}
