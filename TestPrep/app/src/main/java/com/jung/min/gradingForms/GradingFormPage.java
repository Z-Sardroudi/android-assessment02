package com.jung.min.gradingForms;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jung.min.SummaryPage.SummaryPage;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;

public class GradingFormPage extends FragmentActivity implements FormFrag.onRatingChangedListener{

    StudentDetailsVerticalFrag details;
    FormFrag form;
    ScoreFrag scores;
    TextView textViewGrade;
    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grading_form_page);

        textViewGrade = (TextView) findViewById(R.id.textViewGradePageGrade);

        //allow connectivity with Fragments --- form done in switch
        FragmentManager fm = getSupportFragmentManager();
        details = (StudentDetailsVerticalFrag)fm.findFragmentById(R.id.studentDetailsFrag);
        scores = (ScoreFrag)fm.findFragmentById(R.id.gradeScoreFrag);

        //get student data out of Intent
        Intent intent = getIntent();
        s = (Student)intent.getSerializableExtra("student");

        //Set Student data in Fragment
        String name = s.getLastName() + ", " + s.getFirstName();
        details.studentName.setText(name);
        details.height.setText(Double.toString(s.getHeight()));
        details.weight.setText(Double.toString(s.getWeight()));
        details.currentRank.setText(s.getCurrentRankName());
        details.age.setText(Integer.toString(s.getAge()));

        //Select GradeType Fragment
        switch(s.getCurrentRankName()) {
            case "yellow1":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow1FormFrag(), "form").commit();
                form = (Yellow1FormFrag)fm.findFragmentByTag("form");
                textViewGrade.setText("Yellow 1");
                //Set initial scores
                scores.totalScore.setText("/90");
                scores.currentScore.setText("90");
                break;
            case "yellow2":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow2FormFrag(), "form").commit();
                form = (Yellow2FormFrag)fm.findFragmentByTag("form");
                textViewGrade.setText("Yellow 2");
                scores.totalScore.setText("/125");
                scores.currentScore.setText("125");
                break;
            case "yellow3":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow3FormFrag(), "form").commit();
                form = (Yellow2FormFrag)fm.findFragmentByTag("form");
                textViewGrade.setText("Yellow 3");
                scores.totalScore.setText("/120");
                scores.currentScore.setText("120");
                break;
            default:
                break;

        }

    }

    public void OnRatingChanged(int score) {
        scores.changeScore(score);
        if (scores.checkPassFail()) {
            scores.setCurrentScoreColour("#6B8E23");
        }
        else
        {
            scores.setCurrentScoreColour("#B22222");
        }
    }


    public void submit(View view) {
        //pass student and students score into Summary activity
        Bundle args = new Bundle();
        Log.i("Student Details", s.toString());
        args.putSerializable("student", s);
        args.putInt("currentScore", scores.getCurrentScore());
        args.putInt("totalScore", scores.getTotalScore());
        args.putString("grade", textViewGrade.getText().toString());

        Intent intent = new Intent(this, SummaryPage.class);
        intent.putExtra("args", args);

        startActivity(intent);
    }
}
