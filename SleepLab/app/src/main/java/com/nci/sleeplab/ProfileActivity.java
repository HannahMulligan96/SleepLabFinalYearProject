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

public class ProfileActivity extends AppCompatActivity {

    //firebase authentication
    private FirebaseAuth firebaseAuth;

    private Button buttonLogout;
    private TextView textViewUserEmail;
    private ImageView lightView;
    private ImageView TempView;
    private ImageView HumView;
    private ImageView SoundView;

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

        lightView = (ImageView) findViewById(R.id.lightOnClick);
        TempView = (ImageView) findViewById(R.id.TempOnClick);
        HumView = (ImageView) findViewById(R.id.HumOnClick);
        SoundView = (ImageView) findViewById(R.id.SoundOnClick);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });


        //Light activity
        lightView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Light.class);
                startActivity(myIntent);
            }


        });

        //Temperature  activity
        TempView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), RoomTemp.class);
                startActivity(myIntent);
            }


        });


        //Hum activity
        HumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Hum.class);
                startActivity(myIntent);
            }


        });

        //Sound activity
        SoundView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Sound.class);
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





