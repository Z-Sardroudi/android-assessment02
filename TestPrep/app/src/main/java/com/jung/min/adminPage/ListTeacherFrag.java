package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Teacher;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class ListTeacherFrag extends Fragment {

    private static final int DELETE_TEACHER = 0;
    ListView listView;
    ArrayAdapter<Teacher> adapter;
    ArrayList<Teacher> list;

    public ListTeacherFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_listteacher, container, false);
        listView = (ListView)rootView.findViewById(R.id.listViewTeacher);

        DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
        list = dbHandler.listTeachers();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        return rootView;
    }

    /**
     * This Method allows a popup menu list to appear on screen displaying options for within the Teacher Fragment
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Teacher teacher = (Teacher) listView.getItemAtPosition(info.position);

        menu.add(menu.NONE, DELETE_TEACHER, menu.NONE, "Delete Teacher - " + teacher.getId());
    }

    /**
     * This Method will give cases of different options and also invoke a command
     * Specifically this will allow the user to delete a teacher within the list
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_TEACHER:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Teacher object to be accessed
                Teacher teacher = (Teacher) listView.getItemAtPosition(info.position); //Create a Teacher for the Teacher given at info.position
                DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
                dbHandler.deleteTeacher(teacher.getId());
                list.remove(info.position);
                adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }
}

