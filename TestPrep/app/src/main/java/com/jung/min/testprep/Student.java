package com.jung.min.testprep;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zac Hooper on 3/05/16.
 * Edited by Zahra Sardroudi 15/10/2016:
 *      1- change getter setters related to rank, base on Rank class
 */
public class Student implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private int gender; //0-male, 1-female, 2-other
    private double weight;
    private double height;
    private Date dateOfBirth;
    private String mobileNo;
    private String homePhone;
    private Rank currentRank; // value is equal to the id of the rank in rank table

    public Student() {
    }

    public Student(int id, String firstName, String lastName, int gender, double weight, double height,
                   Date dateOfBirth, String mobileNo, String homePhone, Rank currentRank) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.homePhone = homePhone;
        this.currentRank = currentRank;
    }

    /*
    Getters and Setters
     */

    public Rank getCurrentRank() {
        return this.currentRank;
    }


    public void setCurrentRank(Rank rank) {
        currentRank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDateOfBirth() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.dateOfBirth = date;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getGenderName() {
        switch (gender) {
            case 0:
                return "Male";
            case 1:
                return "Female";
            case 2:
                return "Other";
            default:
                return "Other";
        }

    }

    public int getAge() {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        today.getTime();

        //mathsss
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        return age;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " - " + getAge()+ " - "  + getHeight()
                + " - " + getWeight();
    }
}
