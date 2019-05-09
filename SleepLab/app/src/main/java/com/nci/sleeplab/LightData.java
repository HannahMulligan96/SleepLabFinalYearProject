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

public class LightData extends AppCompatActivity {

    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Light";

    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefLight = database.getReference("LightValues");

        myRefLight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barLight1 = dataSnapshot.child("Light/Light1").getValue(Integer.class);
                final Integer barLight2 = dataSnapshot.child("Light/Light2").getValue(Integer.class);
                final Integer barLight3 = dataSnapshot.child("Light/Light3").getValue(Integer.class);
                final Integer barLight4 = dataSnapshot.child("Light/Light4").getValue(Integer.class);
                final Integer barLight5 = dataSnapshot.child("Light/Light5").getValue(Integer.class);
                final Integer barLight6 = dataSnapshot.child("Light/Light6").getValue(Integer.class);
                final Integer barLight7 = dataSnapshot.child("Light/Light7").getValue(Integer.class);
                final Integer barLight8 = dataSnapshot.child("Light/Light8").getValue(Integer.class);
                final Integer barLight9 = dataSnapshot.child("Light/Light9").getValue(Integer.class);
                final Integer barLight10 = dataSnapshot.child("Light/Light10").getValue(Integer.class);
                // barChart = findViewById(R.id.bargraph);


                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barLight1, 0));
                barEntries.add(new BarEntry(barLight2, 1));
                barEntries.add(new BarEntry(barLight3, 2));
                barEntries.add(new BarEntry(barLight4, 3));
                barEntries.add(new BarEntry(barLight5, 4));
                barEntries.add(new BarEntry(barLight6, 5));
                barEntries.add(new BarEntry(barLight7, 6));
                barEntries.add(new BarEntry(barLight8, 7));
                barEntries.add(new BarEntry(barLight9, 8));
                barEntries.add(new BarEntry(barLight10, 9));
                BarDataSet barDataSet = new BarDataSet(barEntries, "Light Values");



        setContentView(R.layout.activity_light_data);

        barChart = findViewById(R.id.bargraph);

        barChart.setTouchEnabled(false);
        barChart.setNoDataText("Loading graph data");

                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theLight = new ArrayList<>();
                theLight.add("11 / 12");
                theLight.add("12");
                theLight.add("1 / 2");
                theLight.add("2");
                theLight.add("3 / 4");
                theLight.add("4");
                theLight.add("5 / 6");
                theLight.add("6");
                theLight.add("7 / 8");
                theLight.add("8");


                BarData theData = new BarData(theLight, barDataSet);
                barChart.setData(theData);


                myDateView = findViewById(R.id.dateView);
                myMonthView = findViewById(R.id.monthView);


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

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

}