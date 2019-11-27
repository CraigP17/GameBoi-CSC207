package com.example.gameboi.FileSystem;


import android.util.Log;
import android.content.Context;

import com.example.gameboi.StartupPages.MainActivity;
import com.example.gameboi.UserClasses.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FileManager{

    private Context activity;
    /** For logging output . */
    private static final String TAG = "Main Activity";

    /** The example file to write and read. */
    private String EXAMPLE_FILE = "gameboi.txt";

    public FileManager(Context activity){
        this.activity = activity;
    }

    /**
     * This method is responsible for writing to the file located on the internal systems drive
     */
    private void write(){
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
        //Name, Lives, Points, BackgroundColor, Icon, CurrLevel, HighScore, OrigLives, Multiplier
        out.println(",0,0,0,,0,0,0,0");
        out.println(",0,0,0,,0,0,0,0");
        out.println(",0,0,0,,0,0,0,0");
        out.close();
    }

    /**
     * @return This method returns a 3 line String contains 3 users information in each line
     */
    private String read(){
        //StringBuffer buffer = new StringBuffer();
        String usersStr = "";
        try {
            FileInputStream inputStream = activity.openFileInput(EXAMPLE_FILE);
            if (inputStream != null) {
                InputStreamReader inputReader= new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String allUsers;
                StringBuilder stringBuilder = new StringBuilder();

                while ((allUsers = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(allUsers).append("\n");
                }
                inputStream.close();
                usersStr = stringBuilder.toString();
            }

        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error Finding the File: " + EXAMPLE_FILE);
        } catch (IOException e) {
            Log.e(TAG, "Error Reading. What happened: " + e.toString());
        }
        System.out.println(usersStr);
        return usersStr;
    }

    /**
     * @return An array list containing 3 Users that have been created using the lines in a file
     */
    public ArrayList<User> getUsers() {
        try{
            ArrayList<User> userList = new ArrayList<>();

            String[] multiLine = this.read().split(System.getProperty("line.separator"));

            for(String u: multiLine){
                System.out.println("Found the File");
                String[] temp = u.split(",");
                if(temp[0].equals("")){
                    temp[0] = null;
                }
                User user = new User(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]),
                        temp[4], Integer.parseInt(temp[5]), Integer.parseInt(temp[6]), Integer.parseInt(temp[7]));
                userList.add(user);
            }
            return userList;
        }
        catch (ArrayIndexOutOfBoundsException e) {
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
                        Integer.parseInt(temp[3]),
                        temp[4], Integer.parseInt(temp[5]), Integer.parseInt(temp[6]), Integer.parseInt(temp[7]));
                userList.add(user);
            }
            System.out.print("REACHED END");
            return userList;
        }
    }

    public void save(User user) {
        System.out.print("REACHED FUNCTION");
        ArrayList<User> players = getUsers();
        try {
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(activity.openFileOutput(
                    "gameboi.txt", MainActivity.MODE_PRIVATE));
            StringBuilder writeData = new StringBuilder();
            for (User u: players) {
                if (user.getName().equals(u.getName())) {
                    writeData.append(user.toString()).append("\n");
                    System.out.print("FOUND NEW");
                } else {
                    writeData.append(u.toString()).append("\n");
                }
            }
            System.out.println(writeData);
            outStreamWriter.write(writeData.toString());
            outStreamWriter.close();
            System.out.print("CHANGED FILE");
        } catch (IOException e) {
            Log.e(TAG, "Error encountered trying to open file for writing: " + EXAMPLE_FILE);
        }
    }

    public void saveNewUser(User user) {
        //load output stream to example file
        System.out.print("REACHED FUNCTION");
        ArrayList<User> players = getUsers();
        try {
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(
                    activity.openFileOutput("gameboi.txt", MainActivity.MODE_PRIVATE));
            StringBuilder userDatas= new StringBuilder();
            int changed = 0;
            for (User u: players) {
                if ((u.getName() == null || u.getName().equals("null")) && changed == 0) {
                    userDatas.append(user.toString()).append("\n");
                    changed++;
                    System.out.print("FOUND NEW");
                } else {
                    userDatas.append(u.toString()).append("\n");
                }
            }
            System.out.println(userDatas);
            outStreamWriter.write(userDatas.toString());
            outStreamWriter.close();
            System.out.print("CHANGED FILE");
        } catch (IOException e) {
            Log.e(TAG, "Error encountered trying to open file for writing: " + EXAMPLE_FILE);
        }
    }

    /**
     * sets the users in the text file to new users
     */
    public void erase(){

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
        //Name, Lives, Points, BackgroundColor, Icon, CurrLevel, HighScore, OrigLives, Multiplier
        out.println(",0,0,0,,0,0,0,0");
        out.println(",0,0,0,,0,0,0,0");
        out.println(",0,0,0,,0,0,0,0");
        out.close();
    }

}


