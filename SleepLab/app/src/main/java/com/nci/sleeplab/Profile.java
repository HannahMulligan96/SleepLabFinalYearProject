package com.nci.sleeplab;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.Menu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class Profile extends AppCompatActivity {

    //firebase authentication
    private FirebaseAuth firebaseAuth;

    private Button buttonLogout;
    private TextView textViewUserEmail;
    private ImageView DataView;
    private ImageView UserView;
    private ImageView diaryView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //initializing firebase authentication
        firebaseAuth = FirebaseAuth.getInstance();
        buttonLogout = (Button) findViewById(R.id.buttonLogout);


        //Firebase authentication
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        // buttonLogout = (Button) findViewById(R.id.buttonLogout);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("welcome  " + user.getEmail());

        //Set onclick to images
        DataView = (ImageView) findViewById(R.id.DataOnClick);
        UserView = (ImageView) findViewById(R.id.UserOnClick);
        diaryView = (ImageView) findViewById(R.id.diaryOnClick);


        //logs user out of system
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });


        //Data  activity
        DataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), CollectedData.class);
                startActivity(myIntent);
            }


        });


        //User activity
        UserView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), User.class);
                startActivity(myIntent);
            }


        });

        //Diary activity
        diaryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Log.class);
                startActivity(myIntent);
            }


        });


    }


    //Menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    //Menu settings on select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, settings.class);
                this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}





