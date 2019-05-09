package com.nci.sleeplab;

import android.app.TimePickerDialog;
import android.content.Context;
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


public class userdata extends AppCompatActivity  {


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
    private Button myButton2;

    TextView mTimeTextView;
    Button mtime;

    TextView mTime2TextView;
    Button mtime2;

    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);


        mTimeTextView = findViewById(R.id.bedTime);
        Calendar calendar =Calendar.getInstance();
        final int hour =calendar.get(Calendar.HOUR_OF_DAY);
        final int minute =calendar.get(Calendar.MINUTE);

        mtime = findViewById(R.id.bedButton);

        mtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTimeTextView.setText(hourOfDay + ":" + minute);
                    }
                },hour, minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();

            }
        });

        mTime2TextView = findViewById(R.id.sleepTime);
        Calendar calendar2 =Calendar.getInstance();
        final int hour2 =calendar2.get(Calendar.HOUR_OF_DAY);
        final int minute2 =calendar2.get(Calendar.MINUTE);

        mtime2 = findViewById(R.id.sleepButton);

        mtime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTime2TextView.setText(hourOfDay + ":" + minute);
                    }
                },hour2, minute2,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();

            }
        });


        //Sending user data to firebase save button
        myButton = findViewById(R.id.logButton);
        myButton.setOnClickListener(new View.OnClickListener() {

            final EditText myText1 = findViewById(R.id.sleepHours);
            final TextView myText2 = findViewById(R.id.bedTime);
            final TextView myText3 = findViewById(R.id.sleepTime);

            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRefHours = database.getReference().child("UserData").child("/Data/HoursSlept");
                DatabaseReference myRefBed = database.getReference().child("UserData").child("Data/BedTime");
                DatabaseReference myRefSleep = database.getReference().child("UserData").child("Data/SleepTime");
                myRefHours.setValue(myText1.getText().toString().trim());
                myRefBed.setValue(myText2.getText().toString().trim());
                myRefSleep.setValue(myText3.getText().toString().trim());
            }




        });

        myButton2 = findViewById(R.id.saveButton);
        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Profile.class);
                startActivity(myIntent);
            }


        });


        //Displaying month and day
        myDateView = findViewById(R.id.dateView);
        myMonthView = findViewById(R.id.monthView);
        mysleepTime = findViewById(R.id.sleepTime);
        myBedTime = findViewById(R.id.bedTime);
        mysleepHours = findViewById(R.id.sleepHours);


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




}