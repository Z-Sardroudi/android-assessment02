package com.jung.min.gradingForms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.jung.min.testprep.R;

/**
 * Created by Zac Hooper on 21/05/16.
 */
public class Yellow3FormFrag extends FormFrag{

    //Declare Rating Bars & submit button
    RatingBar manor, blocks, taeguk2, taeguk3Count, taeguk3Free, stances, kicks, punches;
    RatingBar turnSideKick, strikes, turnHeelKick, sparring, outBlock, heelSwingKick, korean;
    RatingBar wrist14, wrist5, wrist6, frontKick, roundTurnKick, kihap, fight1, fight2;
    RatingBar atkComb;
    Button submit;

    public Yellow3FormFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grading_page_yellow_3, container, false);
        //init rating bars
        manor = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Manor);
        blocks = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Blocks);
        taeguk2 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Taeguk2Form);
        taeguk3Count = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3TaegukCount);
        taeguk3Free = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3TaegukFree);
        stances = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Stances);
        kicks = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Kicks);
        punches = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Punches);
        turnSideKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3TurnSideKick);
        strikes = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Strikes);
        turnHeelKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3TurnHeelKick);
        sparring = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3OneStep);
        outBlock = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3OutsideBlock);
        frontKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3AtkCombFrontKick);
        roundTurnKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3TurnRoundhouseKick);
        heelSwingKick = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3SlideSwingKick);
        korean = (RatingBar)rootView.findViewById(R.id.ratingBar1Yellow3Korean);
        kihap = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Kihap);
        atkComb = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3AtkComb);
        wrist14 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Wrist14);
        wrist5 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Wrist5);
        wrist6 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Wrist6);
        fight1 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3flighting1);
        fight2 = (RatingBar)rootView.findViewById(R.id.ratingBarYellow3Fighting2);

        submit = (Button)rootView.findViewById(R.id.buttonYellow3Submit);
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
        taeguk2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taeguk3Count.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        taeguk3Free.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        punches.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        outBlock.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        roundTurnKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        heelSwingKick.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        wrist14.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((onRatingChangedListener) getActivity()).OnRatingChanged(sumRatings());
            }
        });
        wrist6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
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
        total += taeguk2.getRating();
        total += taeguk3Count.getRating();
        total += taeguk3Free.getRating();
        total += stances.getRating();
        total += kicks.getRating();
        total += punches.getRating();
        total += turnSideKick.getRating();
        total += strikes.getRating();
        total += turnHeelKick.getRating();
        total += sparring.getRating();
        total += outBlock.getRating();
        total += heelSwingKick.getRating();
        total += korean.getRating();
        total += wrist14.getRating();
        total += wrist5.getRating();
        total += wrist6.getRating();
        total += frontKick.getRating();
        total += roundTurnKick.getRating();
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
        total += taeguk2.getNumStars();
        total += taeguk3Count.getNumStars();
        total += taeguk3Free.getNumStars();
        total += stances.getNumStars();
        total += kicks.getNumStars();
        total += punches.getNumStars();
        total += turnSideKick.getNumStars();
        total += strikes.getNumStars();
        total += turnHeelKick.getNumStars();
        total += sparring.getNumStars();
        total += outBlock.getNumStars();
        total += heelSwingKick.getNumStars();
        total += korean.getNumStars();
        total += wrist14.getNumStars();
        total += wrist5.getNumStars();
        total += wrist6.getNumStars();
        total += frontKick.getNumStars();
        total += roundTurnKick.getNumStars();
        total += kihap.getNumStars();
        total += atkComb.getNumStars();
        total += fight2.getNumStars();
        total += fight1.getNumStars();
        return total;
    }

}
