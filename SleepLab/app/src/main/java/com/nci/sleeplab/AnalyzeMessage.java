package com.nci.sleeplab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalyzeMessage extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonAnalyze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_message);

        buttonBack = (Button) findViewById(R.id.backButton2);
        buttonAnalyze = (Button) findViewById(R.id.analyzeButton);

        //back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Profile.class);
                startActivity(myIntent);
            }


        });
        //analyze data
        buttonAnalyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), AnalyzeCalendar.class);
                startActivity(myIntent);
            }


        });
    }
}
