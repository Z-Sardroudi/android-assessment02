package com.jung.min.testprep;

import java.io.Serializable;

/**
 * Created by Zac Hooper on 3/05/16.
 */
public class Teacher implements Serializable{
    private int id;
    private String fName;
    private String lName;
    private String username;
    private String password;

    public Teacher() {
    }

    public Teacher(int id, String fName, String lName, String username, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " - " + fName + " " + lName + " - " + username + " - " + password;
    }
}
