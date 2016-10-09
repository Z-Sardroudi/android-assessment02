package com.jung.min.testprep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zac Hooper on 20/05/16.
 * Used to display the Students details better
 */
public class StudentListAdapter extends ArrayAdapter {

    ArrayList list;

    public StudentListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public StudentListAdapter(Context context, int resource, ArrayList list) {
        super(context, resource, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.student_list_adapter, null);
        }

        Student p = (Student) getItem(position);

        if (p != null) {
            TextView name = (TextView) v.findViewById(R.id.textViewListAdapterName);
            TextView age = (TextView) v.findViewById(R.id.textViewListAdapterAge);
            TextView height = (TextView) v.findViewById(R.id.textViewListAdapterHeight);
            TextView weight = (TextView) v.findViewById(R.id.textViewListAdapterWeight);

            //Set Text
            String fullName = p.getLastName() + ", " + p.getFirstName();
            name.setText(fullName);
            age.setText(Integer.toString(p.getAge()));
            height.setText(Double.toString(p.getHeight()));
            weight.setText(Double.toString(p.getWeight()));
        }


        return v;
    }
}
