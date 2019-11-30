package com.example.gameboi.RockPaperScissors;

import com.example.gameboi.UserClasses.User;

import java.util.HashMap;

public abstract class RPSabstract {

    public User player;

    RPSabstract() {
    }

    abstract HashMap buildMap();

    abstract String[] RpSGamePlayed(String playerValue);

    abstract String[] checker(String userchoice, String compchoice);

}
