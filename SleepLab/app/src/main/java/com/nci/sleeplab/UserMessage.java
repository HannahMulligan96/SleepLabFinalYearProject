package com.nci.sleeplab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMessage extends AppCompatActivity {


    private Button buttonAdd;
    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);


        buttonAdd = findViewById(R.id.addButton);
        buttonBack = findViewById(R.id.backButton);

        //Buttons on click
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Log.class);
                startActivity(myIntent);
            }


        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Profile.class);
                startActivity(myIntent);
            }


        });
    }
}
