package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Grading;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Grading;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class ListGradingFrag extends Fragment {

    private static final int DELETE_GRADING = 0;
    ListView listView;
    ArrayAdapter<Grading> adapter;
    ArrayList<Grading> list;

    public ListGradingFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_listgrading, container, false);
        listView = (ListView)rootView.findViewById(R.id.listViewGrading);

        DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
        list = dbHandler.listGradings();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        dbHandler.close();

        return rootView;
    }

    /**
     * This Method allows a popup menu list to appear on screen displaying options for within the Grading Fragment
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Grading grading = (Grading) listView.getItemAtPosition(info.position);

        menu.add(Menu.NONE, DELETE_GRADING, Menu.NONE, "Delete Grading - " + grading.getId());
    }

    /**
     * This Method will give cases of different options and also invoke a command
     * Specifically this will allow the user to delete a grading within the list
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_GRADING:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //allow for a Grading object to be accessed
                Grading grading = (Grading) listView.getItemAtPosition(info.position); //Create a Grading for the Grading given at info.position
                DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
                dbHandler.deleteGrading(grading.getId());
                list.remove(info.position);
                adapter.notifyDataSetChanged();
                dbHandler.close();
        }
        return super.onContextItemSelected(item);
    }
}

