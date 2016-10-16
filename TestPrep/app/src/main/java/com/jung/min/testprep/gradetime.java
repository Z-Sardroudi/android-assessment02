package com.jung.min.testprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gradetime extends Activity {
    /**
     * Called when the activity is first created.
     * This class is not used in the revision 15/10/2016. Just kept in case in future Client will need to run multiple rank at the same time [Zahra Sardroudi]
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradetime);

        Button btn = (Button) findViewById(R.id.gradeButton);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(gradetime.this, grade_rank.class);
                startActivity(intent);
            }
        });
         }
}