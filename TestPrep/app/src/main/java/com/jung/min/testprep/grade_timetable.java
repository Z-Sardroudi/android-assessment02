package com.jung.min.testprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jung.min.StudentList.StudentListPage;
import com.jung.min.adminPage.AdminPage;

public class grade_timetable extends Activity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_timetable);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.timetable_list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "8:00am - 8:45am",
                "8:45am - 9:30am",
                "9:40am - 10:30am",
                "10:30am - 12:00pm",
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch(position){

                    case 1:
                        Intent newActivity = new Intent(grade_timetable.this, StudentListPage.class);
                        startActivity(newActivity);
                        break;

                    case 2:
                        Intent Activitytwo = new Intent(grade_timetable.this, StudentListPage.class);
                        startActivity(Activitytwo);
                        break;

                    case 3:Toast.makeText(getApplicationContext(),
                            "  Not Available ", Toast.LENGTH_LONG)
                            .show();
                    case 0:Toast.makeText(getApplicationContext(),
                            "  Not Available ", Toast.LENGTH_LONG)
                            .show();

                }

            }
            @SuppressWarnings("unused")
            public void onClick(View v){
            };
        });

    }//end oncreate


}//endactivity