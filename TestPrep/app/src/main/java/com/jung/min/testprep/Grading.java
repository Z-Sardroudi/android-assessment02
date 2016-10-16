package com.jung.min.testprep;

/**
 * Created by Zac Hooper on 25/05/16.
 *
 * Edited by Zahra Sardroudi 15/10/2016
 */
public class Grading {

    private int id;
    private int studID;
    private Rank rank;
    private int score;
    private String passFail;

    public Grading() {
    }

    public Grading(int id, int studID, Rank rank, int score, String passFail) {
        this.id = id;
        this.studID = studID;
        this.rank = rank;
        this.score = score;
        this.passFail = passFail;
    }

    public int getId() {
        return id;
    }

    public int getStudID() {
        return studID;
    }

    public int getRank() {
        return rank.getID();
    }

    public String getGradeName() {
        String rank = this.rank.getRankTitle();
        return rank;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public void setRank(int index) {
        rank = new Rank(index);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPassFail() {
        return passFail;
    }

    public void setPassFail(String passFail) {
        this.passFail = passFail;
    }

    @Override
    public String toString() {
        return "Grading{" +
                "id=" + id +
                ", studID=" + studID +
                ", rank=" + rank +
                ", score=" + score +
                ", passFail='" + passFail + '\'' +
                '}';
    }
}
