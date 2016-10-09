package com.jung.min.SummaryPage;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jung.min.StudentList.StudentListPage;
import com.jung.min.gradingForms.ScoreFrag;
import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Grade;
import com.jung.min.testprep.Grading;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;

public class SummaryPage extends AppCompatActivity {

    SummaryDetailsFrag details;
    Student s;
    ScoreFrag scores;
    SummaryPassFailFrag continueFrag;
    Button yes;
    Button no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);

        //Set Buttons
        yes = (Button) findViewById(R.id.buttonSummaryYes);
        no = (Button) findViewById(R.id.buttonSummaryNo);

        //Create Fragment connectivity
        FragmentManager fm = getSupportFragmentManager();
        details = (SummaryDetailsFrag)fm.findFragmentById(R.id.fragmentSummaryDetails);
        scores = (ScoreFrag)fm.findFragmentById(R.id.fragmentSummaryScoreFrag);
        continueFrag = (SummaryPassFailFrag)fm.findFragmentById(R.id.fragmentSummaryContinueFrag);

        //get data out of Intent
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("args");
        s = (Student) args.getSerializable("student");
        int currentScore = args.getInt("currentScore");
        int totalScore = args.getInt("totalScore");
        String grade = args.getString("grade");

        //Set Student data in Fragment
        String name = s.getLastName() + ", " + s.getFirstName() + " - " + grade;
        details.studentName.setText(name);
        details.height.setText(Double.toString(s.getHeight()));
        details.weight.setText(Double.toString(s.getWeight()));
        details.currentRank.setText(s.getCurrentRankName());
        details.age.setText(Integer.toString(s.getAge()));

        //Set Scores
        scores.setCurrentScore(Integer.toString(currentScore));
        scores.setTotalScore("/" + Integer.toString(totalScore));

        //Set PassFail
        continueFrag.setPassFail(scores.checkPassFail());


        //Set button onclick methods
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGrading();
            }
        });

    }

    public void addGrading() {
        //Create Grading Object
        Grading grading = new Grading(0,
                s.getId(),
                new Grade(s.getCurrentRank()),
                scores.getCurrentScore(),
                continueFrag.passFail.getText().toString());

        //Put Grading into DB
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        dbHandler.addGrading(grading);

        //Increase Grade of Student who passed
        if (scores.checkPassFail()) { //If student passed increase their rank
            if (s.getCurrentRank() != 2) { //stop an increase if student is already at highest rank
                dbHandler.increaseRank(s);
            }
        }
        //go back to student page
        Intent intent = new Intent(this, StudentListPage.class);
        startActivity(intent);
        dbHandler.close();
    }

}
