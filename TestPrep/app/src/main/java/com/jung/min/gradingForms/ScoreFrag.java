package com.jung.min.gradingForms;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jung.min.testprep.R;

import java.io.Serializable;

/**
 * Created by Zac Hooper on 25/05/16.
 */
public class ScoreFrag extends Fragment {

    TextView currentScore;
    TextView totalScore;

    public ScoreFrag() {
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        setCurrentScore(Integer.toString(args.getInt("currentScore")));
        setTotalScore(Integer.toString(args.getInt("totalScore")));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grading_page_score, container, false);

        currentScore = (TextView)rootView.findViewById(R.id.textViewScore);
        totalScore = (TextView)rootView.findViewById(R.id.textViewOutOfScore);

        return rootView;
    }

    public void changeScore(int num) {
        currentScore.setText(Integer.toString(num));
    }

    public int getCurrentScore() {
        int score = Integer.parseInt(currentScore.getText().toString());
        return score;
    }

    public int getTotalScore() {
        String num = totalScore.getText().toString();
        int score = Integer.parseInt(num.substring(1));
        return score;
    }

    public void setCurrentScore(String currentScore) {
        this.currentScore.setText(currentScore);
    }

    public void setTotalScore(String totalScore) {
        this.totalScore.setText(totalScore);
    }

    /**
     * method that checks whether the student is currently passing or failing.
     * Checks by seeing if currentScore is more than half of totalScore.
     * @return Pass (False = fail & true = pass)
     */
    public boolean checkPassFail() {
        boolean pass = false;
        int currentScore = getCurrentScore();
        int totalScore = getTotalScore();
        if (currentScore != 0 && totalScore != 0) {
            if ( currentScore >= (totalScore / 2)) {
                pass = true;
            }
        }
        return pass;
    }

    /**
     * This method requires the parameter be a #...... colour
     * @param colour
     */
    public void setCurrentScoreColour(String colour) {
        currentScore.setTextColor(Color.parseColor(colour));
    }



}

