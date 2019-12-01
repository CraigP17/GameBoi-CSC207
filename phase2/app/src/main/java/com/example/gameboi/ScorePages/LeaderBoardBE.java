package com.example.gameboi.ScorePages;

import android.util.Pair;
import com.example.gameboi.FileSystem.FileManager;
import com.example.gameboi.UserClasses.User;
import java.util.ArrayList;
import java.util.Arrays;


public class LeaderBoardBE {

    ArrayList<User> users;
    ArrayList<Pair> orderedHighscorelist;
    ArrayList<Pair> orderedScorelist;
    ArrayList<Pair> orderedMultiplierlist;
    ArrayList<Pair> orderedLiveslist;

    FileManager file;

    LeaderBoardBE(FileManager fileM){

        file = fileM;
        users = file.getUsers();
        getAllvalues();

    }


    // Sorts items in listTosort and returns a sorted list
    private ArrayList sortList(ArrayList<Pair> listTosort) {

        // Creating temporary list so that pairs can be removed
        ArrayList<Pair> tempList = new ArrayList<Pair>(listTosort);

        //creating a temporary first player
        Pair firstPlacepair = tempList.get(0);

        //Looping to find pair with largest value
        for (Pair pair: listTosort) {
            if ((int) pair.second >= (int) firstPlacepair.second) {
                firstPlacepair = pair;
            }
        }

        // Removing the player in first place from the list
        tempList.remove(firstPlacepair);

        Pair lastPlacepair = tempList.get(0);


        // Looping to find player with smallest value
        for (Pair pair: tempList) {
            if ((int) pair.second <= (int) lastPlacepair.second) {
                lastPlacepair = pair;
            }
        }

        //Removing player in last place from tempList
        tempList.remove(lastPlacepair);

        int secondPlace = (int) tempList.get(0).second;
        User userSecondplace = (User) tempList.get(0).first;


        Pair p1 = new Pair<User, Integer>((User) firstPlacepair.first, (int) firstPlacepair.second);
        Pair p2 = new Pair<User, Integer>(userSecondplace, secondPlace);
        Pair p3 = new Pair<User, Integer>((User) lastPlacepair.first,  (int) lastPlacepair.second);

        // Returning sorted list
        return new ArrayList<Pair>(Arrays.asList(p1, p2, p3));

    }

    //Method that obtains all values of users needed for leaderboard and stores them in sorted lists
    void getAllvalues() {

        ArrayList<Pair> tempHighscorelist = new ArrayList<>();
        ArrayList<Pair> tempMultiplierlist = new ArrayList<>();
        ArrayList<Pair> tempLiveslist = new ArrayList<>();
        ArrayList<Pair> tempScorelist = new ArrayList<>();


        for (User user: users) {
            Pair<User, Integer> pair1 = new Pair<User, Integer>(user, user.getHighScore());
            tempHighscorelist.add(pair1);

            Pair<User, Integer> pair2 = new Pair<User, Integer>(user, user.getMultiplier());
            tempMultiplierlist.add(pair2);

            Pair<User, Integer> pair3 = new Pair<User, Integer>(user, user.getLives());
            tempLiveslist.add(pair3);

            Pair<User, Integer> pair4 = new Pair<User, Integer>(user, user.getPoints());
            tempScorelist.add(pair4);

        }

        orderedHighscorelist = sortList(tempHighscorelist);
        orderedMultiplierlist = sortList(tempMultiplierlist);
        orderedLiveslist = sortList(tempLiveslist);
        orderedScorelist = sortList(tempScorelist);

    }

}
