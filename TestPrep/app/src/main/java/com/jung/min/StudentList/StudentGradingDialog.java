package com.jung.min.StudentList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Grading;
import com.jung.min.testprep.GradingListAdapter;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;
import com.jung.min.testprep.StudentListAdapter;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 10/05/16.
 */
public class StudentGradingDialog extends DialogFragment {

    Student student;
    Grading grading;
    ListView listView;
    ArrayList<Grading> list;

    public static StudentGradingDialog newInstance(Student student) { //passes the student as an argument - allows for Student object to be used
        Bundle args = new Bundle();

        StudentGradingDialog fragment = new StudentGradingDialog();
        args.putSerializable("grading", student);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = (Student) getArguments().getSerializable("grading"); //stores the student from the newInstance
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.student_gradings_dialog, container, false); //how to link XML to java code

        listView = (ListView)rootView.findViewById(R.id.listViewGradingDialog);

        DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
        list = dbHandler.listStudentGrading(student);
        GradingListAdapter adapter = new GradingListAdapter(getContext(), R.layout.grading_list_adapter, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        dbHandler.close();


        return rootView;
    }
}
