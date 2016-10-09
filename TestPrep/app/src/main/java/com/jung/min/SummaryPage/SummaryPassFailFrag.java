package com.jung.min.SummaryPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jung.min.testprep.Grading;
import com.jung.min.testprep.R;

/**
 * Created by Zac Hooper on 25/05/16.
 */
public class SummaryPassFailFrag extends Fragment{


    TextView passFail;

    public SummaryPassFailFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.summary_page_passfail, container, false);

        passFail = (TextView)rootView.findViewById(R.id.textViewContinuePassFail);

        return rootView;
    }

    public void setPassFail(boolean passFail) {
        if (passFail) {
            this.passFail.setText("Pass");
        }
        else
        {
            this.passFail.setText("Fail");
        }
    }
}
