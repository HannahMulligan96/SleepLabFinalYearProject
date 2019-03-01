package com.nci.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    private TextView tempView;
    private TextView lightView;
    private TextView soundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tempView = (TextView) findViewById(R.id.tempView);
        lightView = (TextView) findViewById(R.id.lightView);
        soundView = (TextView) findViewById(R.id.soundView);

        //Reading  from firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefTemp = database.getReference("temp"); //Temp database
        DatabaseReference myRefLight = database.getReference("light"); //Light database
        DatabaseReference myRefSound = database.getReference("sound"); //Sound database

        //pulling temp value from database and displaying as a textview
        myRefTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Integer value = dataSnapshot.getValue(Integer.class);
                tempView.setText("Current Temp is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

        //pulling light value from database and displaying as a textview
        myRefLight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Integer value = dataSnapshot.getValue(Integer.class);
                lightView.setText("Current light is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

        //pulling sound value from database and displaying as a textview
        myRefSound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Integer value = dataSnapshot.getValue(Integer.class);
                soundView.setText("Current sound is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });


    }

    //Sensor states
    public void onClickState(View v) {
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }
}
