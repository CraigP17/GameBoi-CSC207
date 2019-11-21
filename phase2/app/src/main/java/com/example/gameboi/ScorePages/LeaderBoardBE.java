package com.example.gameboi.ScorePages;

import android.annotation.SuppressLint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeaderBoardBE {
    private int[] scores = new int[3];
    private int i = 0;
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, String> indices = new HashMap<Integer, String>();
    @SuppressLint("UseSparseArrays")
    HashMap<Integer, Object[]> order = new HashMap<Integer, Object[]>();

    LeaderBoardBE() {
    }

    private void readOrder(String file) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String read = null;
            read = in.readLine(); //reads header
            while ((read = in.readLine()) != null) {
                String[] splitted = read.split(", ");
                scores[i] = Integer.parseInt(splitted[8]);
                indices.put(i, splitted[0]);
                i++;
            }
        } catch (IOException e) {
            System.out.println("There was a problem: " + e);
        } finally {
            try {
                in.close();
            } catch (Exception e) { }
        }
        buildOrder(scores, indices);
    }

    private void buildOrder(int[] scores, Map<Integer, String> names) {
        for (int j = 0; j < scores.length; j++) {
            int max = getMax();
            int ind = getIndex(max);
            Object[] curr = new Object[] {names.get(ind), max};
            order.put(j, curr);
            scores[ind] = -1;
        }
    }

    private int getMax() {
        int m = scores[0];
        for (int k = 1; k < scores.length; k++) {
            if (scores[k] > m) {
                m = scores[k];
            }
        }
        return m;
    }

    private int getIndex(int num) {
        for (int s = 0; s < scores.length; s++){
            if (scores[s] == num) {
                return s;
            }
        }
        return -1;

    }

    public Map getOrder(String file) {
        readOrder(file);
        return order;
    }

//    public static void main(String[] args) {
//        String file = "LeaderFile"; NEED DIFFERENT FILE PATH FOR EACH PERSON
//        LeaderBoardBE l = new LeaderBoardBE();
//        Map Order = l.getOrder(file);
//        System.out.println((l.order.get(2)[1]));
    //}
}
