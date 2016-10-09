package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jung.min.StudentList.ListStudentFrag;
import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Grade;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;
import com.jung.min.testprep.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zac Hooper on 9/05/16.
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
        //Grade Buttons
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
                FragTransition(new ListStudentFrag());
            }
        });

        btnAddGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHandler dbHandler = new DBHandler(getActivity(), null, null, 0);
                //create temp data
                dbHandler.addTeacher(new Teacher(0, "Zac", "Hooper", "zHooper", "abc"));
                dbHandler.addTeacher(new Teacher(0, "Hannah", "Manoylovic", "hManoylovic", "abc"));
                dbHandler.addTeacher(new Teacher(0, "Jung", "Min", "mJung", "abc"));

                Date date = null;
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1990");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dbHandler.addStudent(new Student(0, "Zac", "Hooper", 0, 70, 168, date, "0426766169", "95880081", new Grade(0)));
                dbHandler.addStudent(new Student(0, "Hannah", "Manoylovic", 1, 60, 180, date, "0412345678", "95116676", new Grade(1)));
                dbHandler.addStudent(new Student(0, "Min", "Jung", 2, 75, 175, date, "0423560601", "95878242", new Grade(2)));
                dbHandler.close();
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


}
