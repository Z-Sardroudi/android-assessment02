package com.jung.min.testprep;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class Grade implements Serializable{
    String[] ranks = {"yellow1", "yellow2", "yellow3"};
    int currentRank; //0-yellow1 1-yellow2 2-yellow3

    public Grade(int currentRank) {
        this.currentRank = currentRank;
    }

    public String getRanks() {
        String rank = ranks[currentRank];
        return rank;
    }

    public void setRanks(int currentRank) { //0-yellow1 1-yellow2 2-yellow3
        this.currentRank = currentRank;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    @Override
    public String toString() {
        return ranks[currentRank];
    }
}
