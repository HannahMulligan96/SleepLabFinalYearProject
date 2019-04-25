package com.nci.sleeplab;

import android.graphics.Color;
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

public class HumData extends AppCompatActivity {

    BarChart barChart;
    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Hum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hum_data);


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
        DatabaseReference myRefSound = database.getReference("HumValues");

        myRefSound.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barHum1= dataSnapshot.child("Hum/Hum1").getValue(Integer.class);
                final Integer barHum2= dataSnapshot.child("Hum/Hum2").getValue(Integer.class);
                final Integer barHum3= dataSnapshot.child("Hum/Hum3").getValue(Integer.class);
                barChart = (BarChart) findViewById(R.id.bargraph);


                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barHum1, 0));
                barEntries.add(new BarEntry(barHum2, 1));
                barEntries.add(new BarEntry(barHum3, 2));
                barEntries.add(new BarEntry(30f, 3));
                barEntries.add(new BarEntry(30f, 4));
                barEntries.add(new BarEntry(23f, 5));
                barEntries.add(new BarEntry(12f, 6));
               // barEntries.add(new BarEntry(409f, 7));
               // barEntries.add(new BarEntry(409f, 8));
               // barEntries.add(new BarEntry(409f, 9));
               //barEntries.add(new BarEntry(409f, 10));

                BarDataSet barDataSet = new BarDataSet(barEntries, "Humidity Values");

                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theHum= new ArrayList<>();
                theHum.add("11:00");
                theHum.add("12:00");
                theHum.add("1:00");
                theHum.add("2:00");
                theHum.add("3:00");
                theHum.add("4:00");
               // theHum.add("5:00");
               // theHum.add("6:00");
               // theHum.add("7:00");
               // theHum.add("8:00");

                //specifications for graphs
                BarData theData = new BarData(theHum, barDataSet);
                barChart.setData(theData);
                barChart.setTouchEnabled(false);


            }



            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}