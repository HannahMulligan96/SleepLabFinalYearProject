package com.nci.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reading  from firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("led"); //Led database


        myRef.setValue(0);


        //Led on
        myButton = (Button) findViewById(R.id.ledButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefLed = database.getReference("led");
                myRefLed.setValue(1);
            }
        });


        //Led off
        myButton = (Button) findViewById(R.id.ledButtonOff);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefLed = database.getReference("led");
                myRefLed.setValue(0);
            }
        });

        //Buzzer on
        myButton = (Button) findViewById(R.id.buzzerOn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBuzzer = database.getReference("buzzer");
                myRefBuzzer.setValue(1);
            }
        });


        //buzzer off
        myButton = (Button) findViewById(R.id.buzzerOff);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBuzzer = database.getReference("buzzer");
                myRefBuzzer.setValue(0);
            }
        });

        //blink the buzzer on
        myButton = (Button) findViewById(R.id.blinkOn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBlink = database.getReference("BlinkBuzzer");
                myRefBlink.setValue(1);
            }
        });


        //Blink the buzzer off
        myButton = (Button) findViewById(R.id.blinkOff);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefBlink = database.getReference("blinkBuzzer");
                myRefBlink.setValue(0);
            }
        });


    }

    //Sensor readings
    public void onClickReadings(View v) {
        Intent myIntent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(myIntent);
    }
}
