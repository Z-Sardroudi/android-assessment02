package com.jung.min.gradingForms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.jung.min.testprep.R;

/**
 * Created by Zac Hooper on 20/05/16.
 */
public class Yellow1FormFrag extends FormFrag {

    //create Rating Bars
    RatingBar manor;
    RatingBar blocks;
    RatingBar basicForm;
    RatingBar stances;
    RatingBar knife;
    RatingBar taegukCount;
    RatingBar shortPunch;
    RatingBar axe;
    RatingBar taegukFree;
    RatingBar strikes;
    RatingBar frontKick;
    RatingBar oneStep;
    RatingBar triplePunch;
    RatingBar sideKick;
    RatingBar sparring;
    RatingBar boxing;
    RatingBar roundhouse;
    RatingBar kihap;

    Button submit;

    public Yellow1FormFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grading_page_yellow_1, container, false);

        //init RatingBars
        manor = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Manor);
        blocks = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Blocks);
        basicForm = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1BasicForm);
        stances = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Stances);
        knife = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Knife);
        taegukCount = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1TaegukCount);
        taegukFree = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1TaegukFree);
        shortPunch = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1ShortPunch);
        axe = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Axe);
        strikes = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Strikes);
        frontKick = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1FrontKick);
        oneStep = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1OneStep);
        triplePunch = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1TriplePunch);
        sideKick = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1SideKick);
        sparring = (RatingBar) rootView.findViewById(R.id.ratingBar1Yellow1Sparring);
        boxing = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Boxing);
        roundhouse = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1RoundhouseKick);
        kihap = (RatingBar) rootView.findViewById(R.id.ratingBarYellow1Kihap);
        submit = (Button) rootView.findViewById(R.id.buttonYellow1Submit);

        //Create ratingBarChangeEvents
        manor.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        blocks.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        basicForm.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        stances.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        knife.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taegukCount.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taegukFree.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        shortPunch.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        axe.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        strikes.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        frontKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        oneStep.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        triplePunch.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        sideKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        sparring.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        boxing.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        roundhouse.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        kihap.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });

        return rootView;
    }

    public int sumRatings() {
        int total = 0;
        total += manor.getRating();
        total += blocks.getRating();
        total += basicForm.getRating();
        total += stances.getRating();
        total += knife.getRating();
        total += taegukCount.getRating();
        total += taegukFree.getRating();
        total += shortPunch.getRating();
        total += axe.getRating();
        total += strikes.getRating();
        total += frontKick.getRating();
        total += oneStep.getRating();
        total += triplePunch.getRating();
        total += sideKick.getRating();
        total += sparring.getRating();
        total += boxing.getRating();
        total += roundhouse.getRating();
        total += kihap.getRating();
        return total;
    }

    public int totalRatings() {
        int total = 0;
        total += manor.getNumStars();
        total += blocks.getNumStars();
        total += basicForm.getNumStars();
        total += stances.getNumStars();
        total += knife.getNumStars();
        total += taegukCount.getNumStars();
        total += taegukFree.getNumStars();
        total += shortPunch.getNumStars();
        total += axe.getNumStars();
        total += strikes.getNumStars();
        total += frontKick.getNumStars();
        total += oneStep.getNumStars();
        total += triplePunch.getNumStars();
        total += sideKick.getNumStars();
        total += sparring.getNumStars();
        total += boxing.getNumStars();
        total += roundhouse.getNumStars();
        total += kihap.getNumStars();
        return total;
    }



}
