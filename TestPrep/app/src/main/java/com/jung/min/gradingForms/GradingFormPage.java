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
/**
 * Created by ??.
 * Improved by Zahra Sardroudi 15/10/2016:
 *      improve select grading type fragment
 *      add new ranks
 *
 */
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
        details.currentRank.setText(s.getCurrentRank().getRankTitle());
        details.age.setText(Integer.toString(s.getAge()));


        textViewGrade.setText(s.getCurrentRank().getRankTitle());
        //Set initial scores
        scores.totalScore.setText(String.format("/%d",s.getCurrentRank().getRequiredScore()));
        scores.currentScore.setText(String.format("%d",s.getCurrentRank().getRequiredScore()));

        //Select GradeType Fragment
        String rankTitle = s.getCurrentRank().getRankTitle();
        switch(rankTitle) {
            case "Yellow Belt 1 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow1FormFrag(), "form").commit();
                form = (Yellow1FormFrag)fm.findFragmentByTag("form");
                break;
            case "Yellow Belt 2 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow2FormFrag(), "form").commit();
                form = (Yellow2FormFrag)fm.findFragmentByTag("form");
                break;
            case "Yellow Belt 3 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow3FormFrag(), "form").commit();
                form = (Yellow2FormFrag)fm.findFragmentByTag("form");
                break;
            case "Blue Belt 1 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Blue1FormFrag(), "form").commit();
                form = (Blue1FormFrag)fm.findFragmentByTag("form");
                break;
            case "Blue Belt 2 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Blue2FormFrag(), "form").commit();
                form = (Blue2FormFrag)fm.findFragmentByTag("form");
                break;
            case "Blue Belt 3 Stripe":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Blue3FormFrag(), "form").commit();
                form = (Blue3FormFrag)fm.findFragmentByTag("form");
                break;
            case "White Belt":
                getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new WhiteFormFrag(), "form").commit();
                form = (WhiteFormFrag)fm.findFragmentByTag("form");
                break;
            default:
                //getSupportFragmentManager().beginTransaction().add(R.id.gradeContainer, new Yellow1FormFrag(), "form").commit();
                //form = (Yellow1FormFrag)fm.findFragmentByTag("form");
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
