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


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefSound = database.getReference("SoundValues");

        myRefSound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barSound1= dataSnapshot.child("Sound/Sound1").getValue(Integer.class);
                final Integer barSound2= dataSnapshot.child("Sound/Sound2").getValue(Integer.class);
                final Integer barSound3= dataSnapshot.child("Sound/Sound3").getValue(Integer.class);
                final Integer barSound4= dataSnapshot.child("Sound/Sound4").getValue(Integer.class);
                final Integer barSound5= dataSnapshot.child("Sound/Sound5").getValue(Integer.class);
                final Integer barSound6= dataSnapshot.child("Sound/Sound6").getValue(Integer.class);
                final Integer barSound7= dataSnapshot.child("Sound/Sound7").getValue(Integer.class);
                final Integer barSound8= dataSnapshot.child("Sound/Sound8").getValue(Integer.class);
                final Integer barSound9= dataSnapshot.child("Sound/Sound9").getValue(Integer.class);
                final Integer barSound10= dataSnapshot.child("Sound/Sound10").getValue(Integer.class);
                barChart = findViewById(R.id.bargraph);


                ArrayList<BarEntry> barEntries = new ArrayList<>();


                barEntries.add(new BarEntry(barSound1, 0));
                barEntries.add(new BarEntry(barSound2, 1));
                barEntries.add(new BarEntry(barSound3, 2));
                barEntries.add(new BarEntry(barSound4, 3));
                barEntries.add(new BarEntry(barSound5, 4));
                barEntries.add(new BarEntry(barSound6, 5));
                barEntries.add(new BarEntry(barSound7, 6));
                barEntries.add(new BarEntry(barSound8, 7));
                barEntries.add(new BarEntry(barSound9, 8));
                barEntries.add(new BarEntry(barSound10, 9));
                setContentView(R.layout.activity_sounddata);

                barChart = findViewById(R.id.bargraph);

                barChart.setTouchEnabled(false);
                barChart.setNoDataText("Loading graph data");
                BarDataSet barDataSet = new BarDataSet(barEntries, "Sound Values");

                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theSound= new ArrayList<>();
                theSound.add("11");
                theSound.add("12");
                theSound.add("1");
                theSound.add("2");
                theSound.add("3");
                theSound.add("4");
                theSound.add("5");
                theSound.add("6");
                theSound.add("7");
                theSound.add("8");


                BarData theData = new BarData(theSound, barDataSet);
                barChart.setData(theData);


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
                myDateView = findViewById(R.id.dateView);
                myMonthView = findViewById(R.id.monthView);

                //Setting day and month
                myDateView.setText(Integer.toString(mDay));
                myMonthView.setText((curMonth));

            }



            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}