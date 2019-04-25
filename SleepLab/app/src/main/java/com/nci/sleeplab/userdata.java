package com.nci.sleeplab;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class userdata extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    private TextView myDateView;
    private TextView myMonthView;
    private TextView mysleepTime;
    private TextView myBedTime;
    private TextView mysleepHours;
    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);


        //Time picker widget on click listener for button
        Button button = (Button) findViewById(R.id.selectBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker1 = new TimePickerFragment();
                timePicker1.show(getSupportFragmentManager(), "time picker1");



            }
        });

        //Time picker widget on click listener for button
        Button button1 = (Button) findViewById(R.id.selectBtn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment timePicker2 = new TimePickerFragmentTwo();
                timePicker2.show(getSupportFragmentManager(), "time picker2");

            }
        });


        //Sending user dat to firebase save button
        myButton = (Button) findViewById(R.id.saveButton);
        myButton.setOnClickListener(new View.OnClickListener() {

            final EditText myText1 = findViewById(R.id.sleepHours);
            final TextView myText2 = findViewById(R.id.bedTime);
            final TextView myText3 = findViewById(R.id.sleepTime);

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefHours = database.getReference().child("UserData").child("HoursSlept");
                DatabaseReference myRefBed = database.getReference().child("UserData").child("BedTime");
                DatabaseReference myRefSleep = database.getReference().child("UserData").child("SleepTime");
                myRefHours.setValue(myText1.getText().toString().trim());
                myRefBed.setValue(myText2.getText().toString().trim());
                myRefSleep.setValue(myText3.getText().toString().trim());
            }
        });


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Log.class);
                startActivity(myIntent);
            }


        });


        //Displaying month and day
        myDateView = (TextView) findViewById(R.id.dateView);
        myMonthView = (TextView) findViewById(R.id.monthView);
        mysleepTime = (TextView) findViewById(R.id.sleepTime);
        myBedTime = (TextView) findViewById(R.id.bedTime);
        mysleepHours = (TextView) findViewById(R.id.sleepHours);


        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        if (mMonth == 0) {
            curMonth = "Jan";
        } else if (mMonth == 1) {
            curMonth = "February";
        } else if (mMonth == 2) {
            curMonth = "March";
        } else if (mMonth == 3) {
            curMonth = "April";
        } else if (mMonth == 4) {
            curMonth = "May";
        } else if (mMonth == 5) {
            curMonth = "June";
        } else if (mMonth == 6) {
            curMonth = "July";
        } else if (mMonth == 7) {
            curMonth = "August";
        } else if (mMonth == 8) {
            curMonth = "September";
        } else if (mMonth == 9) {
            curMonth = "October";
        } else if (mMonth == 10) {
            curMonth = "November";
        } else if (mMonth == 11) {
            curMonth = "December";
        }


        myDateView.setText(Integer.toString(mDay));
        myMonthView.setText((curMonth));

    }


    //Setting the time selected by the user to the views
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

//        mysleepTime.setText("" + hourOfDay + ":" + minute);
        mysleepTime.setText("Test" );
        myBedTime.setText("test2");
//        myBedTime.setText("" + hourOfDay + ":" + minute);
    }




}