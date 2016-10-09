package com.jung.min.testprep;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Zac Hooper on 20/05/16.
 */
public class HeaderFrag extends Fragment {

    TextView username;
    Button logout;
    SharedPreferences preferences;

    public HeaderFrag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_header, container, false);
        //Initilise Variables
        username = (TextView)rootView.findViewById(R.id.textViewHeaderUsername);
        logout = (Button)rootView.findViewById(R.id.buttonHeaderLogout);

        //User Information
        preferences = this.getActivity() //Fragment not a context therefore must call getActivity()
                .getSharedPreferences("teacherDetails", Context.MODE_PRIVATE);
        username.setText(preferences.getString("username", null));

        //log user out - return to login page - clear sharedPreferences
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        return rootView;
    }

    public void logout() {
        new AlertDialog.Builder(getActivity())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Logout")
                .setMessage("Are you sure you would like to Logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Clear SharedPreference
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.commit();
                        //Transistion back to LoginPage
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
