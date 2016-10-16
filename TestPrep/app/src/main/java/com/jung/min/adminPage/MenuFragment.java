package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jung.min.StudentList.ListStudentFrag;
import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Rank;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;
import com.jung.min.testprep.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zac Hooper on 9/05/16.
 * Improved by Zahra Sardroudi 16/10/2016:
 *      Improved functionality of add grade button. Button will be enable only if there is no rank data in rank table in database. It will add predefined rank into database
 */
public class MenuFragment extends Fragment {
    Fragment frag;
    int fragTran;

    public MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_menu, container, false);
        //Student Buttons
        Button btnAddStudent = (Button)rootView.findViewById(R.id.btnAddStudent);
        Button btnListStudent = (Button)rootView.findViewById(R.id.btnListStudent);
        //Rank Buttons
        Button btnAddGrade = (Button)rootView.findViewById(R.id.btnAddGrade);
        Button btnListGrade = (Button)rootView.findViewById(R.id.btnListGrade);
        //Teacher Buttons
        Button btnAddTeacher = (Button)rootView.findViewById(R.id.btnAddTeacher);
        Button btnListTeacher = (Button)rootView.findViewById(R.id.btnListTeacher);

        //Create onclick Listeners for buttons
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragTransition(new AddStudentFrag());
            }
        });

        btnListStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragTransition(new AdminListStudentFrag());
            }
        });

        btnAddGrade.setEnabled(addGradeEnabled());

        btnAddGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGrade();
            }
        });

        btnListGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragTransition(new ListGradingFrag());
            }
        });

        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragTransition(new AddTeacherFrag());
            }
        });

        btnListTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragTransition(new ListTeacherFrag());
            }
        });



        return rootView;
    }

    public void FragTransition(Fragment frag) {
        this.frag = frag;
        fragTran = getFragmentManager().beginTransaction().replace(R.id.fragContainer, frag).commit();
    }

    public boolean addGradeEnabled(){
        DBHandler dbHandler = new DBHandler(getActivity(), null, null, 0);
        return !dbHandler.rankTablePopulated();
    }
    public void addGrade(){
        DBHandler dbHandler = new DBHandler(getActivity(), null, null, 0);
        //create temp data
        //Populate rank table for the first time
        if (!dbHandler.rankTablePopulated()) {
            dbHandler.addRank(new Rank(0, "Yellow Belt 1 Stripe", 90));
            dbHandler.addRank(new Rank(0, "Yellow Belt 2 Stripe", 125));
            dbHandler.addRank(new Rank(0, "Yellow Belt 3 Stripe", 120));
            dbHandler.addRank(new Rank(0, "Blue Belt 1 Stripe", 120));
            dbHandler.addRank(new Rank(0, "Blue Belt 2 Stripe", 120));
            dbHandler.addRank(new Rank(0, "Blue Belt 3 Stripe", 120));
            dbHandler.addRank(new Rank(0, "White Belt", 120));
        }
    }

}
