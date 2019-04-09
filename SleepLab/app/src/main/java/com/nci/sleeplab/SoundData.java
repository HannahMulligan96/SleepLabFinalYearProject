package com.nci.sleeplab;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class SoundData extends AppCompatActivity {

    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Sound";



    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounddata);

        myDateView = (TextView) findViewById(R.id.dateView);
        myMonthView = (TextView) findViewById(R.id.monthView);


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

        //Setting day and month
        myDateView.setText(Integer.toString(mDay));
        myMonthView.setText((curMonth));


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefSound = database.getReference("SoundValues");

        myRefSound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barSound1= dataSnapshot.child("Monday/Sound1").getValue(Integer.class);
                final Integer barSound2= dataSnapshot.child("Monday/Sound2").getValue(Integer.class);
                final Integer barSound3= dataSnapshot.child("Monday/Sound3").getValue(Integer.class);
                barChart = (BarChart) findViewById(R.id.bargraph);


                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barSound1, 0));
                barEntries.add(new BarEntry(barSound2, 1));
                barEntries.add(new BarEntry(barSound3, 2));
                barEntries.add(new BarEntry(371f, 3));
                barEntries.add(new BarEntry(389f, 5));
                barEntries.add(new BarEntry(395f, 6));
                barEntries.add(new BarEntry(409f, 7));
                BarDataSet barDataSet = new BarDataSet(barEntries, "Sound Values");

                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theLight = new ArrayList<>();
                theLight.add("1:00");
                theLight.add("2:00");
                theLight.add("3:00");
                theLight.add("4:00");
                theLight.add("5:00");
                theLight.add("6:00");
                theLight.add("7:00");


                BarData theData = new BarData(theLight, barDataSet);
                barChart.setData(theData);
                barChart.setTouchEnabled(false);
             //barChart.getDescription().setEnabled(false);

            }



            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}