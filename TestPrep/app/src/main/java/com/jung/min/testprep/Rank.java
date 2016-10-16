package com.jung.min.testprep;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Zac Hooper on 9/05/16.
 * Improved by Zahra Sardroudi on 15/10/2016:
 *      1- Class name changed from 'Grade' to 'Rank' to keep naming convention consistent.
 *      2- rank titles get saved in the database, rather than String[]
 */
public class Rank implements Serializable{
    private int ID;
    private String rankTitle;
    private int requiredScore;

    public Rank() {
    }
    public Rank(int currentRank) {
        this.ID=currentRank;
    }
    public Rank(int currentRank, String rankTitle, int requiredScore) {
        this.ID=currentRank;
        this.rankTitle=rankTitle;
        this.requiredScore=requiredScore;
    }
    public Rank(String newRankTitle) {
        this.rankTitle=newRankTitle;
    }

    public String getRankTitle(){
        return this.rankTitle;
    }

    public int getID(){
        return this.ID;
    }
    public int getRequiredScore(){
        return this.requiredScore;
    }


    @Override
    public String toString() {
        return this.rankTitle;
    }

  /*  String[] ranks = {"yellow1", "yellow2", "yellow3"};
    int currentRank; //0-yellow1 1-yellow2 2-yellow3

    public Rank(int currentRank) {
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
    */
}
