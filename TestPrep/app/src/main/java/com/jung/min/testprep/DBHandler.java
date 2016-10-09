package com.jung.min.testprep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Hooper on 26/04/16.
 */
public class DBHandler extends SQLiteOpenHelper implements BaseColumns {
    private static final int DATABASE_VERSION = 19;
    private static final String DATABASE_NAME = "GradeDB.db";
    //Declare Tables in Database
    private static final String TABLE_TEACHER = "teachers";
    private static final String TABLE_STUDENT = "students";
    private static final String TABLE_GRADING = "gradings";

    //Columns in Teacher Table
    public static final String COLUMN_ID = "_id"; //also used in 'students', 'gradings'
    public static final String COLUMN_FNAME = "fName"; //also used in 'students'
    public static final String COLUMN_LNAME = "lName"; //also used in 'students'
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    //columns in Student Table
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_MOBILE_PHONE = "mobilePhone";
    public static final String COLUMN_HOME_PHONE = "homePhone";
    public static final String COLUMN_CURRENT_RANK = "currentRank";

    //columns in Gradings Table
    public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_STUDID = "studID";
    public static final String COLUMN_PASSFAIL = "passFail";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        //Create Teacher Table
        String CREATE_TEACHER_TABLE = "CREATE TABLE " + TABLE_TEACHER + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_FNAME + " TEXT, " + COLUMN_LNAME + " TEXT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT)";
        db.execSQL(CREATE_TEACHER_TABLE);

        //createa Student Table
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_FNAME + " TEXT, " +
                COLUMN_LNAME + " TEXT, " +
                COLUMN_GENDER + " INTEGER, " +
                COLUMN_WEIGHT + " REAL, " +
                COLUMN_HEIGHT + " REAL, " +
                COLUMN_DOB + " TEXT, " +
                COLUMN_MOBILE_PHONE + " TEXT, " +
                COLUMN_HOME_PHONE + " TEXT, " +
                COLUMN_CURRENT_RANK + " TEXT);";
        db.execSQL(CREATE_STUDENT_TABLE);

