package com.jung.min.adminPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jung.min.testprep.DBHandler;
import com.jung.min.testprep.R;
import com.jung.min.testprep.Teacher;

/**
 * Created by Zac Hooper on 9/05/16.
 */
public class AddTeacherFrag extends Fragment {

    EditText editTextFirstName;
    EditText editTextLastName;
    EditText editTextUsername;
    EditText editTextPassword;
    Button btnAddTeacher;

    public AddTeacherFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.admin_page_addteacher, container, false);

        editTextFirstName = (EditText)rootView.findViewById(R.id.editTextAddTeacherFirstName);
        editTextLastName = (EditText)rootView.findViewById(R.id.editTextAddTeacherLastName);
        editTextUsername = (EditText)rootView.findViewById(R.id.editTextAddTeacherusername);
        editTextPassword = (EditText)rootView.findViewById(R.id.editTextAddTeacherPassword);
        btnAddTeacher = (Button)rootView.findViewById(R.id.buttonAddTeacher);

        //Create onClickListener for button - Add the teacer
        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get data from editText and put into a Teacher object
                Teacher teacher = new Teacher(0, editTextFirstName.getText().toString(), editTextLastName.getText().toString(),
                        editTextUsername.getText().toString(), editTextPassword.getText().toString());
                DBHandler dbHandler = new DBHandler(getContext(),null,null,1);
                dbHandler.addTeacher(teacher);
                //reset fields
                editTextFirstName.setText("");
                editTextLastName.setText("");
                editTextUsername.setText("");
                editTextPassword.setText("");
            }
        });

        return rootView;
    }
}
