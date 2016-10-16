package com.jung.min.testprep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zac Hooper on 20/05/16.
 * Used to display the Students details better
 */
public class GradingListAdapter extends ArrayAdapter {

    ArrayList list;

    public GradingListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public GradingListAdapter(Context context, int resource, ArrayList list) {
        super(context, resource, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.grading_list_adapter, null);
        }

        Grading p = (Grading) getItem(position); //get Grading object from the arraylist argument
        //find related Student
        DBHandler dbHandler = new DBHandler(getContext(), null, null, 0);
        Student s = dbHandler.findStudentByID(p.getStudID());

        if (p != null) {
            TextView name = (TextView) v.findViewById(R.id.textViewListAdapterName);
            TextView rank = (TextView) v.findViewById(R.id.textViewListAdapterRank);
            TextView score = (TextView) v.findViewById(R.id.textViewListAdapterScore);
            TextView passFail = (TextView) v.findViewById(R.id.textViewListAdapterPassFail);

            //Set Text
            String fullName = s.getLastName() + ", " + s.getFirstName();
            name.setText(fullName);
            rank.setText(p.getGradeName());
            score.setText(Integer.toString(p.getScore()));
            passFail.setText(p.getPassFail());
        }

        dbHandler.close();
        return v;
    }
}