        //Create Grading Table
        String CREATE_GRADING_TABLE = "CREATE TABLE " + TABLE_GRADING + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_RANK + " INTEGER, " +
                COLUMN_STUDID + " INTEGER, " +
                COLUMN_SCORE + " INTEGER, " +
                COLUMN_PASSFAIL + " TEXT)";
        db.execSQL(CREATE_GRADING_TABLE);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBHandler.TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + DBHandler.TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + DBHandler.TABLE_GRADING);

        onCreate(db);
    }

    //methods for modifying the database
    public void addTeacher(Teacher teacher) {

        ContentValues values = new ContentValues(); // simpler way of inserting into DB
        values.put(COLUMN_FNAME, teacher.getfName()); //ID isn't added as the ID will automatically be assigned
        values.put(COLUMN_LNAME, teacher.getlName());
        values.put(COLUMN_USERNAME, teacher.getUsername());
        values.put(COLUMN_PASSWORD, teacher.getPassword());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_TEACHER, null, values);
        db.close();
    }

    //search for product
    public Teacher findTeacher(String username, String password) {
        String query = "SELECT * FROM " + TABLE_TEACHER + " WHERE username = '" +
                username + "' AND password = '" + password + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //run query with cursor
        Cursor cursor = db.rawQuery(query, null);
        Teacher teacher = new Teacher();

        //move to first existing object
        if (cursor.moveToFirst()) {
            do { //****** This IF loop may be pointless need to mess with...
                if (username.equals(cursor.getString(3))) { //If a username matches one in the DB add info into Teacher object
                    teacher.setId(Integer.parseInt(cursor.getString(0)));
                    teacher.setfName(cursor.getString(1));
                    teacher.setlName(cursor.getString(2));
                    teacher.setUsername(cursor.getString(3));
                    teacher.setPassword(cursor.getString(4));
                }
            } while (cursor.moveToNext());
            cursor.close();
        }
        else //no match found return a null object
        {
            teacher = null;
            db.close();
        }

        return teacher;
    }

    /**
        method to create a list of the Teachers in the GradeDB database
        Method will return an ArrayList of Teacher
     */
    public ArrayList<Teacher > listTeachers() {
        String query = "SELECT * FROM " + TABLE_TEACHER;
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Teacher> list = new ArrayList<>(); //Array to store teachers
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do { //run loop through all results and store each teacher into arraylist
                Teacher p = new Teacher();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setfName(cursor.getString(1));
                p.setlName(cursor.getString(2));
                p.setUsername(cursor.getString(3));
                p.setPassword(cursor.getString(4));
                list.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
    
    public boolean deleteTeacher(int id) {
        boolean success = false;
        //create query
        String query = "SELECT * FROM " + TABLE_TEACHER + " WHERE " + COLUMN_ID + " = '" + id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //run query
        Cursor cursor = db.rawQuery(query, null);
        Teacher Teacher = new Teacher(); //temp
        //move to first object
        if (cursor.moveToFirst()) //if exists delete object
        {
            cursor.moveToFirst();
            Teacher.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_TEACHER, COLUMN_ID + " = ?", new String[]{String.valueOf(Teacher.getId())});
            success = true;
            cursor.close();
        }
        db.close();
        return success;
    }

    public void addStudent(Student student) {
        ContentValues values = new ContentValues(); // simpler way of inserting into DB
        values.put(COLUMN_FNAME, student.getFirstName()); //ID isn't added as the ID will automatically be assigned
        values.put(COLUMN_LNAME, student.getLastName());
        values.put(COLUMN_GENDER, student.getGender());
        values.put(COLUMN_WEIGHT, student.getWeight());
        values.put(COLUMN_HEIGHT, student.getHeight());
        values.put(COLUMN_DOB, student.getDateOfBirth());
        values.put(COLUMN_MOBILE_PHONE, student.getMobileNo());
        values.put(COLUMN_HOME_PHONE, student.getMobileNo());
        values.put(COLUMN_CURRENT_RANK, student.getCurrentRank());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_STUDENT, null, values);
        db.close();
    }

    public ArrayList<Student> listStudents() {
        String query = "SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Student> list = new ArrayList<>(); //Array to store Students
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do { //run loop through all results and store each Student into arraylist
                Student p = new Student();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setFirstName(cursor.getString(1));
                p.setLastName(cursor.getString(2));
                p.setGender(Integer.parseInt(cursor.getString(3)));
                p.setWeight(Double.parseDouble(cursor.getString(4)));
                p.setHeight(Double.parseDouble(cursor.getString(5)));
                p.setDateOfBirth(cursor.getString(6));
                p.setMobileNo(cursor.getString(7));
                p.setHomePhone(cursor.getString(8));
                p.setCurrentRank(Integer.parseInt(cursor.getString(9)));
                list.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean deleteStudent(int id) {
        boolean success = false;
        //create query
        String query = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COLUMN_ID + " = '" + id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //run query
        Cursor cursor = db.rawQuery(query, null);
        Student Student = new Student(); //temp
        //move to first object
        if (cursor.moveToFirst()) //if exists delete object
        {
            cursor.moveToFirst();
            Student.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_STUDENT, COLUMN_ID + " = ?", new String[]{String.valueOf(Student.getId())});
            success = true;
            cursor.close();
        }
        db.close();
        return success;
    }

    public Student findStudent(String id) {
        String query = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COLUMN_ID + " = '" +
                id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //run query with cursor
        Cursor cursor = db.rawQuery(query, null);
        Student p = new Student();

        //move to first existing object
        if (cursor.moveToFirst()) {
            do { //****** This IF loop may be pointless need to mess with...
                if (id.equals(cursor.getString(0))) { //If a username matches one in the DB add info into Student object
                    p.setId(Integer.parseInt(cursor.getString(0)));
                    p.setFirstName(cursor.getString(1));
                    p.setLastName(cursor.getString(2));
                    p.setGender(Integer.parseInt(cursor.getString(3)));
                    p.setWeight(Double.parseDouble(cursor.getString(4)));
                    p.setHeight(Double.parseDouble(cursor.getString(5)));
                    p.setDateOfBirth(cursor.getString(6));
                    p.setMobileNo(cursor.getString(7));
                    p.setHomePhone(cursor.getString(8));
                    p.setCurrentRank(Integer.parseInt(cursor.getString(9)));
                }
            } while (cursor.moveToNext());
            cursor.close();
        } else //no match found return a null object
        {
            p = null;
            db.close();
        }

        return p;
    }

    public void increaseRank(Student s) {
        int newRank = s.getCurrentRank() + 1;

        String query = "UPDATE " + TABLE_STUDENT +
                " SET " + COLUMN_CURRENT_RANK + "='" + newRank + "'" +
                " WHERE " + COLUMN_ID + "='" + s.getId() + "'";
        Log.i("increaseRank Query: ", query);

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        db.close();
    }

    /*
    Grading Table Stuff
     */

    public void addGrading(Grading grading) {

        ContentValues values = new ContentValues(); // simpler way of inserting into DB
        values.put(COLUMN_RANK, grading.getGrade());
        values.put(COLUMN_STUDID, grading.getStudID()); //ID isn't added as the ID will automatically be assigned
        values.put(COLUMN_SCORE, grading.getScore());
        values.put(COLUMN_PASSFAIL, grading.getPassFail());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_GRADING, null, values);
        db.close();

    }

    public ArrayList<Grading> listGradings() {
        String query = "SELECT * FROM " + TABLE_GRADING;
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Grading> list = new ArrayList<>(); //Array to store Grading
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do { //run loop through all results and store each Grading into arraylist
                Grading p = new Grading();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setGrade(Integer.parseInt(cursor.getString(1)));
                p.setStudID(Integer.parseInt(cursor.getString(2)));
                p.setScore(Integer.parseInt(cursor.getString(3)));
                p.setPassFail(cursor.getString(4));
                list.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Grading> listStudentGrading(Student student) {
        String query = "SELECT * FROM " + TABLE_GRADING + " WHERE " + COLUMN_STUDID + " = '" + student.getId() + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Grading> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do { //run loop through all results and store each Grading into arraylist
                Grading p = new Grading();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setGrade(Integer.parseInt(cursor.getString(1)));
                p.setStudID(Integer.parseInt(cursor.getString(2)));
                p.setScore(Integer.parseInt(cursor.getString(3)));
                p.setPassFail(cursor.getString(4));
                list.add(p);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean deleteGrading(int id) {
        boolean success = false;
        //create query
        String query = "SELECT * FROM " + TABLE_GRADING + " WHERE " + COLUMN_ID + " = '" + id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //run query
        Cursor cursor = db.rawQuery(query, null);
        Grading grading = new Grading(); //temp
        //move to first object
        if (cursor.moveToFirst()) //if exists delete object
        {
            cursor.moveToFirst();
            grading.setId(Integer.parseInt(cursor.getString(0))); //create Grading object to set the id
            db.delete(TABLE_GRADING, COLUMN_ID + " = ?", new String[]{String.valueOf(grading.getId())}); //requires grading object
            success = true;
            cursor.close();
        }
        db.close();
        return success;
    }


}

