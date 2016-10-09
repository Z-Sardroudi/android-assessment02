package com.jung.min.adminPage;

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

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;
import com.jung.min.StudentList.StudentDetailsDialog;
import com.jung.min.testprep.StudentListAdapter;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class AdminListStudentFrag extends Fragment {

    private static final int DELETE_STUDENT = 0;
    private static final int STUDENT_DETAILS = 1;
    ListView listView;
    ArrayAdapter<Student> adapter;
    ArrayList<Student> list;

    public AdminListStudentFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_liststudent, container, false);
        listView = (ListView)rootView.findViewById(R.id.listViewStudent);

        DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
        list = dbHandler.listStudents();
        ListAdapter adapter = new StudentListAdapter(getContext(), R.layout.student_list_adapter, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

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

        menu.add(Menu.NONE, DELETE_STUDENT, Menu.NONE, "Delete Student - " + Student.getLastName());
        menu.add(Menu.NONE, STUDENT_DETAILS, Menu.NONE, "See Details of " + Student.getLastName());
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
            case DELETE_STUDENT:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Student object to be accessed
                Student Student = (Student) listView.getItemAtPosition(info.position); //Create a Student for the Student given at info.position
                DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
                dbHandler.deleteStudent(Student.getId());
                list.remove(info.position);
                adapter.notifyDataSetChanged();
                dbHandler.close();
                break;

            case STUDENT_DETAILS:
                FragmentManager fragmentManager = getFragmentManager();
                AdapterView.AdapterContextMenuInfo info2 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Student object to be accessed
                Student student2 = (Student) listView.getItemAtPosition(info2.position); //Create a Student for the Student given at info.position
                StudentDetailsDialog studentDetailsDialog = StudentDetailsDialog.newInstance(student2);
                studentDetailsDialog.show(fragmentManager, "StudentDetails");
        }
        return super.onContextItemSelected(item);
    }
}

