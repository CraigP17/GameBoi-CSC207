package com.example.gameboi;

import android.graphics.Color;

import java.util.ArrayList;

class FileManager {

    private String fileLocation;

    FileManager(){
        this.fileLocation = "/Users/jacobrajah/Documents/CSC207/group_0573/phase1/app/src/main/java/com/example/gameboi/leaderFile";
    }

    /**
     * @return A length of 3 ArrayList
     */
    ArrayList<User> getUsers(){
        User user = new User("moogah", 1, 0, 0 ,
                0, Color.WHITE, "fds", 0, 0);
        User user1 = new User("moogah", 1, 0, 0 ,
                0, Color.WHITE, "fds", 0, 0);
        User user2 = new User("moogah", 1, 0, 0 ,
                0, Color.WHITE, "fds", 0, 0);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        return users;
    }

}
