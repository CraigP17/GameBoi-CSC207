package com.example.gameboi;


import android.util.Log;
import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

class FileManager{

    private Context activity;
    /** For logging output. */
    private static final String TAG = "Main Activity";

    /** The example file to write and read. */
    private String EXAMPLE_FILE = "gameboi.txt";

    FileManager(Context activity){
        this.activity = activity;
    }

    /**
     * This method is responsible for writing to the file located on the internal systems drive
     */
    void write(){
        //when writing to this file, it starts at top of file and begins writing, so any information that
        //on that line will be removed. Make sure this is considered.
        PrintWriter out = null;
        //load output stream to example file
        try {
            OutputStream outStream = activity.openFileOutput(EXAMPLE_FILE, Context.MODE_PRIVATE);
            //create new print writer to send full strings not bytes
            out = new PrintWriter(outStream);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error encountered trying to open file for writing: " + EXAMPLE_FILE);
        }

        //sends info to the text file
        out.println(",0,0,0,0,0,,0,0");
        out.println(",0,0,0,0,0,,0,0");
        out.println(",0,0,0,0,0,,0,0");
        out.close();
    }

    /**
     * @return This method returns a 3 line String contains 3 users information in each line
     */
    String read(){
        StringBuffer buffer = new StringBuffer();
        //scanner is a way to read information
        try (Scanner scanner = new Scanner(activity.openFileInput(EXAMPLE_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                buffer.append(line).append('\n'); // keep adding to buffer and add new line each time
            }
        } catch (IOException e) {
            Log.e(TAG, "Error encountered trying to open file for reading: " + EXAMPLE_FILE);
        }

        return buffer.toString();
    }

    /**
     * @return An array list containing 3 Users that have been created using the lines in a file
     */
    ArrayList<User> getUsers(){

        try{
        ArrayList<User> userList = new ArrayList<>();

        String[] multiLine = this.read().split(System.getProperty("line.separator"));

        for(String u: multiLine){
            String[] temp = u.split(",");
            if(temp[0].equals("")){
                temp[0] = null;
            }
            User user = new User(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
                    Integer.parseInt(temp[3]) ,Integer.parseInt(temp[4]), Integer.parseInt(temp[5]),
                    temp[6], Integer.parseInt(temp[7]), Integer.parseInt(temp[8]));
            userList.add(user);
        }

        return userList;
        }
        catch (Exception e){
            System.out.println("Gotta write the file...Done");
            this.write(); //EVENTUALLY this write method will initialize 3 empty users

            ArrayList<User> userList = new ArrayList<>();

            String[] multiLine = this.read().split(System.getProperty("line.separator"));

            for(String u: multiLine){
                String[] temp = u.split(",");
                if(temp[0].equals("")){
                    temp[0] = null;
                }
                User user = new User(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]) ,Integer.parseInt(temp[4]), Integer.parseInt(temp[5]),
                        temp[6], Integer.parseInt(temp[7]), Integer.parseInt(temp[8]));
                userList.add(user);
            }
            System.out.print("REACHED END");
            return userList;
        }
    }

    void save(User user) {
        PrintWriter out = null;
        //load output stream to example file
        try {
            OutputStream outStream = activity.openFileOutput(EXAMPLE_FILE, Context.MODE_PRIVATE);
            //create new print writer to send full strings not bytes
            out = new PrintWriter(outStream);

            ArrayList<User> players = this.getUsers();
            for (User u: players) {
                if (user.getName().equals(u.getName())) {
                    out.println(user);
                } else {
                    out.println(u);
                }
            }
            out.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error encountered trying to open file for writing: " + EXAMPLE_FILE);
        }

    }

    void saveNewUser(User user) {
        PrintWriter out = null;
        //load output stream to example file
        System.out.print("REACHED FUNCTION");
        try {
            OutputStream outStream = activity.openFileOutput(EXAMPLE_FILE, Context.MODE_PRIVATE);
            //create new print writer to send full strings not bytes
            out = new PrintWriter(outStream);
            System.out.print("REACHED FUNCTION");
            ArrayList<User> players = getUsers();
            int changed = 0;
            for (User u: players) {
                if (u.getName() == null & changed == 0) {
                    out.println(user);
                    changed++;
                    System.out.print("FOUND NEW");
                } else {
                    out.println(u);
                }
            }
            out.close();
            System.out.print("CHANGED FILE");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error encountered trying to open file for writing: " + EXAMPLE_FILE);
        }
    }

}


