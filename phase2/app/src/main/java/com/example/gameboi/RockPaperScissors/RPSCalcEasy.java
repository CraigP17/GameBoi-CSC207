package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;
import java.util.Random;

public class RPSCalcEasy extends RPSAbstract {

    private String[] arr = new String[] {"Rock", "Paper", "Scissors"};
    private String computerChoice;
    private String playerChoice;

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

        this.playerChoice = playerValue;
        Random rand = new Random();
        computerChoice = arr[rand.nextInt(arr.length)];


        if (playerChoice.equals("Scissors") && computerChoice.equals("Rock")){
            notFoundhiddenFeature = false;
        }

        if (winnersRpS.get(playerValue).equals(computerChoice)) {
            //user wins, add to wins
            winsRpS += 1;
            incrementScore();
            return checker(playerValue, computerChoice);
        } else if (computerChoice.equals(playerValue)) {
            //to take into account number of games played
            return checker(playerValue, computerChoice);
        } else  {
            //comp wins, add to losses
            lossesRpS += 1;
            return checker(playerValue, computerChoice);
        }

    }

    @Override
    public boolean checkHidden(){
        if (playerChoice.equals("Scissors") && computerChoice.equals("Rock") && notFoundhiddenFeature) {
            return true;
        } else {
            return false;
        }


    }

}
