package com.jung.min.adminPage;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class SpinnerGender extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getSelectedItemPosition()) {
            case 0:
                //code for male
            case 1:
                //code for female
            case 2:
                //code for other
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
