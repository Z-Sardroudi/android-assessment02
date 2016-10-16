package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.Rank;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.R.attr.id;
import static com.jung.min.testprep.R.id.spinnerAddStudentRank;

/**
 * Created by Zac Hooper on 9/05/16.
 * Improved by Zahra Sardroudi 15/10/2016:
 *      1- add loadSpinnerData method to set spinner values from database
 */
public class AddStudentFrag extends Fragment {

    EditText editTextFirstName;
    EditText editTextLastName;
    Spinner spinnerGender;
    EditText editTextWeight;
    EditText editTextHeight;
    EditText editTextDOB;
    EditText editTextMobile;
    EditText editTextHome;
    Spinner spinnerCurrentRank;
    Button buttonAddStudent;
    private DBHandler dbHandler;


    public AddStudentFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dbHandler = new DBHandler(getContext(),null,null,12);

        View rootView = inflater.inflate(R.layout.admin_page_addstudent, container, false);
        //initialising the objects on screen
        editTextFirstName = (EditText)rootView.findViewById(R.id.editTextAddStudentFirstName);
        editTextLastName = (EditText)rootView.findViewById(R.id.editTextAddStudentLastName);
        spinnerGender = (Spinner)rootView.findViewById(R.id.spinnerAddStudentGender);
        //code to make spinner work
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.gender_choices,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
        editTextWeight = (EditText)rootView.findViewById(R.id.editTextAddStudentWeight);
        editTextHeight = (EditText)rootView.findViewById(R.id.editTextAddStudentHeight);
        editTextDOB = (EditText)rootView.findViewById(R.id.editTextAddStudentDOB);
        editTextMobile = (EditText)rootView.findViewById(R.id.editTextAddStudentMobilePhone);
        editTextHome = (EditText)rootView.findViewById(R.id.editTextAddStudentHomePhone);
        spinnerCurrentRank = (Spinner)rootView.findViewById(spinnerAddStudentRank);
        //get list of ranks from database
        ArrayList<Rank> rankList ;
        rankList = dbHandler.listRank();
        //load list of ranks to the spinner
        loadSpinnerData(spinnerCurrentRank, rankList);

        buttonAddStudent = (Button)rootView.findViewById(R.id.ButtonAddStudent);

        buttonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the date
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(editTextDOB.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Rank rank = (Rank)spinnerCurrentRank.getSelectedItem();
                //create Student
                Student student = new Student(0,
                        editTextFirstName.getText().toString(),
                        editTextLastName.getText().toString(),
                        spinnerGender.getSelectedItemPosition(),
                        Double.parseDouble(editTextWeight.getText().toString()),
                        Double.parseDouble(editTextHeight.getText().toString()),
                        date,
                        editTextMobile.getText().toString(),
                        editTextHome.getText().toString(),
                        rank);
                //Add student into DB

                dbHandler.addStudent(student);

                //rest fields
                editTextFirstName.setText("");
                editTextLastName.setText("");
                editTextWeight.setText("");
                editTextHeight.setText("");
                editTextDOB.setText("");
                editTextMobile.setText("");
                editTextHome.setText("");
            }
        });


        return rootView;
    }

    private void loadSpinnerData(Spinner spinner, List<Rank> spinnerList){

        //create adapter for spinner. will use ToString method of Rank, to get string values of Object Rank and put them into the Adapter
        ArrayAdapter<Rank> dataAdapter;
        dataAdapter = new ArrayAdapter<Rank>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerList);

        // Drop down layout style - list view with dropdown
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }




}
