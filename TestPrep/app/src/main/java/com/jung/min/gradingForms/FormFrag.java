package com.jung.min.gradingForms;

import android.support.v4.app.Fragment;

/**
 * Created by Zac Hooper on 21/05/16.
 *
 * This class is the parent class to all forms. This allows for all childs to implement the interface.
 */

public abstract class FormFrag extends Fragment{

    public FormFrag() {
    }

    public interface onRatingChangedListener {
        void OnRatingChanged(int score);
    }

    public abstract int sumRatings();

    public abstract int totalRatings();

}
