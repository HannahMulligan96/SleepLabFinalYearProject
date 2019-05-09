package com.nci.sleeplab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class CollectedData extends AppCompatActivity {


    private ImageView lightView;
    private ImageView TempView;
    private ImageView HumView;
    private ImageView SoundView;
    private ImageView MotionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collected_data);

        //Onclick
        lightView = findViewById(R.id.lightOnClick);
        TempView = findViewById(R.id.TempOnClick);
        HumView = findViewById(R.id.HumOnClick);
        SoundView = findViewById(R.id.SoundOnClick);
        MotionView = findViewById(R.id.MotionOnClick);


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


        //Motion activity
        MotionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Motion.class);
                startActivity(myIntent);
            }


        });
    }



    //Home icon actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    //Home icon on select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}