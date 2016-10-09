package com.jung.min.testprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gradetime extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradetime);

        Button btn = (Button) findViewById(R.id.button5);
        Button btn2 = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(gradetime.this, grade_timetable.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(gradetime.this, grade_rank.class);
                startActivity(intent);
            }
        });
         }
}