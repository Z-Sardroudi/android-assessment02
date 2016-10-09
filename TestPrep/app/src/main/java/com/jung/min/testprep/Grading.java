package com.jung.min.testprep;

/**
 * Created by Zac Hooper on 25/05/16.
 */
public class Grading {

    private int id;
    private int studID;
    private Grade grade;
    private int score;
    private String passFail;

    public Grading() {
    }

    public Grading(int id, int studID, Grade grade, int score, String passFail) {
        this.id = id;
        this.studID = studID;
        this.grade = grade;
        this.score = score;
        this.passFail = passFail;
    }

    public int getId() {
        return id;
    }

    public int getStudID() {
        return studID;
    }

    public int getGrade() {
        return grade.getCurrentRank();
    }

    public String getGradeName() {
        String rank = grade.getRanks();
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

    public void setGrade(int index) {
        grade = new Grade(index);
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
                ", grade=" + grade +
                ", score=" + score +
                ", passFail='" + passFail + '\'' +
                '}';
    }
}
