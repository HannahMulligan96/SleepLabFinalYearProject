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

public class RoomTempData extends AppCompatActivity {

    private int mYear;
    private int mMonth;
    private Integer mDay;
    private String curMonth;
    private TextView myDateView;
    private TextView myMonthView;
    private static final String TAG = "Temp";

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefTemp = database.getReference("TempValues");

        myRefTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final Integer barTemp1= dataSnapshot.child("Temp/Temp1").getValue(Integer.class);
                final Integer barTemp2= dataSnapshot.child("Temp/Temp2").getValue(Integer.class);
                final Integer barTemp3= dataSnapshot.child("Temp/Temp3").getValue(Integer.class);
                final Integer barTemp4= dataSnapshot.child("Temp/Temp4").getValue(Integer.class);
                final Integer barTemp5= dataSnapshot.child("Temp/Temp5").getValue(Integer.class);
                final Integer barTemp6= dataSnapshot.child("Temp/Temp6").getValue(Integer.class);
                final Integer barTemp7= dataSnapshot.child("Temp/Temp7").getValue(Integer.class);
                final Integer barTemp8= dataSnapshot.child("Temp/Temp8").getValue(Integer.class);
                final Integer barTemp9= dataSnapshot.child("Temp/Temp9").getValue(Integer.class);
                final Integer barTemp10= dataSnapshot.child("Temp/Temp10").getValue(Integer.class);



                ArrayList<BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(barTemp1, 0));
                barEntries.add(new BarEntry(barTemp2, 1));
                barEntries.add(new BarEntry(barTemp3, 2));
                barEntries.add(new BarEntry(barTemp4, 3));
                barEntries.add(new BarEntry(barTemp5, 4));
                barEntries.add(new BarEntry(barTemp6, 5));
                barEntries.add(new BarEntry(barTemp7, 6));
                barEntries.add(new BarEntry(barTemp8, 7));
                barEntries.add(new BarEntry(barTemp9, 8));
                barEntries.add(new BarEntry(barTemp10, 9));

                setContentView(R.layout.activity_room_temp_data);

                barChart = findViewById(R.id.bargraph);

                barChart.setTouchEnabled(false);
                barChart.setNoDataText("Loading graph data");
                BarDataSet barDataSet = new BarDataSet(barEntries, "Temp Values in degrees");


                barDataSet.setColors(new int[]{Color.rgb(164, 198, 57)});

                ArrayList<String> theTemp = new ArrayList<>();
                theTemp.add("11");
                theTemp.add("12");
                theTemp.add("1");
                theTemp.add("2");
                theTemp.add("3");
                theTemp.add("4");
                theTemp.add("5");
                theTemp.add("6");
                theTemp.add("7");
                theTemp.add("8");


                BarData theData = new BarData(theTemp, barDataSet);
                barChart.setData(theData);
                //barChart.getDescription().setEnabled(false);


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