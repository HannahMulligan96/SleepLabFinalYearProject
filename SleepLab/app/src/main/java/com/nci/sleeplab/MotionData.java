package com.nci.sleeplab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class MotionData extends AppCompatActivity {

    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Motion";

    BarChart barChart;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_data);



        myDateView = findViewById(R.id.dateView);
        myMonthView = findViewById(R.id.monthView);

        saveView = findViewById(R.id.save);

        //save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), CollectedData.class);
                startActivity(myIntent);
            }


        });




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
        DatabaseReference myRefMotion = database.getReference("MotionValues");

        myRefMotion.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barMotion1= dataSnapshot.child("Monday/Motion1").getValue(Integer.class);
                final Integer barMotion2= dataSnapshot.child("Monday/Motion2").getValue(Integer.class);
                // final Integer barSound3= dataSnapshot.child("Monday/Sound3").getValue(Integer.class);
                barChart = findViewById(R.id.bargraph);


                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barMotion1, 0));
                barEntries.add(new BarEntry(barMotion2, 1));
                //barEntries.add(new BarEntry(barSound3, 2));
                barEntries.add(new BarEntry(371f, 2));
                barEntries.add(new BarEntry(371f, 3));
                barEntries.add(new BarEntry(389f, 5));
                barEntries.add(new BarEntry(395f, 6));
                barEntries.add(new BarEntry(409f, 7));
                BarDataSet barDataSet = new BarDataSet(barEntries, "Motion Values");

                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theMotion = new ArrayList<>();
                theMotion.add("1:00");
                theMotion.add("2:00");
                theMotion.add("3:00");
                theMotion.add("4:00");
                theMotion.add("5:00");
                theMotion.add("6:00");
                theMotion.add("7:00");


                BarData theData = new BarData(theMotion, barDataSet);
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