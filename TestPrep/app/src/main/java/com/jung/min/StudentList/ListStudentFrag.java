package com.jung.min.StudentList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jung.min.gradingForms.GradingFormPage;
import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;
import com.jung.min.testprep.StudentListAdapter;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class ListStudentFrag extends Fragment {

    private static final int GRADE_STUDENT = 0;
    private static final int STUDENT_DETAILS = 1;
    private static final int STUDENT_GRADINGS = 2;
    ListView listView;
    ArrayAdapter<Student> adapter;
    ArrayList<Student> list;

    public ListStudentFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_liststudent, container, false);
        listView = (ListView)rootView.findViewById(R.id.listViewStudent);

        DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
        list = dbHandler.listStudents();
        StudentListAdapter adapter = new StudentListAdapter(getContext(), R.layout.student_list_adapter, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        dbHandler.close();

        return rootView;
    }

    /**
     * This Method allows a popup menu list to appear on screen displaying options for within the Student Fragment
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Student Student = (Student) listView.getItemAtPosition(info.position);

        menu.add(Menu.NONE, GRADE_STUDENT, Menu.NONE, "Grade Student");
        menu.add(Menu.NONE, STUDENT_DETAILS, Menu.NONE, "See Details of " + Student.getLastName());
        menu.add(Menu.NONE, STUDENT_GRADINGS, Menu.NONE, "See Previous Gradings of " + Student.getLastName());

    }

    /**
     * This Method will give cases of different options and also invoke a command
     * Specifically this will allow the user to delete a Student within the list
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case GRADE_STUDENT:

                //Start Grading Activity with Student selected passed in Intent
                AdapterView.AdapterContextMenuInfo info =  //Allow for Student to be accessed
                        (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //Store Student
                Student student = (Student) listView.getItemAtPosition(info.position);
                Intent intent = new Intent(getActivity(), GradingFormPage.class);
                intent.putExtra("student", student);
                startActivity(intent);
                break;

            case STUDENT_DETAILS:

                //Display the Student Details in a pop up Dialog
                FragmentManager fragmentManager = getFragmentManager();
                AdapterView.AdapterContextMenuInfo info2 =
                        (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Student object to be accessed
                Student student2 = (Student) listView.getItemAtPosition(info2.position); //Create a Student for the Student given at info.position
                StudentDetailsDialog studentDetailsDialog = StudentDetailsDialog.newInstance(student2);
                studentDetailsDialog.show(fragmentManager, "StudentDetails");
                break;

            case STUDENT_GRADINGS:
                FragmentManager fragmentManager2 = getFragmentManager();
                AdapterView.AdapterContextMenuInfo info3 =
                        (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Student object to be accessed
                Student student3 = (Student) listView.getItemAtPosition(info3.position); //Create a Student for the Student given at info.position
                StudentGradingDialog studentGradingDialog = StudentGradingDialog.newInstance(student3);
                studentGradingDialog.show(fragmentManager2, "grading");
                break;
        }
        return super.onContextItemSelected(item);
    }
}

