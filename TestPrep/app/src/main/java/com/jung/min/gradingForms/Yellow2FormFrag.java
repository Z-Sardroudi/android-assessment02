package com.jung.min.gradingForms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.RatingCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.jung.min.testprep.R;

/**
 * Created by Zac Hooper on 21/05/16.
 */
public class Yellow2FormFrag extends FormFrag{

    //Declare Rating Bars & submit button
    RatingBar manor, blocks, taeguk1, taeguk2Count, taeguk2Free, stances, kicks, backStance;
    RatingBar turnSideKick, strikes, turnHeelKick, sparring, boxing, slideSide, korean;
    RatingBar wrist1, wrist2, wrist3, wrist4,slideFront, slideRound, kihap, fight1, fight2;
    RatingBar atkComb;
    Button submit;

    public Yellow2FormFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grading_page_yellow_2, container, false);
        //init rating bars
        manor = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Manor);
        blocks = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Blocks);
        taeguk1 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2TaegukForm);
        taeguk2Count = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2TaegukCount);
        taeguk2Free = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2TaegukFree);
        stances = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Stances);
        kicks = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Kicks);
        backStance = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2BackStance);
        turnSideKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2TurnSideKick);
        strikes = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Strikes);
        turnHeelKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2TurnHeelKick);
        sparring = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2OneStep);
        boxing = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Boxing);
        slideFront = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2SlideHeelKick);
        slideRound = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2SlideRoundKick);
        slideSide = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2SlideSideKick);
        korean = (RatingBar)rootView.findViewById(R.id.ratingBar1Yellow2Korean);
        kihap = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Kihap);
        atkComb = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2AtkComb);
        wrist1 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Wrist1);
        wrist2 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Wrist2);
        wrist3 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Wrist3);
        wrist4 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Wrist4);
        fight1 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2flighting1);
        fight2 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow2Fighting2);

        submit = (Button)rootView.findViewById(R.id.buttonYellow2Submit);
        //create listeners for rating bars
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
        taeguk1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taeguk2Count.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taeguk2Free.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        kicks.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        backStance.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        turnSideKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        turnHeelKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        slideRound.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        slideSide.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        slideFront.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        korean.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        atkComb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        fight1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        fight2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        total += taeguk1.getRating();
        total += taeguk2Count.getRating();
        total += taeguk2Free.getRating();
        total += stances.getRating();
        total += kicks.getRating();
        total += backStance.getRating();
        total += turnSideKick.getRating();
        total += strikes.getRating();
        total += turnHeelKick.getRating();
        total += sparring.getRating();
        total += boxing.getRating();
        total += slideSide.getRating();
        total += korean.getRating();
        total += wrist4.getRating();
        total += wrist1.getRating();
        total += wrist2.getRating();
        total += wrist3.getRating();
        total += slideFront.getRating();
        total += slideRound.getRating();
        total += kihap.getRating();
        total += atkComb.getRating();
        total += fight2.getRating();
        total += fight1.getRating();

        return total;
    }

    public int totalRatings() {
        int total = 0;
        total += manor.getNumStars();
        total += blocks.getNumStars();
        total += taeguk1.getNumStars();
        total += taeguk2Count.getNumStars();
        total += taeguk2Free.getNumStars();
        total += stances.getNumStars();
        total += kicks.getNumStars();
        total += backStance.getNumStars();
        total += turnSideKick.getNumStars();
        total += strikes.getNumStars();
        total += turnHeelKick.getNumStars();
        total += sparring.getNumStars();
        total += boxing.getNumStars();
        total += slideSide.getNumStars();
        total += korean.getNumStars();
        total += wrist4.getNumStars();
        total += wrist1.getNumStars();
        total += wrist2.getNumStars();
        total += wrist3.getNumStars();
        total += slideFront.getNumStars();
        total += slideRound.getNumStars();
        total += kihap.getNumStars();
        total += atkComb.getNumStars();
        total += fight2.getNumStars();
        total += fight1.getNumStars();
        return total;
    }

}
