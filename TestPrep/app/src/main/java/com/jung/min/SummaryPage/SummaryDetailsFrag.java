package com.jung.min.SummaryPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jung.min.gradingForms.ScoreFrag;
import com.jung.min.testprep.R;

/**
 * Created by Zac Hooper on 25/05/16.
 */
public class SummaryDetailsFrag extends Fragment {

    //create variables for dynamic objects on screen
    TextView weight;
    TextView height;
    TextView currentRank;
    TextView studentName;
    TextView age;

    public SummaryDetailsFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.summary_page_details, container, false);

        //initialise dynamic objects on Screen
        weight = (TextView) rootView.findViewById(R.id.textViewSummaryWeightChange);
        height = (TextView) rootView.findViewById(R.id.textViewSummaryHeightChange);
        currentRank = (TextView) rootView.findViewById(R.id.textViewSummaryRankChange);
        studentName = (TextView) rootView.findViewById(R.id.textViewSummaryName);
        age = (TextView) rootView.findViewById(R.id.textViewSummaryAgeChange);

        return rootView;
    }

}
