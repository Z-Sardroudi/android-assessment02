package com.jung.min.StudentList;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jung.min.testprep.R;
import com.jung.min.testprep.Rank;
/**
 * Created by ??.
 * Improved by Zahra Sardroudi 15/10/2016:
 *      Get selected rank from intent and set the title
 *
 */
public class StudentListPage extends FragmentActivity {
    private Rank rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_page);

        TextView pageTitle = (TextView)findViewById(R.id.textViewStudentListGrade);

        //get selected rank fron intent
        rank = (Rank)getIntent().getExtras().get("rank");
        //set page title as selected rank title
        pageTitle.setText(rank.getRankTitle());

    }
}
