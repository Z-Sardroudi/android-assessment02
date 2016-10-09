package com.jung.min.adminPage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import com.jung.min.testprep.R;
import com.jung.min.testprep.Teacher;

public class AdminPage extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        //recieve information about current Teacher
        Intent intent = getIntent();
        Teacher t = (Teacher)intent.getSerializableExtra("teacher");
        //create bundle to pass onto menu fragment
        Bundle bundle = new Bundle();
        MenuFragment menuFragment = new MenuFragment();
        bundle.putSerializable("teacher", t);
        menuFragment.setArguments(bundle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.menuContainer, menuFragment).commit();
        }
    }

}
