package com.jung.min.testprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class grade_rank extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_rank);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.timetable_list);

        // Defined Array values to show in ListView
        String[] values = new String[]{"White Belt",
                "Yellow Belt 1 Stripe",
                "Yellow Belt 2 Stripe",
                "Yellow Belt 3 Stripe",


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
                        // ListView Clicked item value
                        String itemValue = (String) listView.getItemAtPosition(position);


                        switch (position) {

                            case 1:
                                Intent newActivity = new Intent(grade_rank.this, grade_timetable.class);
                                startActivity(newActivity);
                                break;

                            case 2:
                                Intent newActivityTwo = new Intent(grade_rank.this, grade_timetable.class);
                                startActivity(newActivityTwo);
                                break;

                            case 3:
                                Intent newActivityThree = new Intent(grade_rank.this, grade_timetable.class);
                                startActivity(newActivityThree);
                                break;
                            case 0:Toast.makeText(getApplicationContext(),
                                    "  Not Available ", Toast.LENGTH_LONG)
                                    .show();
                        }

                    }

                    @SuppressWarnings("unused")
                    public void onClick(View v) {
                    }

                    ;
                });

            }//end oncreate


        }//endactivity
