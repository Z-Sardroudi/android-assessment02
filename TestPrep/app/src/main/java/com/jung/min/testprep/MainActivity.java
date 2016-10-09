package com.jung.min.testprep;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jung.min.StudentList.StudentListPage;
import com.jung.min.adminPage.AdminPage;

public class MainActivity extends AppCompatActivity {


    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogin;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editText_Username);
        editTextPassword = (EditText) findViewById(R.id.editText_Password);
        buttonLogin = (Button) findViewById(R.id.Button_Login);
        //create preferences - used to store currently logged in user
        preferences = this.getSharedPreferences("teacherDetails", MODE_PRIVATE);

    }


    public void login(View view) {
        String username = editTextUsername.getText().toString(); //get Username & password from editText box
        String password = editTextPassword.getText().toString();
        DBHandler dbHandler = new DBHandler(this, null, null, 7);
        Teacher t = dbHandler.findTeacher(username, password);
        Log.i("Login: ","Trying to login with " + username);

        if (username.equals("Admin") && password.equals("Admin"))
        {

            Intent intent = new Intent(this, AdminPage.class);
            //intent.putExtra("teacher", t); //passes the teacher object to next activity
            startActivity(intent);

        }
        else
        {
            if (t == null) //if T is null no match came back, therefore incorrect username or password.
            {
                Toast.makeText(this, "Login failed - Username Wrong", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                //Add User into SharedPreferences
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", t.getUsername());
                editor.apply();

                //Transistion to next screen
                Intent intent = new Intent(this, gradetime.class);
                startActivity(intent);
            }
        }

    }

    public void clear(View view) {
        editTextUsername.setText("");
        editTextPassword.setText("");
    }
}
