package com.jung.min.gradingForms;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;

import org.w3c.dom.Text;

/**
 * Created by Zac Hooper on 20/05/16.
 */
public class StudentDetailsVerticalFrag extends Fragment {

    //create variables for dynamic objects on screen
    TextView weight;
    TextView height;
    TextView currentRank;
    TextView studentName;
    TextView age;

    public StudentDetailsVerticalFrag() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //create View
        View rootView = inflater.inflate(R.layout.grading_page_student_details, container, false);

        //initialise dynamic objects on Screen
        weight = (TextView) rootView.findViewById(R.id.textViewStudDetWeightChange);
        height = (TextView) rootView.findViewById(R.id.textViewStudDetHeightChange);
        currentRank = (TextView) rootView.findViewById(R.id.textViewStudDetRankChange);
        studentName = (TextView) rootView.findViewById(R.id.textViewStudentName);
        age = (TextView) rootView.findViewById(R.id.textViewStudDetAgeChange);

        return rootView;
    }
}