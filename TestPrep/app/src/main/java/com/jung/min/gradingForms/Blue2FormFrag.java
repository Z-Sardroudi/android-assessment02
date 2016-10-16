package com.jung.min.gradingForms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.jung.min.testprep.R;

import java.util.ArrayList;

/**
 * Created by Zahra Sardroudi on 16/10/1016.
 * Completed by Joseph Vaneli on ??
 */
public class Blue2FormFrag extends FormFrag{

    //Declare Rating Bars & submit button
    private ArrayList<RatingBar> ratingbar;
    Button submit;

    public Blue2FormFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grading_page_blue_2, container, false);

        //init rating bars
        ratingbar = new ArrayList<RatingBar>();

        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar011));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar012));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar013));

        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar021));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar022));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar023));

        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar031));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar032));
        ratingbar.add((RatingBar)rootView.findViewById(R.id.ratingBar033));



        submit = (Button)rootView.findViewById(R.id.buttonBlue1Submit);
        //create listeners for rating bars
        for (RatingBar bar: ratingbar ) {
            bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
                }
            });
        }

        return rootView;
    }


    public int sumRatings() {
        int total = 0;

        for (RatingBar bar: ratingbar ) {
            total += bar.getRating();
        }
        return total;
    }

    public int totalRatings() {
        int total = 0;

        for (RatingBar bar: ratingbar ) {
            total += bar.getNumStars();
        }
        return total;
    }

}
