package com.jung.min.StudentList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;

/**
 * Created by Zac Hooper on 10/05/16.
 */
public class StudentDetailsDialog extends DialogFragment {

    Student student;
    TextView textViewStudentDetailsFirstName;
    TextView textViewStudentDetailsLastName;
    TextView textViewStudentDetailsGender;
    TextView textViewStudentDetailsWeight;
    TextView textViewStudentDetailsHeight;
    TextView textViewStudentDetailsDOB;
    TextView textViewStudentDetailsHome;
    TextView textViewStudentDetailsMobile;
    TextView textViewStudentDetailsRank;

    public static StudentDetailsDialog newInstance(Student student) { //passes the student as an argument - allows for Student object to be used
        Bundle args = new Bundle();

        StudentDetailsDialog fragment = new StudentDetailsDialog();
        args.putSerializable("Student", student);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = (Student) getArguments().getSerializable("Student");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.student_details_dialog, container, false); //how to link XML to java code

        textViewStudentDetailsFirstName = (TextView)rootView.findViewById(R.id.textViewStudentDetailsFirstName);
        textViewStudentDetailsLastName = (TextView)rootView.findViewById(R.id.textViewStudentDetailsLastName);
        textViewStudentDetailsGender = (TextView)rootView.findViewById(R.id.textViewStudentDetailsGender);
        textViewStudentDetailsWeight = (TextView)rootView.findViewById(R.id.textViewStudentDetailsWeight);
        textViewStudentDetailsHeight = (TextView)rootView.findViewById(R.id.textViewStudentDetailsHeight);
        textViewStudentDetailsDOB = (TextView)rootView.findViewById(R.id.textViewAddStudentDOB);
        textViewStudentDetailsHome = (TextView)rootView.findViewById(R.id.textViewStudentDetailsHome);
        textViewStudentDetailsMobile = (TextView)rootView.findViewById(R.id.textViewStudentDetailsMobile);
        textViewStudentDetailsRank = (TextView)rootView.findViewById(R.id.textViewStudentDetailsRank);

        //Set textview data to the info given from Student.
        textViewStudentDetailsFirstName.setText(student.getFirstName());
        textViewStudentDetailsLastName.setText(student.getLastName());
        textViewStudentDetailsGender.setText(student.getGenderName());
        textViewStudentDetailsWeight.setText(Double.toString(student.getWeight()));
        textViewStudentDetailsHeight.setText(Double.toString(student.getHeight()));
        textViewStudentDetailsDOB.setText(student.getDateOfBirth());
        textViewStudentDetailsHome.setText(student.getHomePhone());
        textViewStudentDetailsMobile.setText(student.getMobileNo());
        textViewStudentDetailsRank.setText(student.getCurrentRankName());

        return rootView;
    }
}
