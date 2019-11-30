package com.example.gameboi.ScorePages;

import android.annotation.SuppressLint;
import android.util.Pair;

import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.UserClasses.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeaderBoardBE {

    ArrayList<User> users;
    ArrayList<Pair> orderedHighscorelist;
    ArrayList<Pair> orderedMultiplierlist;
    ArrayList<Pair> orderedLiveslist;

    FileManager file;

    LeaderBoardBE(User u1, FileManager fileM){

        file = fileM;
        users = file.getUsers();
        getAllvalues();

    }

    private ArrayList sortList(ArrayList<Pair> listTosort) {

        int firstPlace = -1;
        User userFirstplace = new User();
        Pair firstPlacepair = new Pair(0, 0);
        ArrayList<Pair> tempList = new ArrayList<Pair>(listTosort);
        System.out.println("tempList");
        System.out.println(tempList);

        for (Pair pair: listTosort) {
            if ((int) pair.second >= firstPlace) {
                firstPlace = (int) pair.second;
                userFirstplace = (User) pair.first;
                firstPlacepair = pair;
            }
        }

        tempList.remove(firstPlacepair);
        int lastPlace = -1;
        User userLastplace = new User();
        Pair lastPlacepair = new Pair(0, 0);

        for (Pair pair: listTosort) {
            if ((int) pair.second <= lastPlace || lastPlace == -1) {
                lastPlace = (int) pair.second;
                userLastplace = (User) pair.first;
                lastPlacepair = pair;
            }
        }


        tempList.remove(lastPlacepair);

        int secondPlace = (int) tempList.get(0).second;
        User userSecondplace = (User) tempList.get(0).first;


        Pair p1 = new Pair<User, Integer>(userFirstplace, firstPlace);
        Pair p2 = new Pair<User, Integer>(userSecondplace, secondPlace);
        Pair p3 = new Pair<User, Integer>(userLastplace,  lastPlace);

        ArrayList sortedList = new ArrayList<Pair>(Arrays.asList(p1, p2, p3));
        return sortedList;

    }

    void getAllvalues() {

        ArrayList<Pair> tempHighscorelist = new ArrayList<>();
        ArrayList<Pair> tempMultiplierlist = new ArrayList<>();
        ArrayList<Pair> tempLiveslist = new ArrayList<>();


        for (User user: users) {
            Pair<User, Integer> pair1 = new Pair<User, Integer>(user, user.getHighScore());
            tempHighscorelist.add(pair1);

            Pair<User, Integer> pair2 = new Pair<User, Integer>(user, user.getMultiplier());
            tempMultiplierlist.add(pair2);

            Pair<User, Integer> pair3 = new Pair<User, Integer>(user, user.getLives());
            tempLiveslist.add(pair3);

        }

        orderedHighscorelist = sortList(tempHighscorelist);
        orderedMultiplierlist = sortList(tempMultiplierlist);
        orderedLiveslist = sortList(tempLiveslist);

    }

}
