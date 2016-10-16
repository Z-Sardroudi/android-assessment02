package com.jung.min.testprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jung.min.StudentList.StudentListPage;

import java.util.List;
/**
 * Created by ??.
 * Improved by Zahra Sardroudi 15/10/2016:
 *      1- Change listViewGrade items from an array of strings, to get populated from database (new method: loadRankList)
 *      2- Pass selected Rank object to next activity
 *
 */
public class grade_rank extends Activity {
    public ListView listViewGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_rank);

        // Get ListView object from xml
        listViewGrade = (ListView) findViewById(R.id.timetable_list);
        final DBHandler dbHandler = new DBHandler(this,null,null,12);
        // Loading list of existing ranks into listview
        loadRankList(listViewGrade, dbHandler.listRank());

/*
        // Defined Array values to show in ListView
        String[] values = new String[]{
                "White Belt",
                "Yellow Belt 1 Stripe",
                "Yellow Belt 2 Stripe",
                "Yellow Belt 3 Stripe",
                "Blue Belt 1 Stripe",
                "Blue Belt 2 Stripe",
                "Blue Belt 3 Stripe"

        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listViewGrade.setAdapter(adapter);

*/

        listViewGrade.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // which rank is selected
                Rank selectedRank = (Rank) listViewGrade.getItemAtPosition(position);
                Intent newActivity = new Intent(grade_rank.this, StudentListPage.class);
                newActivity.putExtra("rank", selectedRank);     //will pass rank as an object to the next activity
                startActivity(newActivity);
            }
            @SuppressWarnings("unused")
            public void onClick(View v) {
            };
         });

    }//end oncreate

    private void loadRankList(ListView listView, List<Rank> rankList){

        //create adapter for listview. will use ToString method of Rank, to get string values of Object Rank and put them into the Adapter
        ArrayAdapter<Rank> dataAdapter;
        dataAdapter = new ArrayAdapter<Rank>(this, android.R.layout.simple_list_item_1, android.R.id.text1, rankList);

        // attaching data adapter to spinner
        listView.setAdapter(dataAdapter);
    }


}//endactivity
